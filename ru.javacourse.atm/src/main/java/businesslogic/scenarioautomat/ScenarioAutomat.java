package businesslogic.scenarioautomat;

import businesslogic.useraction.*;
import hardware.adapter.HardwareDecoratorAdapter;
import lombok.NonNull;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ScenarioAutomat {
    @NonNull
    private List<Action> actions;

    private Action getLastAction(){
        return actions.get(actions.size() - 1);
    }

    private ActionProcedureResult executeLastAction() {
        return actions.get(actions.size() - 1).executeAction();
    }

    private void addSelfCheckActionIfNeed(@NonNull InputStream in, @NonNull PrintStream out, @NonNull HardwareDecoratorAdapter hardwareDecoratorAdapter) {
        if (actions.size() == 0) {
            actions.add(new Action(
                    ActionTypes.SelfCheck, 1, new SelfCheck(), in, out, hardwareDecoratorAdapter)
            );
        }
    }
    private ActionProcedure getActionProcedure(ActionTypes actionTypes) {
        switch (actionTypes) {
            case CardEnter:
                return new CardEnter();
            case PinEnter:
                return new PinEnter();
            case Hello:
                return new Hello();
            case UpdateBalance:
                return new Balance();
            case MainPage:
                return new MainPage();
            case TurnOff:
                return new TurnOff();
            default:
                return new SelfCheck();
        }
    }


    public void playScenarios(@NonNull InputStream in, @NonNull PrintStream out, @NonNull HardwareDecoratorAdapter hardwareDecoratorAdapter) {
        actions = new ArrayList<>();
        do {
            addSelfCheckActionIfNeed(in, out, hardwareDecoratorAdapter);

            ActionProcedureResult actionProcedureResult = executeLastAction();
            if (actionProcedureResult.isExtendedResult()) {
                actions.clear();
            } else {
                actions.add(new Action(actionProcedureResult.getResultActionType(), 1,
                        getActionProcedure(actionProcedureResult.getResultActionType()), in, out, hardwareDecoratorAdapter));
            }

        } while (actions.size() > 0);
    }
}

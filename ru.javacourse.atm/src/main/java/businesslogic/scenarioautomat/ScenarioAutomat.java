package businesslogic.scenarioautomat;

import businesslogic.useraction.*;
import hardware.adapter.HardwareAdapter;
import lombok.NonNull;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ScenarioAutomat {
    private List<Action> actions;

    private ActionProcedureResult executeLastAction() {
        return actions.get(actions.size() - 1).executeAction();
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


    public void playScenarios(@NonNull InputStream in, @NonNull PrintStream out, @NonNull HardwareAdapter hardwareAdapter) {
        actions = new ArrayList<>();
        do {
            if (actions.size() == 0) {
                actions.add(new Action(
                        ActionTypes.SelfCheck, 1, new SelfCheck(), in, out, hardwareAdapter)
                );
            }

            ActionProcedureResult actionProcedureResult = executeLastAction();
            if (actionProcedureResult.isExtendedResult()) {
                actions.clear();
            } else {
                actions.add(new Action(actionProcedureResult.getResultActionType(), 1,
                        getActionProcedure(actionProcedureResult.getResultActionType()), in, out, hardwareAdapter));
            }

        } while (actions.size() > 0);
    }
}

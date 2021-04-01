package businesslogic.scenarioautomat;

import businesslogic.useraction.*;
import hardware.adapter.HardwareAdapter;
import hardware.pinpad.PinPad;
import lombok.NonNull;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ScenarioAutomat {
    @NonNull
    private final List<Action> actions;

    public ScenarioAutomat() {
        actions = new ArrayList<>();
    }

    private boolean executeLastAction() {
        return actions.get(actions.size() - 1).executeAction();
    }

    private ActionTypes determineActionType() {
        if (actions.get(actions.size() - 1).getActionType() == ActionTypes.SelfCheck){
           return ActionTypes.Hello;
        } else if (actions.get(actions.size() - 1).getActionType() == ActionTypes.Hello) {
            return ActionTypes.CardEnter;
        } else if (actions.get(actions.size() - 1).getActionType() == ActionTypes.CardEnter) {
            return ActionTypes.PinEnter;
        } else if (actions.get(actions.size() - 1).getActionType() == ActionTypes.PinEnter) {
            return ActionTypes.MainPage;
        } else if (actions.get(actions.size() - 1).getActionType() == ActionTypes.MainPage) {
            return ActionTypes.UpdateBalance;
        } else if (actions.get(actions.size() - 1).getActionType() == ActionTypes.UpdateBalance) {
            return ActionTypes.MainPage;
        } else {
            return ActionTypes.SelfCheck;
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
            default:
                return new SelfCheck();
        }
    }


    public void playScenarios(@NonNull InputStream in, @NonNull PrintStream out, @NonNull HardwareAdapter hardwareAdapter) {
        do {
            if (actions.size() == 0) {
                actions.add(new Action(
                        ActionTypes.SelfCheck, 1, new SelfCheck(), in, out, hardwareAdapter)
                );
            }
            if (executeLastAction()) {
                ActionTypes type = determineActionType();
                actions.add(new Action(type, 1, getActionProcedure(type), in, out, hardwareAdapter));
            } else {
                actions.clear();
            }
        } while (actions.size() > 0);
    }
}

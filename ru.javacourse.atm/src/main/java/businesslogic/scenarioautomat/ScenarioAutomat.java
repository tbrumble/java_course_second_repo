package businesslogic.scenarioautomat;

import businesslogic.bank.ApplicationContext;
import businesslogic.useraction.*;
import hardware.adapter.HardwareDecoratorAdapter;
import lombok.NonNull;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ScenarioAutomat {
    @NonNull

    private List<UIAction> UIActions;
    @NonNull
    private final ApplicationContext applicationContext;

    public ScenarioAutomat() {
        this.applicationContext = new ApplicationContext().getInstance();
        applicationContext.fillTestData();
    }


    private UIAction getLastAction(){
        return UIActions.get(UIActions.size() - 1);
    }

    private ActionProcedureResult executeLastAction() {
        return getLastAction().executeAction();
    }

    private void addSelfCheckActionIfNeed(@NonNull InputStream in, @NonNull PrintStream out, @NonNull HardwareDecoratorAdapter hardwareDecoratorAdapter) {

        if (UIActions.size() == 0) {
            UIActions.add(new UIAction(
                    ActionTypes.SelfCheck, 1, new SelfCheck(), in, out, hardwareDecoratorAdapter, applicationContext)

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
                return new UpdateBalance();
            case MainPage:
                return new MainPage();
            case TurnOff:
                return new TurnOff();
            default:
                return new SelfCheck();
        }
    }


    public void playScenarios(@NonNull InputStream in, @NonNull PrintStream out, @NonNull HardwareDecoratorAdapter hardwareDecoratorAdapter) {
        UIActions = new ArrayList<>();
        do {
            addSelfCheckActionIfNeed(in, out, hardwareDecoratorAdapter);

            ActionProcedureResult actionProcedureResult = executeLastAction();
            if (actionProcedureResult.isExtendedResult()) {
                UIActions.clear();
            } else {
                UIActions.add(new UIAction(actionProcedureResult.getResultActionType(), 1,
                        getActionProcedure(actionProcedureResult.getResultActionType()), in, out, hardwareDecoratorAdapter,
                        applicationContext));
            }

        } while (UIActions.size() > 0);
    }
}

package businesslogic.useraction;

import businesslogic.bank.ApplicationContext;
import hardware.adapter.HardwareDecoratorAdapter;
import lombok.Getter;
import lombok.NonNull;

import java.io.InputStream;
import java.io.PrintStream;

public class UIAction {
    @NonNull
    @Getter
    private final ActionTypes actionType;
    @NonNull
    private final int priority;
    @NonNull
    private final ActionProcedure actionProcedure;
    @NonNull
    private final InputStream inputStream;
    @NonNull
    private final PrintStream printStream;
    @NonNull
    private final HardwareDecoratorAdapter hardwareDecoratorAdapter;
    @NonNull
    private final ApplicationContext applicationContext;

    public UIAction(ActionTypes actionType, int priority, ActionProcedure actionProcedure, InputStream inputStream,
                    PrintStream printStream, HardwareDecoratorAdapter hardwareDecoratorAdapter, ApplicationContext applicationContext) {
        this.actionProcedure = actionProcedure;
        this.priority = priority;
        this.actionType = actionType;
        this.inputStream = inputStream;
        this.printStream = printStream;
        this.hardwareDecoratorAdapter = hardwareDecoratorAdapter;
        this.applicationContext = applicationContext;
    }

    public ActionProcedureResult executeAction() {
        return actionProcedure.execute(inputStream, printStream, hardwareDecoratorAdapter, actionType,  applicationContext);
    }

}

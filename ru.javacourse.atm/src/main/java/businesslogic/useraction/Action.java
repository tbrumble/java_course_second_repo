package businesslogic.useraction;

import hardware.adapter.HardwareDecoratorAdapter;
import lombok.Getter;
import lombok.NonNull;

import java.io.InputStream;
import java.io.PrintStream;

public class Action {
    @NonNull
    @Getter
    private ActionTypes actionType;
    @NonNull
    private int priority;
    @NonNull
    private ActionProcedure actionProcedure;
    @NonNull
    private InputStream inputStream;
    @NonNull
    private PrintStream printStream;
    @NonNull
    private HardwareDecoratorAdapter hardwareDecoratorAdapter;

    public Action(ActionTypes actionType, int priority, ActionProcedure actionProcedure, InputStream inputStream,
                  PrintStream printStream, HardwareDecoratorAdapter hardwareDecoratorAdapter) {
        this.actionProcedure = actionProcedure;
        this.priority = priority;
        this.actionType = actionType;
        this.inputStream = inputStream;
        this.printStream = printStream;
        this.hardwareDecoratorAdapter = hardwareDecoratorAdapter;
    }

    public ActionProcedureResult executeAction() {
        return actionProcedure.execute(inputStream, printStream, hardwareDecoratorAdapter, actionType);
    }

}

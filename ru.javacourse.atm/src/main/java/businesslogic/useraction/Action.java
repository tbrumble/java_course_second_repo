package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;
import lombok.Data;
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
    private HardwareAdapter hardwareAdapter;

    public Action(ActionTypes actionType, int priority, ActionProcedure actionProcedure, InputStream inputStream,
                  PrintStream printStream, HardwareAdapter hardwareAdapter) {
        this.actionProcedure = actionProcedure;
        this.priority = priority;
        this.actionType = actionType;
        this.inputStream = inputStream;
        this.printStream = printStream;
        this.hardwareAdapter = hardwareAdapter;
    }

    public boolean executeAction() {
        return actionProcedure.execute(inputStream, printStream, hardwareAdapter, actionType);
    }

}

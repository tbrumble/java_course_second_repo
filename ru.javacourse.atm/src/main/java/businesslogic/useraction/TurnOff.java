package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;

import java.io.InputStream;
import java.io.PrintStream;

public class TurnOff extends ActionProcedure{
    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareAdapter hardwareAdapter, ActionTypes actionTypes) {
        printStream.println("Отключение банкомата");
        hardwareAdapter.turnOff();
        return new ActionProcedureResult().setExtendedResult(Boolean.TRUE).setResultActionType(ActionTypes.NullAction);
    }
}

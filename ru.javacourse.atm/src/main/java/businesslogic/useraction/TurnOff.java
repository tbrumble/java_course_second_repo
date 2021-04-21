package businesslogic.useraction;

import hardware.adapter.HardwareDecoratorAdapter;

import java.io.InputStream;
import java.io.PrintStream;

public class TurnOff extends ActionProcedure{
    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareDecoratorAdapter hardwareDecoratorAdapter, ActionTypes actionTypes) {
        printStream.println("Отключение банкомата");
        hardwareDecoratorAdapter.turnOff();
        return new ActionProcedureResult().setExtendedResult(Boolean.TRUE).setResultActionType(ActionTypes.NullAction);
    }
}

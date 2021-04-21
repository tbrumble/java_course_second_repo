package businesslogic.useraction;

import hardware.adapter.HardwareDecoratorAdapter;

import java.io.InputStream;
import java.io.PrintStream;

public class CardEnter extends ActionProcedure{
    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareDecoratorAdapter hardwareDecoratorAdapter, ActionTypes actionTypes) {
        printStream.println("ВСТАВЬТЕ КАРТУ");

        if (hardwareDecoratorAdapter.checkEnteredCard()) {
            return new ActionProcedureResult().setResultActionType(ActionTypes.PinEnter);
        } else {
            return new ActionProcedureResult().setResultActionType(ActionTypes.MainPage);
        }
    }
}

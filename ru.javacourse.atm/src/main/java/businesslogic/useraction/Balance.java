package businesslogic.useraction;

import hardware.adapter.HardwareDecoratorAdapter;

import java.io.InputStream;
import java.io.PrintStream;

public class Balance extends ActionProcedure{

    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareDecoratorAdapter hardwareDecoratorAdapter, ActionTypes actionTypes) {
        printStream.printf("Ваш баланс: %.02f %s%n", 1123.12, "RUB");
        return new ActionProcedureResult().setResultActionType(ActionTypes.MainPage);
    }
}

package businesslogic.useraction;

import businesslogic.bank.ApplicationContext;
import hardware.adapter.HardwareDecoratorAdapter;

import java.io.InputStream;
import java.io.PrintStream;

public class SelfCheck extends ActionProcedure{
    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareDecoratorAdapter hardwareDecoratorAdapter, ActionTypes actionTypes, ApplicationContext applicationContext) {
        printStream.println("ИНИЦИАЛИЗАЦИЯ БАНКОМАТА");
        printStream.println(hardwareDecoratorAdapter.toString());

        if (hardwareDecoratorAdapter.selfCheck()) {
            printStream.println("БАНКОМАТА ЗАРУЖЕН И ГОТОВ К РАБОТЕ");
            return  new ActionProcedureResult().setResultActionType(ActionTypes.Hello);
        } else {
            printStream.println("ПРОБЛЕМА С ОБОРУДОВАНИЕМ БАНКОМАТА, БАНКОМАТ БУДЕТ ВЫКЛЮЧЕН. ОБРАТИТЕСЬ В ТЕХНИЧЕСКУЮ ПОДДЕРЖКУ");
            return new ActionProcedureResult().setResultActionType(ActionTypes.TurnOff);
        }
    }
}

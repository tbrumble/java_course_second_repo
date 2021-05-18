package businesslogic.useraction;

import businesslogic.bank.ApplicationContext;
import hardware.adapter.HardwareDecoratorAdapter;
import operationresult.OperationResult;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

public class CardEnter extends ActionProcedure{
    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareDecoratorAdapter hardwareDecoratorAdapter, ActionTypes actionTypes, ApplicationContext applicationContext) {
        printStream.println("ВСТАВЬТЕ КАРТУ");
        OperationResult operationResult = new OperationResult();
        //тут идет эмуляция проверка карты - берем из тестовых данных данные карты, эмулируем возврат данных от оборудования
        if ((applicationContext.getPinCard().getNumber().length() != 16) ||
            (applicationContext.getPinCard().getExpireDate().isBefore(LocalDate.now()))) {
            operationResult.setResultText("Ошибка при проверке номера и срока действия карты");
            operationResult.setResultCodeValue(-1);
            operationResult.setResultLogicValue(Boolean.FALSE);
        }

        if (operationResult.isResultLogicValue()) {
            return new ActionProcedureResult().setResultActionType(ActionTypes.PinEnter);
        } else {
            return new ActionProcedureResult().setResultActionType(ActionTypes.MainPage);
        }
    }
}

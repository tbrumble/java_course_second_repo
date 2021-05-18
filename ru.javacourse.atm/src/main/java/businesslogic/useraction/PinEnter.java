package businesslogic.useraction;

import businesslogic.bank.ApplicationContext;
import businesslogic.bank.account.Account;
import businesslogic.bank.balance.Balance;
import hardware.adapter.HardwareDecoratorAdapter;
import operationresult.OperationResult;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

public class PinEnter extends ActionProcedure{
    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareDecoratorAdapter hardwareDecoratorAdapter, ActionTypes actionTypes, ApplicationContext applicationContext) {
        printStream.println("ВВЕДИТЕ ПИН КОД");
        Scanner scanner = new Scanner(inputStream);
        String inputResult = scanner.nextLine();

        OperationResult operationResult = new OperationResult();

        Account<Balance> account = applicationContext.getClient().getAccountByNum(applicationContext.getPinCard().getNumber());
        if (account == null) {
            operationResult.setResultText("Не найден клиент с таким номером карты");
            operationResult.setResultCodeValue(-1);
            operationResult.setResultLogicValue(Boolean.FALSE);
        }


        //тут идет эмуляция проверка карты - берем из тестовых данных данные хеш cvc и проверяем введенный пин
        if (!(applicationContext.getPinCard().getPinHash().equals(applicationContext.getStringHash(inputResult)))) {
            operationResult.setResultText("Ошибка при проверке пина и хеша cvc карты");
            operationResult.setResultCodeValue(-2);
            operationResult.setResultLogicValue(Boolean.FALSE);
        }

        if (operationResult.isResultLogicValue()) {
            return new ActionProcedureResult().setResultActionType(ActionTypes.MainPage);
        } else {
            return new ActionProcedureResult().setResultActionType(ActionTypes.Hello);
        }
    }
}

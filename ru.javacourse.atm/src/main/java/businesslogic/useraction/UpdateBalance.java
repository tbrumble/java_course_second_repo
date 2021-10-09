package businesslogic.useraction;

import businesslogic.bank.ApplicationContext;
import businesslogic.bank.account.Account;
import businesslogic.bank.balance.Balance;
import hardware.adapter.HardwareDecoratorAdapter;
import operationresult.OperationResult;

import java.io.InputStream;
import java.io.PrintStream;

public class UpdateBalance extends ActionProcedure{

    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareDecoratorAdapter hardwareDecoratorAdapter, ActionTypes actionTypes, ApplicationContext applicationContext) {

        OperationResult operationResult = new OperationResult();
        Account<Balance> account = applicationContext.getClient().getAccountByNum(
                applicationContext.getPinCard().getNumber()
        );

        if (account == null) {
            operationResult.setResultText("Ошибка при получении баланса клиента");
            operationResult.setResultCodeValue(-1);
            operationResult.setResultLogicValue(Boolean.FALSE);
        } else
        {
            printStream.printf("Номер счета: %s, Баланс: %s, %s",
                    account.getNumber(),
                    account.getBalance().getSum().toString(),
                    account.getBalance().getIsoCode()
            );
        }
        return new ActionProcedureResult().setResultActionType(ActionTypes.MainPage);
    }
}

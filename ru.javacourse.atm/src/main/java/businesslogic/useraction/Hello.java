package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Hello extends ActionProcedure{
    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareAdapter hardwareAdapter, ActionTypes actionTypes) {
        ActionProcedureResult actionProcedureResult;
        printStream.println("ДЛЯ АВТОРИЗАЦИИ В СИСТЕМЕ НАЖМИТЕ АВТОРИЗОВАТЬСЯ (введите число 1)");

        Scanner scanner = new Scanner(inputStream);
        int inputResult = scanner.nextInt();

        switch (inputResult) {
            case 1: {
                actionProcedureResult = new ActionProcedureResult().setResultActionType(ActionTypes.MainPage);
                break;
            }
            default:
                actionProcedureResult = new ActionProcedureResult().setResultActionType(ActionTypes.Hello);
            }

        return actionProcedureResult;
    }
}

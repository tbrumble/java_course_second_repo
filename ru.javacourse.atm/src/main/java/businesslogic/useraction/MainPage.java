package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MainPage extends ActionProcedure{
    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareAdapter hardwareAdapter, ActionTypes actionTypes) {
        printStream.println("Для проверки баланса - нажмите 1");
        printStream.println("Для выхода - нажмите 2");
        Scanner scanner = new Scanner(inputStream);

        ActionProcedureResult actionProcedureResult;
        int inputResult = scanner.nextInt();
        switch (inputResult) {
            case 1: {
                actionProcedureResult = new ActionProcedureResult().setResultActionType(ActionTypes.UpdateBalance);
                break;
            }
            case 2: {
                actionProcedureResult = new ActionProcedureResult().setResultActionType(ActionTypes.Hello);
                break;
            }
            default:
                actionProcedureResult = new ActionProcedureResult().setResultActionType(ActionTypes.MainPage);
        }
        return  actionProcedureResult;
    }
}

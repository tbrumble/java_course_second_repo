package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PinEnter extends ActionProcedure{
    @Override
    public ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareAdapter hardwareAdapter, ActionTypes actionTypes) {
        printStream.println("ВВЕДИТЕ ПИН КОД");
        Scanner scanner = new Scanner(inputStream);

        String inputResult = scanner.nextLine();

        if (scanner.nextLine().length() == 4) {
            return new ActionProcedureResult().setResultActionType(ActionTypes.MainPage);
        } else {
            return new ActionProcedureResult().setResultActionType(ActionTypes.Hello);
        }
    }
}

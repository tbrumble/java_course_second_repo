package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PinEnter extends ActionProcedure{
    @Override
    public boolean execute(InputStream inputStream, PrintStream printStream, HardwareAdapter hardwareAdapter, ActionTypes actionTypes) {
        printStream.println("ВВЕДИТЕ ПИН КОД");

        Scanner scanner = new Scanner(inputStream);
        if (scanner.nextLine().length() == 4) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}

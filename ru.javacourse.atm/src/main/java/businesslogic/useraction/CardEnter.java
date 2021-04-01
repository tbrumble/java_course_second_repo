package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CardEnter extends ActionProcedure{
    @Override
    public boolean execute(InputStream inputStream, PrintStream printStream, HardwareAdapter hardwareAdapter, ActionTypes actionTypes) {
        printStream.println("ВСТАВЬТЕ КАРТУ");

        if (hardwareAdapter.checkEnteredCard()) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}

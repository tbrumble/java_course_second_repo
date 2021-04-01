package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;

import java.io.InputStream;
import java.io.PrintStream;

public class Balance extends ActionProcedure{

    @Override
    public boolean execute(InputStream inputStream, PrintStream printStream, HardwareAdapter hardwareAdapter, ActionTypes actionTypes) {
        printStream.printf("Ваш баланс: %.02f %s%n", 1123.12, "RUB");
        return Boolean.TRUE;
    }
}

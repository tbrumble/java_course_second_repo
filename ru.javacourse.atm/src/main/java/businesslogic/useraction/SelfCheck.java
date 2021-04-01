package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SelfCheck extends ActionProcedure{
    @Override
    public boolean execute(InputStream inputStream, PrintStream printStream, HardwareAdapter hardwareAdapter, ActionTypes actionTypes) {
        printStream.println("ИНИЦИАЛИЗАЦИЯ БАНКОМАТА");
        printStream.println(hardwareAdapter.toString());

        if (hardwareAdapter.selfCheck()) {
            printStream.println("БАНКОМАТА ЗАРУЖЕН И ГОТОВ К РАБОТЕ");
            return Boolean.TRUE;
        } else {
            printStream.println("ПРОБЛЕМА С ОБОРУДОВАНИЕМ БАНКОМАТА, БАНКОМАТ БУДЕТ ВЫКЛЮЧЕН. ОБРАТИТЕСЬ В ТЕХНИЧЕСКУЮ ПОДДЕРЖКУ");
            hardwareAdapter.turnOff();
            return Boolean.FALSE;
        }
    }
}

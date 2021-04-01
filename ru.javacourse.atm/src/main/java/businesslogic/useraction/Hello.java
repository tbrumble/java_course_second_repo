package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Hello extends ActionProcedure{
    @Override
    public boolean execute(InputStream inputStream, PrintStream printStream, HardwareAdapter hardwareAdapter, ActionTypes actionTypes) {
        printStream.println("ДЛЯ НАЧАЛА РАБОТЫ НАЖМИТЕ СТАРТ (введите число 1)");

        Scanner scanner = new Scanner(inputStream);
        return scanner.nextInt() == 1;
    }
}

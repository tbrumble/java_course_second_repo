package businesslogic.useraction;

import hardware.adapter.HardwareAdapter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MainPage extends ActionProcedure{
    @Override
    public boolean execute(InputStream inputStream, PrintStream printStream, HardwareAdapter hardwareAdapter, ActionTypes actionTypes) {
        printStream.println("Для проверки баланса - нажмите 1");
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextInt() == 1;
    }
}

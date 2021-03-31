package java;

import java.hardware.atm.ATM;
import java.hardware.atm.ATMImpl;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATMImpl();
        System.out.println(atm.toString());
    }
}

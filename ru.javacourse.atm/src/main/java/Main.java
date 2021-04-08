import businesslogic.atm.ATM;
import businesslogic.atm.ATMImpl;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATMImpl(System.in, System.out);
        atm.doATM();
    }
}

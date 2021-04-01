import businesslogic.atm.ATMImpl;

public class Main {
    public static void main(String[] args) {
        ATMImpl atm = new ATMImpl(System.in, System.out);
        atm.workATM();
    }
}

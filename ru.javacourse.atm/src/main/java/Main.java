import businesslogic.atm.ATMWorker;
import businesslogic.atm.ATM;

public class Main {
    public static void main(String[] args) {
        ATMWorker atmWorker = new ATM(System.in, System.out);
        atmWorker.workATM();
    }
}

package hardware.adapter;

public interface HardwareDecoratorAdapter {
    void turnOff();
    boolean selfCheck();


    boolean checkEnteredCard();
}

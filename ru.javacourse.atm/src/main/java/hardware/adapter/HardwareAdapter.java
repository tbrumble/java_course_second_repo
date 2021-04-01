package hardware.adapter;

public interface HardwareAdapter {
    void turnOff();
    boolean selfCheck();


    boolean checkEnteredCard();
}

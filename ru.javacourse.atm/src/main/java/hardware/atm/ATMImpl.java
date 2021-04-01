package hardware.atm;

import hardware.Screen.Screen;
import hardware.cardreader.CardReader;
import hardware.device.Device;
import hardware.ethernet.EthernetDevice;
import hardware.pinpad.PinPad;
import hardware.receiver.ReceiverDevice;
import java.util.ArrayList;
import java.util.List;

public class ATMImpl implements ATM{
    private List<Device> devices;

    public ATMImpl() {
        //формируем и загружаем устройства банкомата
        devices = new ArrayList<>();
        devices.add(new EthernetDevice());
        devices.add(new ReceiverDevice());
        devices.add(new CardReader());
        devices.add(new PinPad());
        devices.add(new Screen());
    }

    @Override
    public String toString() {
        String resultValue = "";
        for (Device device : devices){
            resultValue.concat(device.toString());
        }
        return resultValue;
    }

    @Override
    public void turnOff() {
        devices.forEach(device -> device.turnOff());
    }

    @Override
    public boolean selfCheck() {
        boolean boolResult = Boolean.TRUE;
        for (Device device : devices){
            if (!device.isOk()) {
                boolResult = Boolean.FALSE;
                break;
            }
        }
        return boolResult;
    }
}

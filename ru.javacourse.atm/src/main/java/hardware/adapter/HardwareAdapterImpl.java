package hardware.adapter;

import hardware.screen.Screen;
import hardware.cardreader.CardReader;
import hardware.device.Device;
import hardware.ethernet.EthernetDevice;
import hardware.pinpad.PinPad;
import hardware.receiver.ReceiverDevice;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HardwareAdapterImpl implements HardwareAdapter {
    @NonNull
    private final List<Device> devices;

    private HardwareAdapterImpl instanceAdapter;

    public HardwareAdapterImpl() {
        //формируем и загружаем устройства банкомата
        devices = new ArrayList<>();
        devices.add(new EthernetDevice());
        devices.add(new ReceiverDevice());
        devices.add(new CardReader());
        devices.add(new PinPad());
        devices.add(new Screen());
    }

    public HardwareAdapter getInstance() {
        if (Objects.isNull(instanceAdapter)) {
            instanceAdapter = new HardwareAdapterImpl();
        }
        return instanceAdapter;
    }

    @Override
    public String toString() {
        String resultValue = "";
        for (Device device : devices){
            resultValue = resultValue
                    .concat(device.toString())
                    .concat("\n");
        }
        return resultValue;
    }

    @Override
    public void turnOff() {
        devices.forEach(Device::turnOff);
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

    @Override
    public boolean checkEnteredCard() {
        boolean resultCheck = Boolean.FALSE;
        for (Device device: devices){
            resultCheck = device instanceof CardReader ? ((CardReader) device).isCardOk(): Boolean.FALSE;
            break;
        }
        return resultCheck;
    }

}

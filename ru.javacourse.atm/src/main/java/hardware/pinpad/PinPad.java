package hardware.pinpad;

import hardware.device.DeviceImpl;

public class PinPad extends DeviceImpl {
    public PinPad() {
        super("Клавиатура");
    }

    public boolean IsOk(){
        //пока все ок
        return Boolean.TRUE;
    }

}

package hardware.cardreader;

import hardware.device.DeviceImpl;
import lombok.experimental.Accessors;

public class CardReader extends DeviceImpl {
    public CardReader() {
        super("Кард ридер");
    }

    //пока выводим true всегда
    public Boolean isCardOk() {
        return Boolean.TRUE;
    }
}

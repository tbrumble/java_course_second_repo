package java.hardware.device;

import java.util.UUID;

public class DeviceImpl implements Device{
    private static final String formatString = "Имя: %s, ID: %s, Статус: %s";
    private UUID deviceUuid;
    private DeviceState deviceState;
    private final String deviceName;


    public DeviceImpl(String deviceName) {
        deviceUuid = UUID.randomUUID();
        deviceState = DeviceState.Initialized;
        this.deviceName = deviceName;
    }

    public boolean isOk() {
      return deviceState.equals(DeviceState.Initialized);
    }

    @Override
    public String toString() {
         return String.format(formatString, deviceName, deviceUuid.toString(), deviceState.getStateCaption(deviceState));
    }

    public void turnOff() {
        deviceState = DeviceState.UnInitialized;
    }

    public String getDeviceName() {
        return deviceName;
    }
}

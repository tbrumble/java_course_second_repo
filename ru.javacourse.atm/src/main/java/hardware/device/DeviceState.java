package hardware.device;

public enum DeviceState {
    Initialized ("Инициализирован"),
    UnInitialized("Не инициализирован");

    private final String stateCaption;

    DeviceState(String stateCaption) {
        this.stateCaption = stateCaption;
    }

    String getStateCaption(DeviceState deviceState){
        return deviceState.stateCaption;
    }
}

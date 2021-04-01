package businesslogic.useraction;

import hardware.device.DeviceState;

public enum ActionTypes {
    UpdateBalance ("Обновление баланса"),
    ReceiveMoney("Получить деньги"),
    DepositMoney("Внести деньги"),
    SelfCheck("Проверка банкомата"),
    PinEnter("Воод пина"),
    CardEnter("Ввод карты"),
    Hello("Приветствие"),
    MainPage("Главная страница");

    private final String captionValue;

    ActionTypes(String captionValue) {
        this.captionValue = captionValue;
    }

    String getStateCaption(ActionTypes actionType){
        return actionType.captionValue;
    }
}

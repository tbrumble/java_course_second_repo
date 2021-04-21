package businesslogic.atm;

import businesslogic.scenarioautomat.ScenarioAutomat;
import hardware.adapter.HardwareDecoratorAdapter;
import hardware.adapter.HardwareDecorator;

public class ATM implements ATMWorker{
    private ScenarioAutomat scenarioAutomat;

    public void doATM() {

        HardwareDecoratorAdapter hardwareAdapter = new HardwareDecorator();
        scenarioAutomat = new ScenarioAutomat();
        do {
            scenarioAutomat.playScenarios(System.in, System.out, hardwareAdapter);
        } while (hardwareAdapter.selfCheck());
    }
}

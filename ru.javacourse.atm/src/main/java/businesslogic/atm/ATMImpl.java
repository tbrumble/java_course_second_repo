package businesslogic.atm;

import businesslogic.scenarioautomat.ScenarioAutomat;
import hardware.adapter.HardwareAdapter;
import hardware.adapter.HardwareAdapterImpl;

public class ATMImpl implements ATM{
    private ScenarioAutomat scenarioAutomat;

    public void doATM() {

        HardwareAdapter hardwareAdapter = new HardwareAdapterImpl();
        scenarioAutomat = new ScenarioAutomat();
        do {
            scenarioAutomat.playScenarios(System.in, System.out, new HardwareAdapterImpl());
        } while (hardwareAdapter.selfCheck());
    }
}

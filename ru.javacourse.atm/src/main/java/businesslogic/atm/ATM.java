package businesslogic.atm;

import businesslogic.scenarioautomat.ScenarioAutomat;
import hardware.adapter.HardwareDecoratorAdapter;
import hardware.adapter.HardwareDecoratorDecorator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.io.PrintStream;

@RequiredArgsConstructor
public class ATM implements ATMWorker {
    @NonNull
    private final HardwareDecoratorAdapter hardwareDecoratorAdapter;
    @NonNull
    private final InputStream in;
    @NonNull
    private final PrintStream out;
    @NonNull
    private final ScenarioAutomat scenarioAutomat;

    public ATM(InputStream in, PrintStream out) {
        hardwareDecoratorAdapter = new HardwareDecoratorDecorator();
        this.in = in;
        this.out = out;
        scenarioAutomat = new ScenarioAutomat();
    }

    public boolean workATM() {
        do {
            scenarioAutomat.playScenarios(in, out, hardwareDecoratorAdapter);
        } while (hardwareDecoratorAdapter.selfCheck());
        return hardwareDecoratorAdapter.selfCheck();
    }
}

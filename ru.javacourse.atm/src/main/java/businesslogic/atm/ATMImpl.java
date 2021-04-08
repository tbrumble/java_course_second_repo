package businesslogic.atm;

import businesslogic.scenarioautomat.ScenarioAutomat;
import com.sun.org.apache.xpath.internal.operations.Bool;
import hardware.adapter.HardwareAdapter;
import hardware.adapter.HardwareAdapterImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

@RequiredArgsConstructor
public class ATMImpl implements ATM{
    @NonNull
    private final HardwareAdapter hardwareAdapter;
    @NonNull
    private final InputStream in;
    @NonNull
    private final PrintStream out;
    @NonNull
    private final ScenarioAutomat scenarioAutomat;

    public ATMImpl(InputStream in, PrintStream out) {
        hardwareAdapter = new HardwareAdapterImpl();
        this.in = in;
        this.out = out;
        scenarioAutomat = new ScenarioAutomat();
    }

    public boolean doATM() {
        do {
            scenarioAutomat.playScenarios(in, out, hardwareAdapter);
        } while (hardwareAdapter.selfCheck());
        return hardwareAdapter.selfCheck();
    }
}

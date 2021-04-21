package businesslogic.useraction;

import hardware.adapter.HardwareDecoratorAdapter;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class ActionProcedure {
    public abstract ActionProcedureResult execute(InputStream inputStream, PrintStream printStream, HardwareDecoratorAdapter hardwareDecoratorAdapter, ActionTypes actionTypes);
}

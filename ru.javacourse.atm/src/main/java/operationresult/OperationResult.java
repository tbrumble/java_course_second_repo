package operationresult;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OperationResult {
    private static final int DEFAULT_CODE_VALUE = 0;
    private static final String DEFAULT_STRING_VALUE = "";

    private String resultText;
    private boolean resultLogicValue;
    private int resultCodeValue;

    private void setDefaultValues() {
        resultText = DEFAULT_STRING_VALUE;
        resultLogicValue = Boolean.TRUE;
        resultCodeValue = DEFAULT_CODE_VALUE;
    }

    public OperationResult() {
        setDefaultValues();
    }

    public OperationResult(String resultText, boolean resultLogicValue, int resultCodeValue) {
        this.resultCodeValue = resultCodeValue;
        this.resultLogicValue = resultLogicValue;
        this.resultText = resultText;
    }
}

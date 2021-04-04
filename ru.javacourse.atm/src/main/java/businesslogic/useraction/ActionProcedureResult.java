package businesslogic.useraction;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ActionProcedureResult {
    @NonNull
    ActionTypes resultActionType;
    @NonNull
    boolean extendedResult;

    public ActionProcedureResult(){
        extendedResult = Boolean.FALSE;
    }
}

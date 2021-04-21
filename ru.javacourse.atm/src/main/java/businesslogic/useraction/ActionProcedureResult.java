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
    private ActionTypes resultActionType;
    @NonNull
    private boolean extendedResult;

    public ActionProcedureResult(){
        extendedResult = false;
    }
}

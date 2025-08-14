package template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResponseDTO<RESULT> implements Serializable {

    @Serial
    private static final long serialVersionUID = 4735922150868568193L;

    private RESULT data;

    private String message;
}

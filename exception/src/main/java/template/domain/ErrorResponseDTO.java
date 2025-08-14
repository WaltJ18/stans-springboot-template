package template.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2493864551954811651L;

    private OffsetDateTime timestamp;

    private String error;

    private String path;
}

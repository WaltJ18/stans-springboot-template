package template.testing;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class TestingClientResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7571217781677063430L;

    private Long userId;

    private Long id;

    private String title;

    private String body;
}

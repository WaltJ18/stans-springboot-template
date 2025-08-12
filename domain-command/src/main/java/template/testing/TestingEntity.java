package template.testing;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TestingEntity {
//please create a simple user payment API with features:
//1. generate VA
//2. listen for payments (thirdparty can be imaginary) and save received payments to database

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("text_test")
    private String textTest;

    @JsonProperty("status_test")
    private boolean statusTest;
}

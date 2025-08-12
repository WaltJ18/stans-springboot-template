package testing;

import com.fasterxml.jackson.databind.JsonNode;

public interface RedisObject {
    Boolean saveRequest(String key, JsonNode jsonNode);
}

package testing;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RedisObjectImpl implements RedisObject{

    @Autowired
    private RedisTemplate<String, JsonNode> redisTemplate;

    @Override
    public Boolean saveRequest(String key, JsonNode jsonNode){
        Long save = redisTemplate.opsForSet().add(key, jsonNode);
        if (Objects.isNull(save)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

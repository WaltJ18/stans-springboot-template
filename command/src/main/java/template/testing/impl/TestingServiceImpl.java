package template.testing.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import template.testing.RedisObject;
import template.testing.TestingEntity;
import template.testing.TestingEntityRepository;
import template.testing.TestingService;

@Service
public class TestingServiceImpl implements TestingService {

    @Autowired
    private RedisObject redisObject;

    @Autowired
    private TestingEntityRepository repository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String saveTesting(JsonNode jsonNode){
        long count = repository.count();
        if(count == 0l ){
            count = 1l;
        }
        redisObject.saveRequest(String.valueOf(count), jsonNode);
        TestingEntity entity = objectMapper.convertValue(jsonNode, TestingEntity.class);
        repository.saveAndFlush(entity);
        return "Okay";
    }
}

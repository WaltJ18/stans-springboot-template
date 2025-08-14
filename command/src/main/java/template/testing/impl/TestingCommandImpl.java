package template.testing.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import template.AbstractCommand;
import template.testing.RedisObject;
import template.testing.primary.TestingPrimaryEntityRepository;
import template.testing.TestingCommand;
import template.testing.primary.TestingPrimaryEntity;

@Service
public class TestingCommandImpl extends AbstractCommand<JsonNode, String>
        implements TestingCommand {

    @Autowired
    private RedisObject redisObject;

    @Autowired
    private TestingPrimaryEntityRepository repository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String doExecute(JsonNode jsonNode){
        long count = repository.count();
        if(count == 0l ){
            count = 1l;
        }
        redisObject.saveRequest(String.valueOf(count), jsonNode);
        TestingPrimaryEntity entity = objectMapper.convertValue(jsonNode, TestingPrimaryEntity.class);
        repository.saveAndFlush(entity);
        return "Okay";
    }
}

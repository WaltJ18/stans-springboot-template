package template.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import template.CommandExecutor;
import template.testing.TestingCommand;

@RestController
@RequestMapping("/test")
public class TestingController {

    @Autowired
    private CommandExecutor commandExecutor;

    @PostMapping("/save")
    public String saveRedis(@RequestBody JsonNode request){
        return commandExecutor.execute(TestingCommand.class, request);
    }
}

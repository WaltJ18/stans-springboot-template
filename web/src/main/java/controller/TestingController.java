package controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestingController {

//    @Autowired
//    private Testing testingService;

//    @PostMapping("/save")
//    public String saveRedis(@RequestBody JsonNode request){
//        return testingService.saveTesting(request);
//    }
}

package team.avengers.toylog.controller;

import org.springframework.web.bind.annotation.*;
import team.avengers.toylog.model.TestResponseDto;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/test")
public class TestController {

    @GetMapping(value = "")
    public List<TestResponseDto> getAllTests(@RequestParam(required = false) String name) {
        if (name == null) {
            return null;
        }
        return null;
    }

    @GetMapping(value = "/{id}")
    public TestResponseDto getTestById(@PathVariable Long id) {
        return null;
    }
}

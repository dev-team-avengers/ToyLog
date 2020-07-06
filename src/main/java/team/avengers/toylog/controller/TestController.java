package team.avengers.toylog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.model.test.TestAddRequestDto;
import team.avengers.toylog.model.test.TestModifyRequestDto;
import team.avengers.toylog.model.test.TestResponseDto;
import team.avengers.toylog.service.test.TestRemoveService;
import team.avengers.toylog.service.test.TestSaveService;
import team.avengers.toylog.service.test.TestService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/test")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private TestSaveService testSaveService;
    @Autowired
    private TestRemoveService testRemoveService;

    @GetMapping(value = "")
    public ApiResponseDto<List<TestResponseDto>> getAllTests(@RequestParam(required = false) String name) {
        if (name == null || "".equals(name.trim())) {
            return testService.getTests();
        }
        return testService.getTestsByName(name);
    }

    @GetMapping(value = "/{id}")
    public ApiResponseDto<TestResponseDto> getTestById(@PathVariable Long id) {
        return testService.getTestById(id);
    }

    @PostMapping(value = "", consumes = "application/json")
    public ApiResponseDto<TestResponseDto> setTest(@RequestBody TestAddRequestDto testAddRequestDto) {
        return testSaveService.setTest(testAddRequestDto);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ApiResponseDto<TestResponseDto> updateTest(@PathVariable Long id,
                                                      @RequestBody TestModifyRequestDto testModifyRequestDto) {
        return testSaveService.updateTest(id, testModifyRequestDto);
    }

    @DeleteMapping(value = "/{id}")
    public ApiResponseDto<TestResponseDto> deleteTest(@PathVariable Long id){
        return testRemoveService.deleteTest(id);
    }
}

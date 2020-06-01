package team.avengers.toylog.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.avengers.toylog.advice.exception.TestNotFoundException;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.model.test.TestResponseDto;
import team.avengers.toylog.persistence.h2.repository.TestRepository;
import team.avengers.toylog.service.ResponseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public ApiResponseDto<List<TestResponseDto>> getTests() {
        ResponseService<List<TestResponseDto>> responseService = new ResponseService<> ();
        return responseService.getSuccessApiResponseDto(
                testRepository.findAll().stream()
                        .map(TestResponseDto::from)
                        .collect(Collectors.toList()));
    }

    public ApiResponseDto<List<TestResponseDto>> getTestsByName(final String name) {
        ResponseService<List<TestResponseDto>> responseService = new ResponseService<> ();
        return responseService.getSuccessApiResponseDto(
                testRepository.findByName(name).stream()
                        .map(TestResponseDto::from)
                        .collect(Collectors.toList()));
    }

    public ApiResponseDto<TestResponseDto> getTestById(final Long id) {
        ResponseService<TestResponseDto> responseService = new ResponseService<> ();
        return responseService.getSuccessApiResponseDto(
                testRepository.findById(id)
                        .map(TestResponseDto::from)
                        .orElseThrow(TestNotFoundException::new));
    }
}

package team.avengers.toylog.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.avengers.toylog.advice.exception.TestNotFoundException;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.model.test.TestAddRequestDto;
import team.avengers.toylog.model.test.TestModifyRequestDto;
import team.avengers.toylog.model.test.TestResponseDto;
import team.avengers.toylog.persistence.h2.entity.TestEntity;
import team.avengers.toylog.persistence.h2.repository.TestRepository;
import team.avengers.toylog.service.ResponseService;

import java.util.Optional;

@Service
public class TestSaveService {
    @Autowired
    private TestRepository testRepository;

    public ApiResponseDto<TestResponseDto> setTest(TestAddRequestDto testAddRequestDto) {
        ResponseService<TestResponseDto> responseService = new ResponseService<> ();
        // TODO: 2020-06-02 입력 데이터에 대한 validation check가 필요. 새로운 RuntimeException도 필요
        return responseService.getSuccessApiResponseDto(
                Optional.of(testRepository.save(testAddRequestDto.toEntity()))
                        .map(TestResponseDto::from)
                        .orElseThrow());
    }

    public ApiResponseDto<TestResponseDto> updateTest(Long id, TestModifyRequestDto testModifyRequestDto) {
        ResponseService<TestResponseDto> responseService = new ResponseService<> ();
        // TODO: 2020-06-02 입력 데이터에 대한 validation check가 필요. 새로운 RuntimeException도 필요
        TestEntity updatedTestEntity = testRepository.findById(id)
                        .orElseThrow(TestNotFoundException::new)
                        .update(testModifyRequestDto);

        return responseService.getSuccessApiResponseDto(
                Optional.of(testRepository.save(updatedTestEntity))
                        .map(TestResponseDto::from)
                        .orElseThrow());
    }
}

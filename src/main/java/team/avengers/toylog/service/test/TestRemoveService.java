package team.avengers.toylog.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.avengers.toylog.advice.exception.TestNotFoundException;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.model.test.TestResponseDto;
import team.avengers.toylog.persistence.h2.entity.TestEntity;
import team.avengers.toylog.persistence.h2.repository.TestRepository;
import team.avengers.toylog.service.ResponseService;

@Service
public class TestRemoveService {
    @Autowired
    private TestRepository testRepository;

    public ApiResponseDto<TestResponseDto> deleteTest(Long id){

        ResponseService<TestResponseDto> responseService = new ResponseService<> ();

        TestEntity testEntity = testRepository.findById(id).orElseThrow(TestNotFoundException::new);

        testRepository.delete(testEntity);

        return responseService.getSuccessApiResponseDto(TestResponseDto.from(testEntity));

    }
}

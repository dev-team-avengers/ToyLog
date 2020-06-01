package team.avengers.toylog.service.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.ActiveProfiles;
import team.avengers.toylog.advice.exception.TestNotFoundException;
import team.avengers.toylog.persistence.h2.entity.TestEntity;
import team.avengers.toylog.service.ResponseService;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.BDDAssertions.*;

import static org.mockito.BDDMockito.*;

@ActiveProfiles(value = "dev")
@Transactional
class TestServiceTest {
    @InjectMocks
    private TestService testService;
    @InjectMocks
    private ResponseService responseService;

    @Test
    void Id가_존재하지_않을_경우() {
//        given(testService.getTestById(1L))
//                .willReturn(responseService.getFailureApiResponseDto(-9998, "", null));
    }
}
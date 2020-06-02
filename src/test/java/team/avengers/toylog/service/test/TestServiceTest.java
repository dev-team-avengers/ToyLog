package team.avengers.toylog.service.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team.avengers.toylog.advice.exception.TestNotFoundException;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.model.test.TestResponseDto;
import team.avengers.toylog.persistence.h2.entity.TestEntity;
import team.avengers.toylog.persistence.h2.repository.TestRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.BDDAssertions.*;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class TestServiceTest {
    @InjectMocks
    private TestService testService;

    @Mock
    private TestRepository testRepository;

    @Test
    void 존재하는_Id를_조회했을_경우() {
        // given -> mocking
        final Long id = anyLong();
        given(testRepository.findById(id))
                .willReturn(Optional.of(TestEntity.builder().id(id).build()));

        // when -> 실제 테스트할 내용
        ApiResponseDto<TestResponseDto> dto = testService.getTestById(id);

        // then -> 검증
        assertEquals(id, dto.getData().getId());
        verify(testRepository, times(1))
                .findById(id);
    }

    @Test
    void Id가_존재하지_않을_경우() {
        final Long id = anyLong();
        given(testRepository.findById(id))
                .willReturn(Optional.empty());

        assertThrows(TestNotFoundException.class, () -> {
            ApiResponseDto<TestResponseDto> dto = testService.getTestById(id);
        });
    }
}
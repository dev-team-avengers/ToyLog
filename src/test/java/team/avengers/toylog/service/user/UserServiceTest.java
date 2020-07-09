package team.avengers.toylog.service.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import team.avengers.toylog.advice.exception.UserNotFoundException;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.model.user.UserResponseDto;
import team.avengers.toylog.persistence.h2.entity.UserEntity;
import team.avengers.toylog.persistence.h2.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    // TODO: 2020-07-08 여기 테스트 코드 잘 짰는지 확인해야 함(테스트용 idx때문에 builder를 이렇게 만드는게 맞는지...)
    @Test
    public void 존재하는_idx로_유저_조회() {
        // given
        final Integer idx = anyInt();
        given(userRepository.findById(idx))
                .willReturn(
                        Optional.of(
                                UserEntity.builder()
                                        .idx(idx)
                                        .build()));

        // when
        ApiResponseDto<UserResponseDto> dto = userService.getUserByIdx(idx);

        // then
        assertEquals(idx, dto.getData().getIdx());
    }

    @Test
    public void 존재하지_않는_idx로_유저_조회() {
        // given
        final Integer idx = anyInt();
        given(userRepository.findById(idx))
                .willReturn(Optional.empty());

        // then
        assertThrows(UserNotFoundException.class, () -> {
            // when
            userService.getUserByIdx(idx);
        });
    }

    @Test
    public void 존재하는_id로_유저_조회() {
        // given
        final String id = "test_id";
        given(userRepository.findById(id))
                .willReturn(
                        Optional.of(
                                UserEntity.builder()
                                        .id(id)
                                        .password("")
                                        .build()));

        // when
        ApiResponseDto<UserResponseDto> dto = userService.getUserById(id);

        // then
        assertEquals(id, dto.getData().getId());
    }

    @Test
    public void 존재하지_않는_id로_유저_조회() {
        // given
        final String id = "test_id";
        given(userRepository.findById(id))
                .willReturn(Optional.empty());

        // then
        assertThrows(UserNotFoundException.class, () -> {
            // when
            userService.getUserById(id);
        });
    }
}
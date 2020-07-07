package team.avengers.toylog.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import team.avengers.toylog.advice.exception.UserNotFoundException;
import team.avengers.toylog.model.user.UserResponseDto;
import team.avengers.toylog.persistence.h2.entity.UserEntity;
import team.avengers.toylog.service.ResponseService;
import team.avengers.toylog.service.user.UserService;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(value = "dev")
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    private final String BASE_URL = "/api/v1/user";

    @Test
    public void idx로_유저_조회_성공_api() throws Exception {
        // given
        ResponseService<UserResponseDto> responseService = new ResponseService<> ();
        final Integer idx = anyInt();
        given(userService.getUserByIdx(idx))
                .willReturn(
                        responseService.getSuccessApiResponseDto(
                                UserResponseDto.from(
                                        UserEntity.builder()
                                                .idx(idx)
                                                .build())));

        // when
        final ResultActions actions = mockMvc.perform(get(BASE_URL + "/{idx}", idx));

        // then
        actions.andExpect(status().isOk())
                .andDo(f -> {
                    System.out.println(f.getResponse().getContentAsString());
                })
                .andExpect(jsonPath("$.code", Matchers.is(0)));
    }

    @Test
    public void idx로_유저_조회_실패_api() throws Exception {
        // given
        ResponseService<UserResponseDto> responseService = new ResponseService<> ();
        final Integer idx = anyInt();
        given(userService.getUserByIdx(idx))
                .willThrow(UserNotFoundException.class);

        // when
        final ResultActions actions = mockMvc.perform(get(BASE_URL + "/{idx}", -1));

        // then
        actions.andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.code", Matchers.is(1)));
    }
}
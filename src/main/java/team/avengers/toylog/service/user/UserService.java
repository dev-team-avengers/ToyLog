package team.avengers.toylog.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.avengers.toylog.advice.exception.UserNotFoundException;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.model.user.UserResponseDto;
import team.avengers.toylog.persistence.h2.repository.UserRepository;
import team.avengers.toylog.service.ResponseService;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ApiResponseDto<UserResponseDto> getUserByIdx(Integer idx) {
        ResponseService<UserResponseDto> responseService = new ResponseService<> ();

        return responseService.getSuccessApiResponseDto(
                UserResponseDto.from(
                        userRepository
                                .findById(idx)
                                .orElseThrow(UserNotFoundException::new)));
    }

    public ApiResponseDto<UserResponseDto> getUserById(String id) {
        ResponseService<UserResponseDto> responseService = new ResponseService<> ();

        return responseService.getSuccessApiResponseDto(
                UserResponseDto.from(
                        userRepository
                                .findById(id)
                                .orElseThrow(UserNotFoundException::new)));
    }
}

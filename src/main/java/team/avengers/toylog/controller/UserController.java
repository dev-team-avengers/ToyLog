package team.avengers.toylog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.avengers.toylog.model.ApiResponseDto;
import team.avengers.toylog.model.user.UserResponseDto;
import team.avengers.toylog.service.user.UserService;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{idx}")
    public ApiResponseDto<UserResponseDto> getUserByIdx(@PathVariable Integer idx) {
        return userService.getUserByIdx(idx);
    }
}

package org.highfives.esc.user.controller;

import org.highfives.esc.user.dto.UserDTO;
import org.highfives.esc.user.service.UserService;
import org.highfives.esc.user.vo.RegistUser;
import org.highfives.esc.user.vo.ResetPwd;
import org.highfives.esc.user.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private Environment env;

    private ModelMapper modelMapper;

    private UserService userService;

    @Autowired
    public UserController(Environment env, ModelMapper modelMapper, UserService userService) {
        this.env = env;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/regist")
    public ResponseEntity<ResponseUser> registUser(@RequestBody RegistUser userInfo) {
        UserDTO userDTO = modelMapper.map(userInfo, UserDTO.class);
        userService.registUser(userDTO);

        ResponseUser responseUser = modelMapper.map(userDTO, ResponseUser.class);


        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/emailCheck/{email}")
    public String emailCheck(@PathVariable("email") String email) {
        return userService.emailCheck(email);
    }

    @GetMapping("/emailExCheck/{email}")
    public String emailExCheck(@PathVariable("email") String email) {
        return userService.emailExCheck(email);
    }

    @GetMapping("/nicknameCheck/{nickname}")
    public String nicknameCheck(@PathVariable("nickname") String nickname) {
        return userService.nicknameCheck(nickname);
    }

    @GetMapping("/info/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") String userId) {
        UserDTO userDTO = userService.getUserDetailsByEmail(userId);

        ResponseUser returnValue = new ModelMapper().map(userDTO, ResponseUser.class);

        try {
            return ResponseEntity.status(HttpStatus.OK).body(returnValue);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/findId")
    public ResponseEntity<String> findUserEmail(@RequestParam("name") String name, @RequestParam("nickname") String nickname) {
        String email = userService.findUserEmail(name, nickname);

        return ResponseEntity.status(HttpStatus.OK).body(email);
    }

    @GetMapping("/checkUser")
    public ResponseEntity<String> checkUserEx(@RequestParam("name") String name, @RequestParam("email") String email) {
        String check = userService.checkUserEx(name, email);

        return ResponseEntity.status(HttpStatus.OK).body(check);
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPwd resetPwd) {

        String check = userService.resetPassword(resetPwd);

        return ResponseEntity.status(HttpStatus.OK).body(check);
    }


}

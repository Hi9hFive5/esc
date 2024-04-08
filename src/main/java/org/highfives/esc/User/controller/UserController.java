package org.highfives.esc.User.controller;

import org.highfives.esc.User.dao.UserMapper;
import org.highfives.esc.User.dto.UserDTO;
import org.highfives.esc.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /* 설명. userId를 이용한 조회 */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") String id ) {

        UserDTO userDTO = userService.findUserById(id);

        return ResponseEntity.ok().body(userDTO);
    }

    /* 설명. 회원 리스트 조회 */
    @GetMapping("/findUserList")
    public ResponseEntity<List<UserDTO>> findUserList(){

        List<UserDTO> userDTOList = userService.findUserList();

        return ResponseEntity.ok().body(userDTOList);
    }

//    /* 설명. 회원이 속한 스터디 클럽 조회*/
//    @GetMapping("/studyclub")
//    public ResponseEntity<List<UserDTO>> findStudyClubById(@PathVariable("id") String id) {
//
//        List<UserDTO> userDTOList = userService.findStudyClubById(id);
//
//        return ResponseEntity.ok().body(userDTOList);
//    }

    /* 설명. 회원 정지 기능 */

    @PutMapping("/ban")
    public ResponseEntity<UserDTO> banUserById(@RequestBody UserDTO banUser) {

        UserDTO userDTO = userService.banUserById(banUser);

        return ResponseEntity.ok().body(userDTO);
    }

    /* 설명. 회원 정보 수정 기능 */

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUserInfoById(@RequestBody UserDTO updateUser){

        UserDTO userDTO = userService.updateUserInfoById(updateUser);

        return ResponseEntity.ok().body(userDTO);
    }
}

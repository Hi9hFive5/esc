package org.highfives.esc.User.controller;

import lombok.extern.slf4j.Slf4j;
import org.highfives.esc.User.dao.UserMapper;
import org.highfives.esc.User.dto.StudyclubMemberDTO;
import org.highfives.esc.User.dto.UserDTO;
import org.highfives.esc.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
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

    /* 설명. 회원이 참여한 스터디 클럽 조회 */

    @GetMapping("/joinStudyClub/{member_id}")
    public ResponseEntity<List<StudyclubMemberDTO>> findJoinStudyClubById(@PathVariable("member_id") String id ){

        List <StudyclubMemberDTO> studyclubMemberDTO = userService.findJoinStudyClubById(id);


        return ResponseEntity.ok().body(studyclubMemberDTO);
    }

    /* 설명. 회원의 포인트 변경 업데이트 */
    @PutMapping("/getUserPoint")
    public ResponseEntity<UserDTO> getUserPoint(@RequestBody UserDTO userDTOdata){

        UserDTO userDTO = userService.getUserPoint(userDTOdata);

        return ResponseEntity.ok().body(userDTO);
    }
}

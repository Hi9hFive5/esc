package org.highfives.esc.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.highfives.esc.user.dao.UserMapper;
import org.highfives.esc.user.dto.StudyclubInfoDTO;
import org.highfives.esc.user.dto.UserDTO;
import org.highfives.esc.user.dto.UserInfoDTO;
import org.highfives.esc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* 설명. userId를 이용한 조회 */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") String id) {

        UserDTO userDTO = userService.findUserById(id);

        return ResponseEntity.ok().body(userDTO);
    }

    /* 설명. 회원 리스트 조회 */
    @GetMapping("/findUserList")
    public ResponseEntity<List<UserDTO>> findUserList() {

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
    public ResponseEntity<UserDTO> updateUserInfoById(@RequestBody UserDTO updateUser) {

        UserDTO userDTO = userService.updateUserInfoById(updateUser);

        return ResponseEntity.ok().body(userDTO);
    }

    /* 설명. 회원이 참여한 스터디 클럽 조회 */

    @GetMapping("/joinStudyClub/{member_id}")
    public ResponseEntity<List<StudyclubInfoDTO>> findJoinStudyClubById(@PathVariable("member_id") String memberId) {

        List<StudyclubInfoDTO> studyclubMemberDTO = userService.findJoinStudyClubById(memberId);


        return ResponseEntity.ok().body(studyclubMemberDTO);
    }

    /* 설명. 회원의 포인트 변경 업데이트 */
    @PutMapping("/getUserPoint")
    public ResponseEntity<UserDTO> getUserPoint(@RequestBody UserDTO userDTOData) {

        UserDTO userDTO = userService.getUserPoint(userDTOData);

        return ResponseEntity.ok().body(userDTO);
    }

    /* 설명. 회원 탈퇴 기능 */
    @PutMapping("/Withdrawal/{id}")
    public ResponseEntity<UserDTO> userWithdrawalById(UserDTO userDTOData) {

        UserDTO userDTO = userService.userWithdrawalById(userDTOData);

        return ResponseEntity.ok().body(userDTO);

    }

    /* 설명. 회원 가입 기능 */
    @PostMapping("/signUp")
    public ResponseEntity<UserDTO> singUp(@RequestBody UserDTO userDTOData) {

        UserDTO userDTO = userService.signUp(userDTOData);

        return ResponseEntity.ok().body(userDTO);
    }

    /* 설명. 프로젝트 참여 회원 이름 조회 */
    @GetMapping("/findJoinMemberAndName/{studyclub_id}")
    public ResponseEntity<List<UserInfoDTO>> findJoinMemberAndNameById(@PathVariable("studyclub_id") String studyclubId){

        List<UserInfoDTO> userInfoDTO = userService.findJoinMemberAndNameById(studyclubId);

        return ResponseEntity.ok().body(userInfoDTO);
    }
}

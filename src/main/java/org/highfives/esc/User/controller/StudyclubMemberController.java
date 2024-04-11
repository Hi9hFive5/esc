package org.highfives.esc.User.controller;

import org.highfives.esc.User.dao.StudyclubMemberMapper;
import org.highfives.esc.User.dto.StudyclubMemberDTO;
import org.highfives.esc.User.service.StudyclubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studyclubMember")
public class StudyclubMemberController {
    private final StudyclubMemberService studyclubMemberService;
    private final StudyclubMemberMapper studyclubMemberMapper;

    @Autowired
    public StudyclubMemberController(StudyclubMemberService studyclubMemberService, StudyclubMemberMapper studyclubMemberMapper) {
        this.studyclubMemberService = studyclubMemberService;
        this.studyclubMemberMapper = studyclubMemberMapper;
    }

    /* 설명. 스터디 클럽 멤버 추가 기능 */
    @GetMapping("/insertMember/{memberId}/{studyclubId}")
    public ResponseEntity<StudyclubMemberDTO> insertMemberById(@PathVariable("memberId") String memberId,
                                                               @PathVariable("studyclubId") String studyclubId) {

        StudyclubMemberDTO studyclubMemberDTO = studyclubMemberService.insetMemberById(memberId, studyclubId);

        return ResponseEntity.ok().body(studyclubMemberDTO);
    }

    /* 설명. 스터디 클럽 멤버 제거 기능 */
    @DeleteMapping("/deleteMember/{memberId}/{studyclubId}")
    public ResponseEntity<StudyclubMemberDTO> deleteByMemberIdAndStudyclubId(@PathVariable("memberId") String memberId,
                                                                             @PathVariable("studyclubId") String studyclubId) {

        studyclubMemberService.deleteByMemberIdAndStudyclubId(memberId, studyclubId);

        return ResponseEntity.ok().build();
    }
}

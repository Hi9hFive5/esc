package org.highfives.esc.recruit.controller;

import org.highfives.esc.recruit.dto.RecruitPostDTO;
import org.highfives.esc.recruit.service.RecruitService;
import org.highfives.esc.recruit.vo.RecruitPostVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

    private final RecruitService recruitService;

    public RecruitController(RecruitService recruitService) { this.recruitService = recruitService; }

    // 모집글 작성
    @PostMapping("/regist/{clubId}")
    public ResponseEntity<RecruitPostDTO> registRecruitPost(@RequestBody RecruitPostVO recruitPostVO, int clubId) {

        RecruitPostDTO recruitPost = recruitService.registRecruitPost(recruitPostVO, clubId);
    }



    // 모집글 수정


    // 모집글 삭제


    // 모집글 신청


    // 모집글 신청 수락


    // 모집글 신청 거절


    // 회원 아이디로 모집글 신청 리스트 조회


}

package org.highfives.esc.schedule.controller;

import org.highfives.esc.schedule.dto.MemberScheduleDTO;
import org.highfives.esc.schedule.service.MemberScheduleService;
import org.highfives.esc.schedule.vo.ResponseMemberScheduleListVO;
import org.highfives.esc.schedule.vo.ResponseMemberScheduleVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/member-schedule")
public class MemberScheduleController {

    private final ModelMapper mapper;
    private final MemberScheduleService memberScheduleService;


    @Autowired
    public MemberScheduleController(ModelMapper mapper, MemberScheduleService memberScheduleService) {
        this.mapper = mapper;
        this.memberScheduleService = memberScheduleService;
    }

    /* 설명. 일정 id로 조회 */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseMemberScheduleVO> findMemberScheduleById(
            @PathVariable("id") int id) {

        MemberScheduleDTO memberScheduleDTO = memberScheduleService.findMemberScheduleById(id);

        ResponseMemberScheduleVO responseMemberScheduleVO = mapper.map(memberScheduleDTO, ResponseMemberScheduleVO.class);

        responseMemberScheduleVO.setMessage("조회성공");
        return ResponseEntity.status(HttpStatus.OK).body(responseMemberScheduleVO);
    }

    /* 설명. member id로 조회 */
    @GetMapping("member/{memberId}")
    public ResponseEntity<ResponseMemberScheduleListVO> findMemberScheduleByMemberId(
            @PathVariable("memberId") int memberId) {

        ResponseMemberScheduleListVO response = new ResponseMemberScheduleListVO();

        ArrayList<MemberScheduleDTO> memberScheduleDTOList = memberScheduleService.findMemberScheduleByMemberId(memberId);
        ArrayList<ResponseMemberScheduleVO> responseMemberScheduleVOList = new ArrayList<>();

        for (MemberScheduleDTO memberScheduleDTO: memberScheduleDTOList){
            responseMemberScheduleVOList.add(mapper.map(memberScheduleDTO, ResponseMemberScheduleVO.class));
        }

        response.setMessage("조회 성공");
        response.setMemberSchedules(responseMemberScheduleVOList);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

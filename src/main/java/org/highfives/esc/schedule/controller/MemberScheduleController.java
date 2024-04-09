package org.highfives.esc.schedule.controller;

import org.highfives.esc.schedule.dto.MemberScheduleDTO;
import org.highfives.esc.schedule.service.MemberScheduleService;
import org.highfives.esc.schedule.vo.ResponseMemberScheduleVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMemberScheduleVO> findMemberSchedule(@PathVariable("id") int id) {
        ResponseMemberScheduleVO responseMemberScheduleVO = new ResponseMemberScheduleVO();

        MemberScheduleDTO memberScheduleDTO = memberScheduleService.findMemberScheduleById(id);

        responseMemberScheduleVO = mapper.map(memberScheduleDTO, ResponseMemberScheduleVO.class);

        responseMemberScheduleVO.setMessage("조회성공");
        return ResponseEntity.status(HttpStatus.OK).body(responseMemberScheduleVO);
    }
}

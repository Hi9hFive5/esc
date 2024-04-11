package org.highfives.esc.schedule.service;

import org.highfives.esc.schedule.dto.MemberScheduleDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberScheduleServiceTest {

    @Autowired
    MemberScheduleService memberScheduleService;

    @Test
    @DisplayName("멤버일정 id로 멤버 일정 조회")
    void findMemberScheduleByIdTest() {
        int id = 1;

        MemberScheduleDTO memberScheduleDTO = memberScheduleService.findMemberScheduleById(id);
        System.out.println(memberScheduleDTO);

        assertEquals(memberScheduleDTO.getId(), id);
    }

    @Test
    @DisplayName("멤버id로 멤버 일정 조회")
    void findMemberScheduleByMemberIdTest() {
        int memberId = 1;

        ArrayList<MemberScheduleDTO> memberScheduleDTOList = memberScheduleService.findMemberScheduleByMemberId(memberId);
        System.out.println(memberScheduleDTOList);

        assertNotNull(memberScheduleDTOList);
    }

    @Test
    @DisplayName("스터디클럽id로 멤버 일정 조회")
    void findMemberScheduleByStudyclubIdTest() {
        int studyclubId = 1;

        ArrayList<MemberScheduleDTO> memberScheduleDTOList = memberScheduleService.findMemberScheduleByStudyclubId(studyclubId);
        System.out.println(memberScheduleDTOList);

        assertNotNull(memberScheduleDTOList);
    }

    @Test
    @DisplayName("일정 추가")
//    @Transactional
    void saveMemberSchedule() {

        String startTime = "2024-04-09 08:30:00";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter1);

        String endTime = "2024-04-09 10:30:00";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime end = LocalDateTime.parse(endTime, formatter2);

        MemberScheduleDTO memberScheduleDTO = new MemberScheduleDTO(start, end, 3, 1);

        memberScheduleService.saveMemberSchedule(memberScheduleDTO);

        assertNotNull(memberScheduleService.findMemberScheduleByMemberId(3));
    }

    @Test
    @DisplayName("일정 수정")
//    @Transactional
    void modifyMemberSchedule() {
        String startTime = "2024-04-09 17:30:00";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter1);

        String endTime = "2024-04-09 19:30:00";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime end = LocalDateTime.parse(endTime, formatter2);

        MemberScheduleDTO memberScheduleDTO = new MemberScheduleDTO(22, start, end);

        memberScheduleService.modifyMemberSchedule(memberScheduleDTO);

        assertEquals(start, memberScheduleService.findMemberScheduleById(22).getStartDatetime());
    }
}
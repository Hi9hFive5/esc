package org.highfives.esc.schedule.service;

import org.highfives.esc.schedule.dto.MemberScheduleDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
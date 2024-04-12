package org.highfives.esc.schedule.service;

import org.highfives.esc.schedule.dto.StudyScheduleDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyScheduleServiceTest {

    @Autowired
    StudyScheduleService studyScheduleService;

    @Test
    @DisplayName("id로 스터디 일정 조회")
    void findStudyScheduleDTO() {
        int id = 1;
        System.out.println(id);
        StudyScheduleDTO studyScheduleDTO = studyScheduleService.findStudyScheduleById(id);

        assertNotNull(studyScheduleDTO);
    }

    @Test
    @DisplayName("스터디 id로 스터디 일정 조회")
    void findStudyclubDTO() {
        int studyId = 1;

        ArrayList<StudyScheduleDTO> studyScheduleDTOList = studyScheduleService.findStudyScheduleByStudyId(studyId);

        assertNotNull(studyScheduleDTOList);
    }
}
package org.highfives.esc.studylog.controller;

import org.assertj.core.api.Assertions;
import org.highfives.esc.studylog.dto.StudyclubLogDTO;
import org.highfives.esc.studylog.dto.StudyclubLogInfoDTO;
import org.highfives.esc.studylog.dto.StudyclubLogMemberInfoDTO;
import org.highfives.esc.studylog.service.StudyclubLogService;
import org.highfives.esc.user.dto.UserInfoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyclubLogControllerTests {

    private final StudyclubLogService studyclubLogService;

    @Autowired
    public StudyclubLogControllerTests(StudyclubLogService studyclubLogService) {
        this.studyclubLogService = studyclubLogService;
    }

    @DisplayName("스터디 로그 생성 기능 테스트")
    @Test
    @Transactional
    void insertStudyLog() {
        // Given
        StudyclubLogDTO studyclubLogDTO = StudyclubLogDTO.builder()
                .content("test")
                .studydate("0000-00-00")
                .enrolldate("0000-00-00")
                .studyclubId(1)
                .scheduleId(1)
                .build();

        // When

        StudyclubLogDTO studyLogTest = studyclubLogService.insertStudyLog(studyclubLogDTO);

        // Then
        assertThat(studyLogTest).isNotNull();
        assertThat(studyLogTest.getScheduleId()).isEqualTo(studyclubLogDTO.getScheduleId());
        assertThat(studyLogTest.getContent()).isEqualTo(studyclubLogDTO.getContent());

    }

    @DisplayName("스터디 로그 수정 기능 테스트")
    @Test
    @Transactional
    void updateStudyLog() {
        // Given
        StudyclubLogDTO studyclubLogDTO = StudyclubLogDTO.builder()
                .content("test")
                .studydate("0000-00-00")
                .enrolldate("0000-00-00")
                .studyclubId(1)
                .scheduleId(1)
                .build();

        // When

        StudyclubLogDTO studyLogTest = studyclubLogService.updateStudyclubLog(studyclubLogDTO);

        // Then
        assertThat(studyLogTest).isNotNull();
        assertThat(studyLogTest.getScheduleId()).isEqualTo(studyclubLogDTO.getScheduleId());
        assertThat(studyLogTest.getContent()).isEqualTo(studyclubLogDTO.getContent());


    }

    @DisplayName("스터디 로그 삭제 기능 테스트")
    @Test
    @Transactional
    void deleteStudyLog() {
        // Given

        String id = "1";

        // When
        studyclubLogService.deleteStudyLog(id);

        // Then

    }

    @DisplayName("스터디 로그 조회 기능 테스트")
    @Test
    @Transactional
    void findStudyLogById() {
        // Given
        String id = "1";

        // When
        try {
            StudyclubLogDTO studyLogById = studyclubLogService.findStudyLogById(id);

            // Then
            assertThat(studyLogById).isNotNull();
            assertThat(studyLogById.getId()).isEqualTo(Integer.valueOf(id));

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }



    }

    @DisplayName("스터디 그룹 작성 된 로그 조회 기능 테스트")
    @Test
    @Transactional
    void findStudyclubLogById() {
        // Given
        String studyclubId = "1";

        // When
        List<StudyclubLogInfoDTO> studyclubLogById = studyclubLogService.findStudyclubLogById(studyclubId);

        // Then

        assertThat(studyclubLogById).isNotNull();

    }

    @DisplayName("작성한 로그 확인 기능 테스트")
    @Test
    @Transactional
    void findWritingStudyclubLogById() {
        // Given
        String id = "1";

        // When

        List<StudyclubLogMemberInfoDTO> writingStudyclubLogById = studyclubLogService.findWritingStudyclubLogById(id);

        // Then
        for (StudyclubLogMemberInfoDTO studyclubLogMemberInfo : writingStudyclubLogById) {
            assertThat(studyclubLogMemberInfo).isNotNull();
            assertThat(studyclubLogMemberInfo.getMemberId()).isEqualTo(Integer.valueOf(id));

        }

    }
}
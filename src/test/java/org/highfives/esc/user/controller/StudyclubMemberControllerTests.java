package org.highfives.esc.user.controller;

import org.assertj.core.api.Assertions;
import org.highfives.esc.studyclub.service.StudyclubService;
import org.highfives.esc.user.dto.StudyclubMemberDTO;
import org.highfives.esc.user.dto.UserDTO;
import org.highfives.esc.user.service.StudyclubMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyclubMemberControllerTests {

    private final StudyclubMemberService studyclubMemberService;

    @Autowired
    public StudyclubMemberControllerTests(StudyclubMemberService studyclubMemberService) {
        this.studyclubMemberService = studyclubMemberService;
    }

    @DisplayName("스터디 클럽 멤버 추가 기능 테스트")
    @Test
    @Transactional
    void insertMemberById() {
        // Given
        String memberId = "1";
        String studyclubId = "1";

        // When
        StudyclubMemberDTO studyclubMemberTest = studyclubMemberService.insetMemberById(memberId, studyclubId);

        // Then
        assertThat(studyclubMemberTest).isNotNull();
        assertThat(studyclubMemberTest.getMemberId()).isEqualTo(1);
        assertThat(studyclubMemberTest.getStudyclubId()).isEqualTo(1);

    }

    @DisplayName("스터디 클럽 멤버 삭제 기능 테스트")
    @Test
    @Transactional
    void deleteByMemberIdAndStudyclubId() {
        // Given
        String memberId = "1";
        String studyclubId = "1";

        // When
        studyclubMemberService.deleteByMemberIdAndStudyclubId(memberId, studyclubId);

        // Then



    }
}
package org.highfives.esc.studyclub.controller;

import org.highfives.esc.studyclub.dto.StudyclubDTO;
import org.highfives.esc.studyclub.service.StudyclubService;
import org.highfives.esc.studyclub.vo.StudyclubVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studyclub")
public class StudyclubController {

    private final StudyclubService studyclubService;

    public StudyclubController(StudyclubService studyclubService) {
        this.studyclubService = studyclubService;
    }

    // 리더(회원) 아이디로 스터디클럽 리스트 조회
    @GetMapping("/list/{leaderId}")
    public ResponseEntity<List<StudyclubDTO>> findStudyclubsByLeaderId(@PathVariable int leaderId) {

        List<StudyclubDTO> studyclubList = studyclubService.findStudyclubsByLeaderId(leaderId);

        return ResponseEntity.ok().body(studyclubList);
    }

    // 스터디클럽 아이디로 스터디클럽 상세 정보 조회
    @GetMapping("/detail/{studyclubId}")
    public ResponseEntity<StudyclubDTO> findStudyclubById(@PathVariable int studyclubId) {

        StudyclubDTO studyclub = studyclubService.findStudyclubById(studyclubId);

        return ResponseEntity.ok().body(studyclub);
    }

    // 스터디클럽 신규 등록
    @PostMapping("/regist/{leaderId}")
    public ResponseEntity<StudyclubDTO> registStudyClub(@RequestBody StudyclubVO studyclubVO, @PathVariable int leaderId) {

        StudyclubDTO studyclub = studyclubService.registStudyclub(studyclubVO, leaderId);

        return ResponseEntity.ok().body(studyclub);
    }

    // 스터디클럽 내용 수정(기존 스터디클럽 내용 조회해서 보여주기)
    @PutMapping("/modify/{studyclubId}")
    public ResponseEntity<StudyclubDTO> modifyStudyclub(@PathVariable int studyclubId, @RequestBody StudyclubVO studyclubVO) {

        StudyclubDTO studyclub = studyclubService.modifyStudyclub(studyclubId, studyclubVO);

        return ResponseEntity.ok().body(studyclub);
    }

    // 스터디클럽 삭제 상태로 변경
    @PutMapping("/delete/{studyclubId}")
    public ResponseEntity<StudyclubDTO> deleteStudyclub(@PathVariable int studyclubId) {

        StudyclubDTO studyclub = studyclubService.deleteStudyclub(studyclubId);

        return ResponseEntity.ok().body(studyclub);
    }
}

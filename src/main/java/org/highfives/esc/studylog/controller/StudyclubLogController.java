package org.highfives.esc.studylog.controller;

import org.highfives.esc.studylog.dto.StudyclubLogDTO;
import org.highfives.esc.studylog.service.StudyclubLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studyLog")
public class StudyclubLogController {

    private final StudyclubLogService studyclubLogService;

    @Autowired
    public StudyclubLogController(StudyclubLogService studyclubLogService) {
        this.studyclubLogService = studyclubLogService;
    }

    /* 설명. 스터디 로그 생성 기능 */
    @PostMapping("/insert")
    public ResponseEntity<StudyclubLogDTO> insertStudyLog(@RequestBody StudyclubLogDTO studyclubLogDTOData) {

        StudyclubLogDTO studyclubLogDTO = studyclubLogService.insertStudyLog(studyclubLogDTOData);

        return ResponseEntity.ok().body(studyclubLogDTO);
    }

    /* 설명. 스터디 로그 수정 기능 */
    @PutMapping("/update")
    public ResponseEntity<StudyclubLogDTO> updateStudyLog(@RequestBody StudyclubLogDTO studyclubLogDTOData){

        StudyclubLogDTO studyclubLogDTO = studyclubLogService.updateStudyclubLog(studyclubLogDTOData);

        return ResponseEntity.ok().body(studyclubLogDTO);

    }

    /* 설명. 스터디 로그 삭제 기능 */
    @DeleteMapping("/delete/{id}")
    public String deleteStudyLog(@PathVariable String id){

        studyclubLogService.deleteStudyLog(id);

        return "ok";
    }
}

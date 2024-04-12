package org.highfives.esc.schedule.controller;

import org.highfives.esc.schedule.dto.StudyScheduleDTO;
import org.highfives.esc.schedule.service.StudyScheduleService;
import org.highfives.esc.schedule.vo.ResponseStudyScheduleListVO;
import org.highfives.esc.schedule.vo.ResponseStudyScheduleVO;
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
@RequestMapping("/study-schedule")
public class StudyScheduleController {

    private final ModelMapper mapper;
    private final StudyScheduleService studyScheduleService;

    @Autowired
    public StudyScheduleController(ModelMapper mapper, StudyScheduleService studyScheduleService) {
        this.mapper = mapper;
        this.studyScheduleService = studyScheduleService;
    }

    @GetMapping("/schdule/{id}")
    public ResponseEntity<ResponseStudyScheduleVO> findStudyScheduleById(
            @PathVariable("id") int id) {
        ResponseStudyScheduleVO response = new ResponseStudyScheduleVO();

        StudyScheduleDTO studyScheduleDTO = studyScheduleService.findStudyScheduleById(id);
        if(studyScheduleDTO != null){


            response = mapper.map(studyScheduleDTO, ResponseStudyScheduleVO.class);
//            response.setId(studyScheduleDTO.getId());
//            response.setTitle(studyScheduleDTO.getTitle());
//            response.setContent(studyScheduleDTO.getContent());
//            response.setStartDatetime(studyScheduleDTO.getStartDatetime());
//            response.setEndDatetime(studyScheduleDTO.getEndDatetime());
//            response.setUseState(studyScheduleDTO.getUseState());
//            response.
            response.setMessage("조회 성공");
        } else {
            response.setMessage("조회 실패");
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/studyculb/{studyculbId}")
    public ResponseEntity<ResponseStudyScheduleListVO> findStudyScheduleByStudyclubId(
            @PathVariable("studyculbId") int studyculbId) {
        ResponseStudyScheduleListVO response = new ResponseStudyScheduleListVO();

        ArrayList<StudyScheduleDTO> studyScheduleDTOList = studyScheduleService.findStudyScheduleByStudyId(studyculbId);
        ArrayList<ResponseStudyScheduleVO> studyScheduleVOList = new ArrayList<>();
        if(studyScheduleDTOList != null){

            for(StudyScheduleDTO studyScheduleDTO: studyScheduleDTOList){
                studyScheduleVOList.add(mapper.map(studyScheduleDTO, ResponseStudyScheduleVO.class));
            }

            response.setMessage("조회 성공");
            response.setStudySchedules(studyScheduleVOList);
        } else {
            response.setMessage("조회 실패");
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

package org.highfives.esc.schedule.service;

import org.highfives.esc.schedule.dto.StudyScheduleDTO;
import org.highfives.esc.schedule.entity.StudySchedule;
import org.highfives.esc.schedule.repository.StudyScheduleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class StudyScheduleService {

    private final ModelMapper mapper;
    private final StudyScheduleRepository studyScheduleRepository;

    @Autowired
    public StudyScheduleService(ModelMapper mapper, StudyScheduleRepository studyScheduleRepository) {
        this.mapper = mapper;
        this.studyScheduleRepository = studyScheduleRepository;
    }

    /* 설명. id로 스터디 일정 조회 */
    public StudyScheduleDTO findStudyScheduleById(int id) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        StudySchedule studySchedule = studyScheduleRepository.findById(id);

        if(studySchedule != null){
            StudyScheduleDTO studyScheduleDTO = mapper.map(studySchedule, StudyScheduleDTO.class);
            System.out.println(studyScheduleDTO);
            return  studyScheduleDTO;
        } else {
            return null;
        }
    }

    /* 설명. 스터디클럽 id로 스터디 일정 조회 */
    public ArrayList<StudyScheduleDTO> findStudyScheduleByStudyId(int studyclubId) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ArrayList<StudySchedule> studyScheduleList = studyScheduleRepository.findByStudyclubId(studyclubId);
        System.out.println("츨력");
        System.out.println(studyScheduleList);
        ArrayList<StudyScheduleDTO> studyScheduleDTOList = new ArrayList<>();
        for (StudySchedule studySchedule: studyScheduleList) {
            studyScheduleDTOList.add(mapper.map(studySchedule, StudyScheduleDTO.class));
        }

        return studyScheduleDTOList;
    }

    /* 설명. 스터디클럽 일정 추가 */
    @Transactional
    public void saveStudySchedule(StudyScheduleDTO studyScheduleDTO) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        StudySchedule studySchedule = mapper.map(studyScheduleDTO, StudySchedule.class);

        studyScheduleRepository.save(studySchedule);
    }

    /* 스터디클럽 일정 수정 */
    @Transactional
    public void modifyStudySchedule(StudyScheduleDTO studyScheduleDTO) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        StudySchedule studySchedule = studyScheduleRepository.findById(studyScheduleDTO.getId());
        studySchedule.setTitle(studyScheduleDTO.getTitle());
        studySchedule.setContent(studyScheduleDTO.getContent());
        studySchedule.setStartDatetime(studySchedule.getStartDatetime());
        studySchedule.setEndDatetime(studyScheduleDTO.getEndDatetime());
    }

    @Transactional
    public void removeStudySchedule(int id) {

        StudySchedule studySchedule = studyScheduleRepository.findById(id);
        studySchedule.setUseState('N');
    }
}

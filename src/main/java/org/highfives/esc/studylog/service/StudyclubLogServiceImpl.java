package org.highfives.esc.studylog.service;

import lombok.extern.slf4j.Slf4j;
import org.highfives.esc.studylog.dao.StudyclubLogMapper;
import org.highfives.esc.studylog.dto.StudyclubLogDTO;
import org.highfives.esc.studylog.entity.StudyclubLog;
import org.highfives.esc.studylog.repository.StudyclubLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class StudyclubLogServiceImpl implements StudyclubLogService {

    private final StudyclubLogRepo studyclubLogRepo;
    private final StudyclubLogMapper studyclubLogMapper;

    @Autowired
    public StudyclubLogServiceImpl(StudyclubLogRepo studyclubLogRepo, StudyclubLogMapper studyclubLogMapper) {
        this.studyclubLogRepo = studyclubLogRepo;
        this.studyclubLogMapper = studyclubLogMapper;
    }

    @Override
    @Transactional
    public StudyclubLogDTO insertStudyLog(StudyclubLogDTO studyclubLogDTOData) {


        StudyclubLog studyclubLog = studyclubLogMapper.studyclubLogDTOTostudyclubLog(studyclubLogDTOData);

        studyclubLogRepo.save(studyclubLog);

        log.info("studyclubLog={}", studyclubLog);

        return studyclubLogDTOData;
    }

    @Override
    @Transactional
    public StudyclubLogDTO updateStudyclubLog(StudyclubLogDTO studyclubLogDTOData) {

        StudyclubLogDTO studyclubLogDTO = StudyclubLogDTO.builder()
                .id(studyclubLogDTOData.getId())
                .content(studyclubLogDTOData.getContent())
                .studydate(studyclubLogDTOData.getStudydate())
                .enrolldate(studyclubLogDTOData.getEnrolldate())
                .studyclubId(studyclubLogDTOData.getStudyclubId())
                .scheduleId(studyclubLogDTOData.getScheduleId())
                .build();

        studyclubLogRepo.save(studyclubLogMapper.studyclubLogDTOTostudyclubLog(studyclubLogDTO));

        return studyclubLogDTO;
    }

    @Override
    @Transactional
    public void deleteStudyLog(String id) {

        studyclubLogRepo.deleteById(Integer.valueOf(id));
    }
}

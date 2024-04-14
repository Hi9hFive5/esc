package org.highfives.esc.studylog.service;

import lombok.extern.slf4j.Slf4j;
import org.highfives.esc.studylog.dao.StudyclubLogMapper;
import org.highfives.esc.studylog.dto.StudyclubLogDTO;
import org.highfives.esc.studylog.dto.StudyclubLogInfoDTO;
import org.highfives.esc.studylog.dto.StudyclubLogMemberInfoDTO;
import org.highfives.esc.studylog.entity.StudyclubLog;
import org.highfives.esc.studylog.repository.StudyclubLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class StudyclubLogServiceImpl implements StudyclubLogService {

    private final StudyclubLogRepository studyclubLogRepository;
    private final StudyclubLogMapper studyclubLogMapper;

    @Autowired
    public StudyclubLogServiceImpl(StudyclubLogRepository studyclubLogRepository, StudyclubLogMapper studyclubLogMapper) {
        this.studyclubLogRepository = studyclubLogRepository;
        this.studyclubLogMapper = studyclubLogMapper;
    }

    @Override
    @Transactional
    public StudyclubLogDTO insertStudyLog(StudyclubLogDTO studyclubLogDTOData) {


        StudyclubLog studyclubLog = studyclubLogMapper.studyclubLogDTOTostudyclubLog(studyclubLogDTOData);

        studyclubLogRepository.save(studyclubLog);

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

        studyclubLogRepository.save(studyclubLogMapper.studyclubLogDTOTostudyclubLog(studyclubLogDTO));

        return studyclubLogDTO;
    }

    @Override
    @Transactional
    public void deleteStudyLog(String id) {

        studyclubLogRepository.deleteById(Integer.valueOf(id));
    }

    @Override
    public StudyclubLogDTO findStudyLogById(String id) throws IllegalAccessException {
            StudyclubLog studyclubLog = studyclubLogRepository.findById(Integer.valueOf(id)).orElseThrow(IllegalAccessException::new);

            return studyclubLogMapper.studyclubLogTostudyclubLogDTO(studyclubLog);

    }

    public List<StudyclubLogInfoDTO> findStudyclubLogById(String studyclubId) {

        List<StudyclubLogInfoDTO> studyclubLog = studyclubLogRepository.findStudyclubLogById(studyclubId);

        return studyclubLog;
    }

    @Override
    public List<StudyclubLogMemberInfoDTO> findWritingStudyclubLogById(String id) {
        List<StudyclubLogMemberInfoDTO> studyclubLog = studyclubLogRepository.findWritingStudyclubLogById(id);

        return studyclubLog;
    }

}

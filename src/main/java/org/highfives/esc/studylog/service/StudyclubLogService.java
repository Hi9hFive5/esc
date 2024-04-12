package org.highfives.esc.studylog.service;

import org.highfives.esc.studylog.dto.StudyclubLogDTO;
import org.highfives.esc.studylog.dto.StudyclubLogInfoDTO;

import java.util.List;

public interface StudyclubLogService {
    StudyclubLogDTO insertStudyLog(StudyclubLogDTO studyclubLogDTOData);

    StudyclubLogDTO updateStudyclubLog(StudyclubLogDTO studyclubLogDTOData);


    void deleteStudyLog(String id);

    StudyclubLogDTO findStudyLogById(String id) throws IllegalAccessException;

    List<StudyclubLogInfoDTO> findStudyclubLogById(String studyclubId);
}

package org.highfives.esc.studylog.service;

import org.highfives.esc.studylog.dto.StudyclubLogDTO;

public interface StudyclubLogService {
    StudyclubLogDTO insertStudyLog(StudyclubLogDTO studyclubLogDTOData);

    StudyclubLogDTO updateStudyclubLog(StudyclubLogDTO studyclubLogDTOData);


    void deleteStudyLog(String id);
}

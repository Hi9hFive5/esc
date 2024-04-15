package org.highfives.esc.studylog.dao;

import javax.annotation.processing.Generated;
import org.highfives.esc.studylog.dto.StudyclubLogDTO;
import org.highfives.esc.studylog.entity.StudyclubLog;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-12T14:30:54+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3 (ojdkbuild)"
)
@Component
public class StudyclubLogMapperImpl implements StudyclubLogMapper {

    @Override
    public StudyclubLog studyclubLogDTOTostudyclubLog(StudyclubLogDTO studyclubLogDTOData) {
        if ( studyclubLogDTOData == null ) {
            return null;
        }

        StudyclubLog.StudyclubLogBuilder studyclubLog = StudyclubLog.builder();

        studyclubLog.id( studyclubLogDTOData.getId() );
        studyclubLog.content( studyclubLogDTOData.getContent() );
        studyclubLog.studydate( studyclubLogDTOData.getStudydate() );
        studyclubLog.enrolldate( studyclubLogDTOData.getEnrolldate() );
        studyclubLog.studyclubId( studyclubLogDTOData.getStudyclubId() );
        studyclubLog.scheduleId( studyclubLogDTOData.getScheduleId() );

        return studyclubLog.build();
    }
}

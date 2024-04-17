package org.highfives.esc.studylog.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudyclubLogDTO {

    private int id;

    private String content;

    private String contentInfo;

    private String studydate;

    private String enrolldate;

    private int studyclubId;

    private int scheduleId;

    @Builder
    public StudyclubLogDTO(int id, String content, String contentInfo, String studydate, String enrolldate, int studyclubId, int scheduleId) {
        this.id = id;
        this.content = content;
        this.contentInfo = contentInfo;
        this.studydate = studydate;
        this.enrolldate = enrolldate;
        this.studyclubId = studyclubId;
        this.scheduleId = scheduleId;
    }
}

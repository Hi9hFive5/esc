package org.highfives.esc.studylog.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudyclubLogDTO {
    private int id;

    private String content;

    private java.util.Date studyDate;

    private java.util.Date enrolldate;

    private int studyclubId;
}

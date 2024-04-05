package org.highfives.esc.studyclub.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyclubDTO {

    private int id;

    private String name;

    private String introduce;

    private int memberLimit;

    private int leaderId;

    private java.util.Date endDate;

    private String deleteStatus;

    private int memberCount;

    private int studyId;

}

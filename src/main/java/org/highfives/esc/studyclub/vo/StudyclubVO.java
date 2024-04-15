package org.highfives.esc.studyclub.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyclubVO {

    private String name;

    private String introduce;

    private int memberLimit;

    private String endDate;

    private int studyId;
  
    private int goalId;
}


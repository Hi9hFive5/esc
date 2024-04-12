package org.highfives.esc.studyclub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "studyclub")
public class Studyclub {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "delete_status")
    private String deleteStatus;

    @Column(name = "name")
    private String name;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "member_count")
    private int memberCount;

    @Column(name = "member_limit")
    private int memberLimit;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "leader_id")
    private int leaderId;

    @Column(name = "study_id")
    private int studyId;

}

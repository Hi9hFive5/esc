package org.highfives.esc.schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "member_schedule")
public class MemberSchedule {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "selected_start_datetime")
    private String startDatetime;

    @Column(name = "selected_end_datetime")
    private String endDatetime;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "studyclub_id")
    private String studyclubId;
}

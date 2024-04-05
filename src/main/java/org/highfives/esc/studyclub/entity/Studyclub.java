package org.highfives.esc.studyclub.entity;

import jakarta.persistence.*;

@Table(name = "studyclub")
@Entity
public class Studyclub {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "introduce", length = 255, nullable = false)
    private String introduce;

    @Column(name = "member_limit", nullable = false)
    private int memberLimit;

    @Column(name = "leader_id", nullable = false)
    private int leaderId;

    @Column(name = "end_date", nullable = false)
    private java.util.Date endDate;

    @Column(name = "delete_status", length = 1, nullable = false)
    private String deleteStatus;

    @Column(name = "member_count", nullable = false)
    private int memberCount;
    @Column(name = "study_id", nullable = false)
    private int studyId;
}

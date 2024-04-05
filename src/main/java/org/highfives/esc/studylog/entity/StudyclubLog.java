package org.highfives.esc.studylog.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "studyclub_log")
public class StudyclubLog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content", length = 2047, nullable = false)
    private String content;

    @Column(name = "studydate", nullable = false)
    private java.util.Date studyDate;

    @Column(name = "enrolldate", length = 50, nullable = false)
    private java.util.Date enrolldate;

    @Column(name = "studyclub_id", length = 50, nullable = false)
    private int studyclubId;


}


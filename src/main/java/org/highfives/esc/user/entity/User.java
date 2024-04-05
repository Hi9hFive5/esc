package org.highfives.esc.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "email", length = 255, nullable = false)
    private String email;
    @Column(name = "nickname", length = 20, nullable = false)
    private String nickname;
    @Column(name = "status", length = 1, nullable = false)
    private String status;
    @Column(name = "password", length = 50, nullable = false)
    private String password;
    @Column(name = "report_count")
    private int reportCount;
    @Column(name = "grade")
    private int grade;
    @Column(name = "point")
    private int point;
    @Column(name = "end_date")
    private java.util.Date endDate;



}

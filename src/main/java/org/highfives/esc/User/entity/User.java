package org.highfives.esc.User.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@ToString
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
    private String endDate;

    @Builder
    public User(int id, String name, String email, String nickname, String status, String password, int reportCount, int grade, int point, String endDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.status = status;
        this.password = password;
        this.reportCount = reportCount;
        this.grade = grade;
        this.point = point;
        this.endDate = endDate;
    }
}

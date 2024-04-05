package org.highfives.esc.recruit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "application_club_recruitment")
public class RecruitApplication {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "recruit_status")
    private String recruitStatus;

//    @JoinColumn(name = "id")
//    @ManyToOne
    @Column(name = "recruit_user_id")
    private int recruitUserId;

    @ManyToOne
    @JoinColumn(name = "recruit_post_id")
    private RecruitPost recruitPost;

}

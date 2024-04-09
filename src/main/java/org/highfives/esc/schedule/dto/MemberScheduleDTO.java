package org.highfives.esc.schedule.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberScheduleDTO {
    private int id;                                 // 멤버 일정 시간 id
    private LocalDateTime selected_start_datetime;  // 선택한 일정 시작 시간
    private LocalDateTime selected_end_datetime;    // 선택한 일정 종료 시간
    private int member_id;                          // 해당 멤버
    private int studyclub_id;                       // 해당 스터디클럽
}

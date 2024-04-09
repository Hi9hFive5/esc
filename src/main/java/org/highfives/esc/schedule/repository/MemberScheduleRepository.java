package org.highfives.esc.schedule.repository;

import org.highfives.esc.schedule.entity.MemberSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberScheduleRepository extends JpaRepository<MemberSchedule,Integer> {
    MemberSchedule findById(int id);
}

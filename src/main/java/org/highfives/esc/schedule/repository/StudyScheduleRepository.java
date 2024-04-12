package org.highfives.esc.schedule.repository;

import org.highfives.esc.schedule.entity.StudySchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyScheduleRepository extends JpaRepository<StudySchedule,Integer> {
}

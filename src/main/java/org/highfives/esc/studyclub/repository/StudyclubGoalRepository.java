package org.highfives.esc.studyclub.repository;

import org.highfives.esc.studyclub.entity.StudyclubGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyclubGoalRepository extends JpaRepository<StudyclubGoal, Integer> {

    @Query("SELECT studyGoal FROM StudyclubGoal studyGoal WHERE studyGoal.clubId = :clubId")
    StudyclubGoal findByClubId(@Param("clubId") int clubId);
}

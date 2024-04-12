package org.highfives.esc.studylog.repository;

import org.highfives.esc.studylog.dto.StudyclubLogInfoDTO;
import org.highfives.esc.studylog.entity.StudyclubLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyclubLogRepository extends JpaRepository<StudyclubLog, Integer> {

    @Query(value = "SELECT new org.highfives.esc.studylog.dto.StudyclubLogInfoDTO(s2.id, s1.content, s1.studyclubId) FROM StudyclubLog s1 JOIN Studyclub s2 ON s2.id = s1.studyclubId WHERE s1.studyclubId = :studyclub_id")
    List<StudyclubLogInfoDTO> findStudyclubLogById(@Param("studyclub_id") String studyclubId);
}

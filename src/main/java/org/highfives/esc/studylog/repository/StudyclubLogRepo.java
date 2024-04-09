package org.highfives.esc.studylog.repository;

import org.highfives.esc.studylog.entity.StudyclubLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyclubLogRepo extends JpaRepository<StudyclubLog, Integer> {
}

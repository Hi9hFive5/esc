package org.highfives.esc.recruit.repository;

import org.highfives.esc.recruit.entity.RecruitApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitApplicationRepo extends JpaRepository<RecruitApplication, Integer> {

}

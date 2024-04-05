package org.highfives.esc.recruit.repository;

import org.highfives.esc.recruit.entity.RecruitPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitPostRepo extends JpaRepository<RecruitPost, Integer> {

}

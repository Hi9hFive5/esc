package org.highfives.esc.recruit.repository;

import org.highfives.esc.recruit.entity.RecruitApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitApplicationRepository extends JpaRepository<RecruitApplication, Integer> {

    @Query("SELECT apply FROM RecruitApplication apply WHERE apply.recruitPostId = :recruitPostId")
    List<RecruitApplication> findAllByRecruitId(@Param("recruitPostId") int recruitPostId);

    @Query("SELECT apply FROM RecruitApplication apply WHERE apply.recruitUserId = :recruitUserId")
    List<RecruitApplication> findAllByUserId(@Param("recruitUserId") int recruitUserId);

}

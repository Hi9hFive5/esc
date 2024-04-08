package org.highfives.esc.recruit.repository;

import org.highfives.esc.recruit.entity.RecruitPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitPostRepo extends JpaRepository<RecruitPost, Integer> {

    @Query("SELECT post FROM RecruitPost post WHERE post.writerId = :writerId")
    List<RecruitPost> findAllByLeaderId(@Param("writerId") int writerId);

}

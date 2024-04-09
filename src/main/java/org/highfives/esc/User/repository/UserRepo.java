package org.highfives.esc.User.repository;

import org.highfives.esc.User.entity.StudyclubMember;
import org.highfives.esc.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {


    @Query(value = "SELECT m FROM StudyclubMember m WHERE m.memberId = :member_id")
    List<StudyclubMember> findJoinStudyClubById(@Param("member_id") String id);
}

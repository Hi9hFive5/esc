package org.highfives.esc.user.repository;

import org.highfives.esc.user.dto.StudyclubInfoDTO;
import org.highfives.esc.user.dto.UserInfoDTO;
import org.highfives.esc.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User,Integer> {


    @Query(value = "SELECT new org.highfives.esc.user.dto.StudyclubInfoDTO(s1.id, s1.name, s2.studyclubId) FROM Studyclub s1 JOIN StudyclubMember s2 ON s1.id = s2.studyclubId WHERE s2.memberId = :member_id")
    List<StudyclubInfoDTO> findJoinStudyClubById(@Param("member_id") String memberId);

    @Query(value = "SELECT new org.highfives.esc.user.dto.UserInfoDTO(u.id, u.name, s.memberId) FROM User u JOIN StudyclubMember s ON u.id = s.memberId WHERE s.studyclubId = :studyclub_id")
    List<UserInfoDTO> findJoinMemberAndNameById(@Param("studyclub_id") String studyclubId);

}

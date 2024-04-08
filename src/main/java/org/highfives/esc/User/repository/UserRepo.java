package org.highfives.esc.User.repository;

import org.highfives.esc.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
//    @Query(value = "SELECT m ")
//    void findAllById();
}

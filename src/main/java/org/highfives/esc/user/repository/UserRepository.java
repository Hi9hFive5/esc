package org.highfives.esc.user.repository;

import org.highfives.esc.user.aggregate.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    UserEntity findByNickname(String nickname);

    UserEntity findByNameAndNickname(String name, String nickname);

    UserEntity findByNameAndEmail(String name, String email);
}

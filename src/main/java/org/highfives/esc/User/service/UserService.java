package org.highfives.esc.User.service;

import org.highfives.esc.User.dto.StudyclubMemberDTO;
import org.highfives.esc.User.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO findUserById(String id);

    List<UserDTO> findUserList();

//    List<UserDTO> findStudyClubById(String id);

    UserDTO banUserById(UserDTO banUser);

    UserDTO updateUserInfoById(UserDTO updateUser);

    List<StudyclubMemberDTO> findJoinStudyClubById(String id);

    UserDTO getUserPoint(UserDTO userDTOdata);

}

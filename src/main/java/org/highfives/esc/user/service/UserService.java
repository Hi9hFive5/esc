package org.highfives.esc.user.service;

import org.highfives.esc.user.dto.StudyclubInfoDTO;
import org.highfives.esc.user.dto.UserDTO;
import org.highfives.esc.user.dto.UserInfoDTO;

import java.util.List;

public interface UserService {

    UserDTO findUserById(String id);

    List<UserDTO> findUserList();

//    List<UserDTO> findStudyClubById(String id);

    UserDTO banUserById(UserDTO banUser);

    UserDTO updateUserInfoById(UserDTO updateUser);


    UserDTO getUserPoint(UserDTO userDTOdata);

    UserDTO userWithdrawalById(UserDTO userDTOData);

    UserDTO signUp(UserDTO userDTOData);

    List<UserInfoDTO> findJoinMemberAndNameById(String studyclubId);

    List<StudyclubInfoDTO> findJoinStudyClubById(String memberId);
}

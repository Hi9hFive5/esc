package org.highfives.esc.User.service;

import lombok.extern.slf4j.Slf4j;
import org.highfives.esc.User.dao.UserMapper;
import org.highfives.esc.User.dto.UserDTO;
import org.highfives.esc.User.entity.User;
import org.highfives.esc.User.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO findUserById(String id) {
        User user = userRepo.findById(Integer.valueOf(id)).orElseThrow(IllegalArgumentException::new);

        return userMapper.userToUserDTO(user);
    }

    @Override
    public List<UserDTO> findUserList() {

        List<User> userList = userRepo.findAll();
        return userMapper.userListToUserListDTO(userList);
    }

//    @Override
//    public List<UserDTO> findStudyClubById(String id) {
//
//        userRepo.findAllById(id);
//
//        return null;     // 필기. 수정하기.
//    }


    @Override
    public UserDTO banUserById(UserDTO banUser) {
        User userInfo = userRepo.findById(banUser.getId()).orElseThrow(IllegalArgumentException::new);

        UserDTO userDTO = UserDTO.builder()
                .id(banUser.getId())
                .name(userInfo.getName())
                .point(userInfo.getPoint())
                .grade(userInfo.getGrade())
                .password(userInfo.getPassword())
                .email(userInfo.getEmail())
                .nickname(userInfo.getNickname())
                .end_date(userInfo.getEndDate())
                .report_count(userInfo.getReportCount())
                .status(banUser.getStatus())
                .build();

        userRepo.save(userMapper.userDTOToUser(userDTO));


        return userDTO;
    }
    @Override
    public UserDTO updateUserInfoById(UserDTO updateUser) {
        UserDTO userDTO = UserDTO.builder()
                .id(updateUser.getId())
                .name(updateUser.getName())
                .point(updateUser.getPoint())
                .grade(updateUser.getGrade())
                .password(updateUser.getPassword())
                .email(updateUser.getEmail())
                .nickname(updateUser.getNickname())
                .end_date(updateUser.getEndDate())
                .report_count(updateUser.getReportCount())
                .status(updateUser.getStatus())
                .build();

        log.info("userDTO={}",userDTO);

        userRepo.save(userMapper.userDTOToUser(userDTO));


        return userDTO;
    }
}

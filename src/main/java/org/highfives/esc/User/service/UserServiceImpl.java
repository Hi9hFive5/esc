package org.highfives.esc.User.service;

import lombok.extern.slf4j.Slf4j;
import org.highfives.esc.User.dao.UserMapper;
import org.highfives.esc.User.dto.StudyclubMemberDTO;
import org.highfives.esc.User.dto.UserDTO;
import org.highfives.esc.User.entity.StudyclubMember;
import org.highfives.esc.User.entity.User;
import org.highfives.esc.User.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public UserDTO findUserById(String id) {
        User user = userRepo.findById(Integer.valueOf(id)).orElseThrow(IllegalArgumentException::new);

        return userMapper.userToUserDTO(user);
    }

    @Override
    @Transactional
    public List<UserDTO> findUserList() {

        List<User> userList = userRepo.findAll();
        return userMapper.userListToUserListDTO(userList);
    }

    @Override
    @Transactional
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
    @Transactional
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

//        log.info("userDTO={}",userDTO);

        userRepo.save(userMapper.userDTOToUser(userDTO));


        return userDTO;
    }


    @Override
    public List<StudyclubMemberDTO> findJoinStudyClubById(String id) {
        List<StudyclubMember> studyclubMembers = userRepo.findJoinStudyClubById(id);

        List <StudyclubMemberDTO> studyclubMemberDTO = userMapper.studyclubMemberToStudyclubMemberDTO(studyclubMembers);

        return studyclubMemberDTO;
    }

    @Override
    public UserDTO getUserPoint(UserDTO userDTOdata) {
        User userInfo = userRepo.findById(userDTOdata.getId()).orElseThrow(IllegalArgumentException::new);



        UserDTO userDTO = UserDTO.builder()
                .id(userInfo.getId())
                .name(userInfo.getName())
                .grade(userInfo.getGrade())
                .point(userInfo.getPoint() + userDTOdata.getPoint())
                .password(userInfo.getPassword())
                .email(userInfo.getEmail())
                .nickname(userInfo.getNickname())
                .end_date(userInfo.getEndDate())
                .report_count(userInfo.getReportCount())
                .status(userInfo.getStatus())
                .build();

        if(userDTO.getPoint() >= 500)
        {
            int grade = userDTO.getPoint() / 500;
            int exp = userDTO.getPoint() % 500;

            UserDTO userGrade = UserDTO.builder()
                    .id(userDTO.getId())
                    .name(userDTO.getName())
                    .grade(userDTO.getGrade() + grade)
                    .point(exp)
                    .password(userDTO.getPassword())
                    .email(userDTO.getEmail())
                    .nickname(userDTO.getNickname())
                    .end_date(userDTO.getEndDate())
                    .report_count(userDTO.getReportCount())
                    .status(userDTO.getStatus())
                    .build();

            userRepo.save(userMapper.userDTOToUser(userGrade));

            return userGrade;
        }

        userRepo.save(userMapper.userDTOToUser(userDTO));

        return userDTO;
    }
}
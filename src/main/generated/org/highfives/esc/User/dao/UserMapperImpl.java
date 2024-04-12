package org.highfives.esc.User.dao;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.highfives.esc.User.dto.StudyclubMemberDTO;
import org.highfives.esc.User.dto.UserDTO;
import org.highfives.esc.User.entity.StudyclubMember;
import org.highfives.esc.User.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-12T14:30:54+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3 (ojdkbuild)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( user.getId() );
        userDTO.name( user.getName() );
        userDTO.email( user.getEmail() );
        userDTO.nickname( user.getNickname() );
        userDTO.status( user.getStatus() );
        userDTO.password( user.getPassword() );
        userDTO.grade( user.getGrade() );
        userDTO.point( user.getPoint() );

        return userDTO.build();
    }

    @Override
    public List<UserDTO> userListToUserListDTO(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( userToUserDTO( user ) );
        }

        return list;
    }

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDTO.getId() );
        user.name( userDTO.getName() );
        user.email( userDTO.getEmail() );
        user.nickname( userDTO.getNickname() );
        user.status( userDTO.getStatus() );
        user.password( userDTO.getPassword() );
        user.reportCount( userDTO.getReportCount() );
        user.grade( userDTO.getGrade() );
        user.point( userDTO.getPoint() );
        user.endDate( userDTO.getEndDate() );

        return user.build();
    }

    @Override
    public List<StudyclubMemberDTO> studyclubMemberToStudyclubMemberDTO(List<StudyclubMember> studyclubMembers) {
        if ( studyclubMembers == null ) {
            return null;
        }

        List<StudyclubMemberDTO> list = new ArrayList<StudyclubMemberDTO>( studyclubMembers.size() );
        for ( StudyclubMember studyclubMember : studyclubMembers ) {
            list.add( studyclubMemberToStudyclubMemberDTO1( studyclubMember ) );
        }

        return list;
    }

    protected StudyclubMemberDTO studyclubMemberToStudyclubMemberDTO1(StudyclubMember studyclubMember) {
        if ( studyclubMember == null ) {
            return null;
        }

        StudyclubMemberDTO.StudyclubMemberDTOBuilder studyclubMemberDTO = StudyclubMemberDTO.builder();

        studyclubMemberDTO.id( studyclubMember.getId() );
        studyclubMemberDTO.memberId( studyclubMember.getMemberId() );
        studyclubMemberDTO.studyclubId( studyclubMember.getStudyclubId() );
        studyclubMemberDTO.memberType( studyclubMember.getMemberType() );

        return studyclubMemberDTO.build();
    }
}

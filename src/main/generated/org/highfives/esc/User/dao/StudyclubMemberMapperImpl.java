package org.highfives.esc.User.dao;

import javax.annotation.processing.Generated;
import org.highfives.esc.User.dto.StudyclubMemberDTO;
import org.highfives.esc.User.entity.StudyclubMember;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-12T14:30:54+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3 (ojdkbuild)"
)
@Component
public class StudyclubMemberMapperImpl implements StudyclubMemberMapper {

    @Override
    public StudyclubMemberDTO studyclubMemberToStudyclubMemberDTO(StudyclubMember studyclubMember) {
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

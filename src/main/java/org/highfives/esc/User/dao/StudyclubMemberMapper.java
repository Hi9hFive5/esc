package org.highfives.esc.User.dao;

import org.highfives.esc.User.dto.StudyclubMemberDTO;
import org.highfives.esc.User.entity.StudyclubMember;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudyclubMemberMapper {
    StudyclubMemberMapper INSTANCE = Mappers.getMapper(StudyclubMemberMapper.class);

    StudyclubMemberDTO studyclubMemberToStudyclubMemberDTO(StudyclubMember studyclubMember);
}

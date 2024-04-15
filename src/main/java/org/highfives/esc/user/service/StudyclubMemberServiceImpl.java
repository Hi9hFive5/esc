package org.highfives.esc.user.service;

import lombok.extern.slf4j.Slf4j;
import org.highfives.esc.user.dao.StudyclubMemberMapper;
import org.highfives.esc.user.dto.StudyclubMemberDTO;
import org.highfives.esc.user.entity.StudyclubMember;
import org.highfives.esc.user.repository.StudyclubMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudyclubMemberServiceImpl implements StudyclubMemberService {

    private final StudyclubMemberMapper studyclubMemberMapper;

    private final StudyclubMemberRepository studyclubMemberRepository;

    @Autowired
    public StudyclubMemberServiceImpl(StudyclubMemberMapper studyclubMemberMapper, StudyclubMemberRepository studyclubMemberRepository) {
        this.studyclubMemberMapper = studyclubMemberMapper;
        this.studyclubMemberRepository = studyclubMemberRepository;
    }

    @Override
    public StudyclubMemberDTO insetMemberById(String memberId, String studyclubId) {

        StudyclubMember studyclubMember = StudyclubMember.builder()
                .memberId(Integer.parseInt(memberId))
                .studyclubId(Integer.parseInt(studyclubId))
                .memberType("T")
                .build();

        studyclubMemberRepository.save(studyclubMember);

        return studyclubMemberMapper.studyclubMemberToStudyclubMemberDTO(studyclubMember);
    }

    @Override
    public void deleteByMemberIdAndStudyclubId(String memberId, String studyclubId) {

        studyclubMemberRepository.deleteByMemberIdAndStudyclubId(memberId,studyclubId);
    }
}

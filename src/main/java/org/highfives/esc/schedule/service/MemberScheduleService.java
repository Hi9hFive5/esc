package org.highfives.esc.schedule.service;


import org.highfives.esc.schedule.dto.MemberScheduleDTO;

import org.highfives.esc.schedule.entity.MemberSchedule;
import org.highfives.esc.schedule.repository.MemberScheduleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberScheduleService {

    private final ModelMapper mapper;
    private final MemberScheduleRepository memberScheduleRepository;

    @Autowired
    public MemberScheduleService(ModelMapper mapper, MemberScheduleRepository memberScheduleRepository) {
        this.mapper = mapper;
        this.memberScheduleRepository = memberScheduleRepository;
    }

    public MemberScheduleDTO findMemberScheduleById(int id) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        MemberSchedule memberSchedule = memberScheduleRepository.findById(id);
        if (memberSchedule != null) {
            MemberScheduleDTO memberScheduleDTO = mapper.map(memberSchedule, MemberScheduleDTO.class);
            System.out.println(memberScheduleDTO);

            return memberScheduleDTO;
        } else {
            return null;
        }
    }

    public ArrayList<MemberScheduleDTO> findMemberScheduleByMemberId(int memberId) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ArrayList<MemberSchedule> memberScheduleList = memberScheduleRepository.findByMemberId(memberId);
        ArrayList<MemberScheduleDTO> memberScheduleDTOList = new ArrayList<>();

        for (MemberSchedule memberSchedule: memberScheduleList) {
            memberScheduleDTOList.add(mapper.map(memberSchedule, MemberScheduleDTO.class));
        }

        return memberScheduleDTOList;
    }

    public ArrayList<MemberScheduleDTO> findMemberScheduleByStudyclubId(int studyclueId) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ArrayList<MemberSchedule> memberScheduleList = memberScheduleRepository.findByStudyclubId(studyclueId);
        ArrayList<MemberScheduleDTO> memberScheduleDTOList = new ArrayList<>();

        for (MemberSchedule memberSchedule: memberScheduleList) {
            memberScheduleDTOList.add(mapper.map(memberSchedule, MemberScheduleDTO.class));
        }

        return memberScheduleDTOList;
    }

    @Transactional
    public void saveMemberSchedule(MemberScheduleDTO memberScheduleDTO) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        MemberSchedule memberSchedule = new MemberSchedule();
        memberSchedule.setStartDatetime(memberScheduleDTO.getStartDatetime());
        memberSchedule.setEndDatetime(memberScheduleDTO.getEndDatetime());
        memberSchedule.setMemberId(memberScheduleDTO.getMemberId());
        memberSchedule.setStudyclubId(memberScheduleDTO.getStudyclubId());

        memberScheduleRepository.save(memberSchedule);
    }

    @Transactional
    public void modifyMemberSchedule(MemberScheduleDTO memberScheduleDTO) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // 설명. id로 변경할 일정 조회
        MemberSchedule memberSchedule = memberScheduleRepository.findById(memberScheduleDTO.getId());

        // 설명. 일정 시간 변경
        memberSchedule.setStartDatetime(memberScheduleDTO.getStartDatetime());
        memberSchedule.setEndDatetime(memberScheduleDTO.getEndDatetime());
    }

    @Transactional
    public void removeMemberSchedule(int id) {

        memberScheduleRepository.deleteById(id);
    }
}

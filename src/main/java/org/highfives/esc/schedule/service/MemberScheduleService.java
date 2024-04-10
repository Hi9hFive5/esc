package org.highfives.esc.schedule.service;


import org.highfives.esc.schedule.dto.MemberScheduleDTO;

import org.highfives.esc.schedule.entity.MemberSchedule;
import org.highfives.esc.schedule.repository.MemberScheduleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.out.println(id);
        MemberSchedule memberSchedule = memberScheduleRepository.findById(id);
        System.out.println(memberSchedule);

        MemberScheduleDTO memberScheduleDTO = mapper.map(memberSchedule, MemberScheduleDTO.class);
        System.out.println(memberScheduleDTO);

        return memberScheduleDTO;
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
}

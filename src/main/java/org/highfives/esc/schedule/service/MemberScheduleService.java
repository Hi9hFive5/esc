package org.highfives.esc.schedule.service;

import org.highfives.esc.schedule.repository.MemberScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberScheduleService {

    private final MemberScheduleRepository memberScheduleRepository;

    public MemberScheduleService(MemberScheduleRepository memberScheduleRepository) {
        this.memberScheduleRepository = memberScheduleRepository;
    }
}

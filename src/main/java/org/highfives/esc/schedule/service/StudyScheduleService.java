package org.highfives.esc.schedule.service;

import org.highfives.esc.schedule.repository.StudyScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyScheduleService {

    private final ModelMapper mapper;
    private final StudyScheduleRepository studyScheduleRepository;

    @Autowired
    public StudyScheduleService(ModelMapper mapper, StudyScheduleRepository studyScheduleRepository) {
        this.mapper = mapper;
        this.studyScheduleRepository = studyScheduleRepository;
    }
}

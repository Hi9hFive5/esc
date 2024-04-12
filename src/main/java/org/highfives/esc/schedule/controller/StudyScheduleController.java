package org.highfives.esc.schedule.controller;

import org.highfives.esc.schedule.service.StudyScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/study-schedule")
public class StudyScheduleController {

    private final ModelMapper mapper;
    private final StudyScheduleService studyScheduleService;

    @Autowired

    public StudyScheduleController(ModelMapper mapper, StudyScheduleService studyScheduleService) {
        this.mapper = mapper;
        this.studyScheduleService = studyScheduleService;
    }
}

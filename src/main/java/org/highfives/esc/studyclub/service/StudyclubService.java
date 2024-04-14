package org.highfives.esc.studyclub.service;

import org.highfives.esc.studyclub.dto.GoalDTO;
import org.highfives.esc.studyclub.dto.StudyCategoryDTO;
import org.highfives.esc.studyclub.dto.StudyclubDTO;
import org.highfives.esc.studyclub.entity.Goal;
import org.highfives.esc.studyclub.entity.StudyCategory;
import org.highfives.esc.studyclub.entity.Studyclub;
import org.highfives.esc.studyclub.entity.StudyclubGoal;
import org.highfives.esc.studyclub.repository.GoalRepository;
import org.highfives.esc.studyclub.repository.StudyCategoryRepo;
import org.highfives.esc.studyclub.repository.StudyclubGoalRepository;
import org.highfives.esc.studyclub.repository.StudyclubRepo;
import org.highfives.esc.studyclub.vo.StudyclubVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudyclubService {

    private final ModelMapper mapper;
    private final StudyclubRepo studyclubRepo;
    private final StudyCategoryRepo studyCategoryRepo;
    private final StudyclubGoalRepository studyclubGoalRepository;
    private final GoalRepository goalRepository;

    @Autowired
    public StudyclubService(ModelMapper mapper, StudyclubRepo studyclubRepo, StudyCategoryRepo studyCategoryRepo, StudyclubGoalRepository studyclubGoalRepository, GoalRepository goalRepository) {
        this.mapper = mapper;
        this.studyclubRepo = studyclubRepo;
        this.studyCategoryRepo = studyCategoryRepo;
        this.studyclubGoalRepository = studyclubGoalRepository;
        this.goalRepository = goalRepository;
    }

    @Transactional(readOnly = true)
    public List<StudyclubDTO> findStudyclubsByLeaderId(int leaderId) {

        List<Studyclub> studyclubList = studyclubRepo.findAll();
        List<StudyclubDTO> studyclubDTOList = new ArrayList<>();

        for (Studyclub studyclub : studyclubList) {
            studyclubDTOList.add(mapper.map(studyclub, StudyclubDTO.class));
        }

        return studyclubDTOList;
    }

    @Transactional(readOnly = true)
    public StudyclubDTO findStudyclubById(int studyclubId) {

        Studyclub studyclub = studyclubRepo.findById(studyclubId).orElseThrow(IllegalArgumentException::new);

        return mapper.map(studyclub, StudyclubDTO.class);
    }

    @Transactional
    public StudyclubDTO registStudyclub(StudyclubVO studyclubVO, int leaderId) {

        Studyclub studyclub = new Studyclub();
        StudyclubGoal studyclubGoal = new StudyclubGoal();

        studyclub.setName(studyclubVO.getName());
        studyclub.setIntroduce(studyclubVO.getIntroduce());
        studyclub.setMemberLimit(studyclubVO.getMemberLimit());
        studyclub.setEndDate(studyclubVO.getEndDate());
        studyclub.setStudyId(studyclubVO.getStudyId());

        studyclub.setLeaderId(leaderId);
        studyclub.setDeleteStatus("N");

        studyclubRepo.save(studyclub);

        studyclubGoal.setClubId(studyclub.getId());
        studyclubGoal.setGoalId(studyclubVO.getGoalId());

        studyclubGoalRepository.save(studyclubGoal);

        return mapper.map(studyclub, StudyclubDTO.class);
    }

    @Transactional
    public StudyclubDTO modifyStudyclub(int studyclubId, StudyclubVO studyclubVO) {

        Studyclub studyclub = studyclubRepo.findById(studyclubId).orElseThrow(IllegalArgumentException::new);

        studyclub.setName(studyclubVO.getName());
        studyclub.setIntroduce(studyclubVO.getIntroduce());
        studyclub.setMemberLimit(studyclubVO.getMemberLimit());
        studyclub.setEndDate(studyclubVO.getEndDate());
        studyclub.setStudyId(studyclubVO.getStudyId());

        StudyclubGoal studyclubGoal = studyclubGoalRepository.findByClubId(studyclubId);

        studyclubGoal.setGoalId(studyclubVO.getGoalId());

        return mapper.map(studyclub, StudyclubDTO.class);
    }

    @Transactional
    public StudyclubDTO deleteStudyclub(int studyclubId) {

        Studyclub studyclub = studyclubRepo.findById(studyclubId).orElseThrow(IllegalArgumentException::new);

        studyclub.setDeleteStatus("Y");

        return mapper.map(studyclub, StudyclubDTO.class);
    }

    public StudyCategoryDTO findStudyCategoryById(int categoryId) {

        StudyCategory studyCategory = studyCategoryRepo.findById(categoryId).orElseThrow(IllegalArgumentException::new);

        return mapper.map(studyCategory, StudyCategoryDTO.class);
    }

    public List<StudyCategoryDTO> findAllStudyCategory() {

        List<StudyCategory> studyCategoryList = studyCategoryRepo.findAll();
        List<StudyCategoryDTO> studyCategoryDTOList = new ArrayList<>();

        for (StudyCategory studyCategory : studyCategoryList) {
            studyCategoryDTOList.add(mapper.map(studyCategory, StudyCategoryDTO.class));
        }

        return studyCategoryDTOList;
    }

    public List<GoalDTO> findGoalsByStudyId(int studyId) {

        List<Goal> goalList = goalRepository.findAllByStudyId(studyId);
        List<GoalDTO> goalDTOList = new ArrayList<>();

        for (Goal goal : goalList) {
            goalDTOList.add(mapper.map(goal, GoalDTO.class));
        }

        return goalDTOList;
    }


    public GoalDTO findGoalByClubId(int clubId) {

        StudyclubGoal studyclubGoal = studyclubGoalRepository.findByClubId(clubId);

        Goal goal = goalRepository.findById(studyclubGoal.getGoalId()).orElseThrow(IllegalArgumentException:: new);

        return mapper.map(goal, GoalDTO.class);
    }
}

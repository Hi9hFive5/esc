package org.highfives.esc.studyclub.service;

import org.highfives.esc.studyclub.dto.StudyclubDTO;
import org.highfives.esc.studyclub.entity.Studyclub;
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

    @Autowired
    public StudyclubService(ModelMapper mapper, StudyclubRepo studyclubRepo) {
        this.mapper = mapper;
        this.studyclubRepo = studyclubRepo;
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

        studyclub.setName(studyclubVO.getName());
        studyclub.setIntroduce(studyclubVO.getIntroduce());
        studyclub.setMemberLimit(studyclubVO.getMemberLimit());
        studyclub.setEndDate(studyclubVO.getEndDate());
        studyclub.setStudyId(studyclubVO.getStudyId());

        studyclub.setLeaderId(leaderId);
        studyclub.setDeleteStatus("N");

        studyclubRepo.save(studyclub);

        return mapper.map(studyclub, StudyclubDTO.class);
    }

    @Transactional
    public StudyclubDTO modifyStudyclub(int studyclubId, StudyclubVO studyclubVO) {

        Studyclub studyclub = studyclubRepo.findById(studyclubId).orElseThrow(IllegalArgumentException::new);

        studyclub.setName(studyclubVO.getName());
        studyclub.setIntroduce(studyclubVO.getIntroduce());
        studyclub.setMemberLimit(studyclubVO.getMemberLimit());
        studyclub.setEndDate(studyclubVO.getEndDate());

        return mapper.map(studyclub, StudyclubDTO.class);
    }

    @Transactional
    public StudyclubDTO deleteStudyclub(int studyclubId) {

        Studyclub studyclub = studyclubRepo.findById(studyclubId).orElseThrow(IllegalArgumentException::new);

        studyclub.setDeleteStatus("Y");

        return mapper.map(studyclub, StudyclubDTO.class);
    }
}

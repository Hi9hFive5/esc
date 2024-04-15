package org.highfives.esc.recruit.service;

import org.highfives.esc.recruit.dto.RecruitApplicationDTO;
import org.highfives.esc.recruit.dto.RecuitApplicationInfoDTO;
import org.highfives.esc.recruit.entity.RecruitApplication;
import org.highfives.esc.recruit.entity.RecruitPost;
import org.highfives.esc.recruit.repository.RecruitApplicationRepo;
import org.highfives.esc.recruit.repository.RecruitPostRepo;
import org.highfives.esc.studyclub.entity.Studyclub;
import org.highfives.esc.studyclub.repository.StudyclubRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecruitApplicationService {

    private final ModelMapper mapper;

    private final RecruitApplicationRepo recruitApplicationRepo;
    private final RecruitPostRepo recruitPostRepo;
    private final StudyclubRepo studyclubRepo;

    @Autowired
    public RecruitApplicationService(ModelMapper mapper, RecruitApplicationRepo recruitApplicationRepo, RecruitPostRepo recruitPostRepo, StudyclubRepo studyclubRepo) {
        this.mapper = mapper;
        this.recruitApplicationRepo = recruitApplicationRepo;
        this.recruitPostRepo = recruitPostRepo;
        this.studyclubRepo = studyclubRepo;
    }

    @Transactional(readOnly = true)
    public List<RecuitApplicationInfoDTO> findAllByRecruitId(int recruitPostId) {

        List<RecuitApplicationInfoDTO> recruitApplicationList = recruitApplicationRepo.findAllByRecruitId(recruitPostId);



        return recruitApplicationList;
    }

    @Transactional(readOnly = true)
    public List<RecruitApplicationDTO> findAllByUserId(int userId) {

        List<RecruitApplication> recruitApplicationList = recruitApplicationRepo.findAllByUserId(userId);
        List<RecruitApplicationDTO> recruitApplicationDTOList = new ArrayList<>();

        for (RecruitApplication recruitApplication : recruitApplicationList) {
            recruitApplicationDTOList.add(mapper.map(recruitApplication, RecruitApplicationDTO.class));
        }

        return recruitApplicationDTOList;
    }

    @Transactional
    public RecruitApplicationDTO registApplication(int userId, int postId) {

        RecruitApplication recruitApplication = new RecruitApplication();

        recruitApplication.setRecruitStatus("대기");
        recruitApplication.setRecruitUserId(userId);
        recruitApplication.setRecruitPostId(postId);

        recruitApplicationRepo.save(recruitApplication);

        return mapper.map(recruitApplication, RecruitApplicationDTO.class);
    }

    @Transactional
    public RecruitApplicationDTO acceptApplication(int applyId) {

        RecruitApplication recruitApplication = recruitApplicationRepo.findById(applyId).orElseThrow(IllegalArgumentException::new);

        recruitApplication.setRecruitStatus("수락");

        RecruitPost recruitPost = recruitPostRepo.findById(recruitApplication.getRecruitPostId()).orElseThrow(IllegalArgumentException::new);
        Studyclub studyclub = studyclubRepo.findById(recruitPost.getClubId()).orElseThrow(IllegalArgumentException::new);

        studyclub.setMemberCount(studyclub.getMemberCount() + 1);

        return mapper.map(recruitApplication, RecruitApplicationDTO.class);
    }

    @Transactional
    public RecruitApplicationDTO rejectApplication(int applyId) {

        RecruitApplication recruitApplication = recruitApplicationRepo.findById(applyId).orElseThrow(IllegalArgumentException::new);

        recruitApplication.setRecruitStatus("거절");

        return mapper.map(recruitApplication, RecruitApplicationDTO.class);
    }

    @Transactional
    public void deleteApplication(int applyId) {

        recruitApplicationRepo.deleteById(applyId);
    }
}

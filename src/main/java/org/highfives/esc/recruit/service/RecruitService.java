package org.highfives.esc.recruit.service;

import org.highfives.esc.recruit.dto.RecruitPostDTO;
import org.highfives.esc.recruit.entity.RecruitPost;
import org.highfives.esc.recruit.repository.RecruitPostRepo;
import org.highfives.esc.recruit.vo.RecruitPostVO;
import org.highfives.esc.studyclub.dto.StudyclubDTO;
import org.highfives.esc.studyclub.service.StudyclubService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecruitService {

    private final ModelMapper mapper;
    private final RecruitPostRepo recruitPostRepo;
    private final StudyclubService studyclubService;

    @Autowired
    public RecruitService(ModelMapper mapper, RecruitPostRepo recruitPostRepo, StudyclubService studyclubService) {
        this.mapper = mapper;
        this.recruitPostRepo = recruitPostRepo;
        this.studyclubService = studyclubService;
    }

    @Transactional(readOnly = true)
    public List<RecruitPostDTO> findAllRecruitPosts() {

        List<RecruitPost> recruitPostList = recruitPostRepo.findAll();
        List<RecruitPostDTO> recruitPostDTOList = new ArrayList<>();

        for (RecruitPost recruitPost : recruitPostList) {
            recruitPostDTOList.add(mapper.map(recruitPost, RecruitPostDTO.class));
        }

        return recruitPostDTOList;
    }

    @Transactional(readOnly = true)
    public List<RecruitPostDTO> findRecruitPostsByLeaderId(int leaderId) {

        List<RecruitPost> recruitPostList = recruitPostRepo.findAllByLeaderId(leaderId);
        List<RecruitPostDTO> recruitPostDTOList = new ArrayList<>();

        for (RecruitPost recruitPost : recruitPostList) {
            recruitPostDTOList.add(mapper.map(recruitPost, RecruitPostDTO.class));
        }

        return recruitPostDTOList;
    }

    @Transactional(readOnly = true)
    public RecruitPostDTO findRecruitPostById(int postId) {

        RecruitPost recruitPost = recruitPostRepo.findById(postId).orElseThrow(IllegalArgumentException::new);

        return mapper.map(recruitPost, RecruitPostDTO.class);
    }


    @Transactional
    public RecruitPostDTO registRecruitPost(RecruitPostVO recruitPostVO, int clubId) {

        RecruitPost recruitPost = new RecruitPost();

        recruitPost.setTitle(recruitPostVO.getTitle());
        recruitPost.setContent(recruitPostVO.getContent());

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        recruitPost.setCreatedDate(formattedDate);
        recruitPost.setDeleteStatus("N");
        recruitPost.setRecruitStatus("N");

        StudyclubDTO studyclub = studyclubService.findStudyclubById(clubId);

        recruitPost.setWriterId(studyclub.getLeaderId());
        recruitPost.setClubId(clubId);

        recruitPostRepo.save(recruitPost);

        return mapper.map(recruitPost, RecruitPostDTO.class);
    }

    @Transactional
    public RecruitPostDTO modifyRecruitPost(int recruitId, RecruitPostVO recruitPostVO) {

        RecruitPost recruitPost = recruitPostRepo.findById(recruitId).orElseThrow(IllegalArgumentException::new);

        recruitPost.setTitle(recruitPostVO.getTitle());
        recruitPost.setContent(recruitPostVO.getContent());

//        recruitPost.setDeleteStatus("E");
//        recruitPost.setCreatedDate(formattedDate);

        return mapper.map(recruitPost, RecruitPostDTO.class);
    }

    @Transactional
    public RecruitPostDTO deleteRecruitPost(int recruitId) {

        RecruitPost recruitPost = recruitPostRepo.findById(recruitId).orElseThrow(IllegalArgumentException::new);

        recruitPost.setDeleteStatus("Y");


        return mapper.map(recruitPost, RecruitPostDTO.class);
    }
}

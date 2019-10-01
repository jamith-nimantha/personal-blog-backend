package com.jamith.absd.personalblog.service.impl;

import com.jamith.absd.personalblog.dto.DetailDTO;
import com.jamith.absd.personalblog.dto.StatDTO;
import com.jamith.absd.personalblog.entity.Detail;
import com.jamith.absd.personalblog.repository.CommentRepository;
import com.jamith.absd.personalblog.repository.DetailRepository;
import com.jamith.absd.personalblog.repository.PostRepository;
import com.jamith.absd.personalblog.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public DetailDTO getDetails() {
        Detail detail = detailRepository.findAll().get(0);

        DetailDTO detailDTO = new DetailDTO();
        detailDTO.setName(detail.getBlogName());
        detailDTO.setDescription(detail.getBlogDescription());
        detailDTO.setDomain(detail.getBlogDomain());
        detailDTO.setLinkedin(detail.getLinkedinURL());
        detailDTO.setFacebook(detail.getFacebookURL());
        detailDTO.setTwitter(detail.getTwitterURL());
        detailDTO.setGithub(detail.getGithubURL());

        return detailDTO;
    }


    @Override
    public boolean updateDetails(DetailDTO dto) {
        Detail detail = detailRepository.findAll().get(0);

        detail.setBlogName(dto.getName());
        detail.setBlogDescription(dto.getDescription());
        detail.setBlogDomain(dto.getDomain());
        detail.setLinkedinURL(dto.getLinkedin());
        detail.setFacebookURL(dto.getFacebook());
        detail.setTwitterURL(dto.getTwitter());
        detail.setGithubURL(dto.getGithub());

        return detailRepository.save(detail) != null;
    }

    @Override
    public StatDTO getStats() {
        StatDTO dto = new StatDTO();
        dto.setPostCount(postRepository.getTotalPostsCount());
        dto.setCommentCount(commentRepository.getTotalCommentCount());
        dto.setViewsCount(postRepository.getTotalPostViews());
        return dto;
    }
}

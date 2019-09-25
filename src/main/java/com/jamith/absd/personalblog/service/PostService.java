package com.jamith.absd.personalblog.service;

import com.jamith.absd.personalblog.dto.PostDTO;
import com.jamith.absd.personalblog.dto.PublicPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    boolean createPost(PostDTO dto);

    List<PostDTO> getAllPosts();

    boolean changePostStatus(Integer id);

    boolean deletePost(Integer id);

    List<PublicPostDTO> getAllPublicPosts();
}

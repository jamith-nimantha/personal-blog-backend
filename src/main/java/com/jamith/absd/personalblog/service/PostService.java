package com.jamith.absd.personalblog.service;

import com.jamith.absd.personalblog.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    boolean createPost(PostDTO dto);

    List<PostDTO> getAllPosts();
    
    boolean changePostStatus(Integer id);
}

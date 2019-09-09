package com.jamith.absd.personalblog.service.impl;

import com.jamith.absd.personalblog.dto.PostDTO;
import com.jamith.absd.personalblog.entity.Image;
import com.jamith.absd.personalblog.entity.Post;
import com.jamith.absd.personalblog.repository.ImageRepository;
import com.jamith.absd.personalblog.repository.PostRepository;
import com.jamith.absd.personalblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public boolean createPost(PostDTO dto) {
        Image image = new Image();
        image.setPath(dto.getImage());
        image = imageRepository.save(image);

        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setStatus(true);
        post.setViews(0);
        post.setCreatedDate(new Date());
        post.setImage(image);

        Post save = postRepository.save(post);
        System.out.println(save);
        return post != null;
    }

    @Override
    public List<PostDTO> getAllPosts() {
       return postRepository.getAllByCreatedDate().stream().map(Post::getPostDTO).collect(Collectors.toList());
    }
}

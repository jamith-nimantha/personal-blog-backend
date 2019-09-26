package com.jamith.absd.personalblog.service.impl;

import com.jamith.absd.personalblog.dto.PostDTO;
import com.jamith.absd.personalblog.dto.PublicPostDTO;
import com.jamith.absd.personalblog.entity.Image;
import com.jamith.absd.personalblog.entity.Post;
import com.jamith.absd.personalblog.repository.ImageRepository;
import com.jamith.absd.personalblog.repository.PostRepository;
import com.jamith.absd.personalblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        post.setPermalink(dto.getTitle().toLowerCase().replace('\'',' ').replace(' ','-'));
        post.setContent(dto.getContent());
        post.setStatus(true);
        post.setViews(0);
        post.setCreatedDate(new Date());
        post.setImage(image);

        return postRepository.save(post) != null;
    }

    @Override
    public List<PostDTO> getAllPosts() {
       return postRepository.getAllByCreatedDate().stream().map(Post::getAdminPostDTO).collect(Collectors.toList());
    }

    @Override
    public boolean changePostStatus(Integer id) {
        return postRepository.updateStatus(!postRepository.findTopById(id).isStatus(), id) == 1;
    }

    @Override
    public boolean deletePost(Integer id) {
        postRepository.delete(postRepository.findTopById(id));
        return true;
    }

    @Override
    public PublicPostDTO getPostByPermalink(String permalink) {
        Post post = postRepository.findTopByPermalink(permalink); // TODO you have to handle a custom exception here
        if (post!=null) {
            post.setViews(post.getViews()+1);
            postRepository.save(post);
            PublicPostDTO publicPostDTO =  new PublicPostDTO();
            publicPostDTO.setTitle(post.getTitle());
            publicPostDTO.setPermalink(post.getPermalink());
            publicPostDTO.setContent(post.getContent());
            publicPostDTO.setId(post.getId());
            publicPostDTO.setCreatedDate(post.getCreatedDate());
            publicPostDTO.setImage(post.getImage().getPath());
            return publicPostDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<PublicPostDTO> getAllPublicPosts() {
        List<Post> allByStatus = postRepository.getAllByStatus();
        List<PublicPostDTO> dtos = new ArrayList<>();
        for (Post post: allByStatus){
            PublicPostDTO publicPostDTO =  new PublicPostDTO();
            publicPostDTO.setTitle(post.getTitle());
            publicPostDTO.setPermalink(post.getPermalink());
            publicPostDTO.setId(post.getId());
            publicPostDTO.setCreatedDate(post.getCreatedDate());
            publicPostDTO.setImage(post.getImage().getPath());
            try {
                publicPostDTO.setContent(post.getContent().substring(0,480).concat("..."));
            } catch (Exception e) {
                publicPostDTO.setContent(post.getContent());
            }
            dtos.add(publicPostDTO);
        }
        return dtos;
    }
}

package com.jamith.absd.personalblog.service.impl;

import com.jamith.absd.personalblog.dto.CommentDTO;
import com.jamith.absd.personalblog.entity.Comment;
import com.jamith.absd.personalblog.entity.Post;
import com.jamith.absd.personalblog.repository.CommentRepository;
import com.jamith.absd.personalblog.repository.PostRepository;
import com.jamith.absd.personalblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public boolean saveComment(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setName(dto.getName());
        comment.setComment(dto.getComment());
        comment.setDate(new Date());

        Post topById = postRepository.findTopById(dto.getId());
        comment.setPost(topById);

        return commentRepository.save(comment) != null;
    }

    @Override
    public List<CommentDTO> getAllCommentByPermalink(String permalink) {
        Post topByPermalink = postRepository.findTopByPermalink(permalink);
        return commentRepository.getAllByPostId(topByPermalink.getId()).stream()
                .map(Comment::getDtos).collect(Collectors.toList());
    }
}

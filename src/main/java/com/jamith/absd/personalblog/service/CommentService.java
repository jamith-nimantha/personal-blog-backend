package com.jamith.absd.personalblog.service;

import com.jamith.absd.personalblog.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    boolean saveComment(CommentDTO dto);

    List<CommentDTO> getAllCommentByPermalink(String permalink);
}

package com.jamith.absd.personalblog.controller;

import com.jamith.absd.personalblog.dto.CommentDTO;
import com.jamith.absd.personalblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity saveComment(@RequestBody CommentDTO commentDTO){
        return new ResponseEntity(commentService.saveComment(commentDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/{permalink}")
    public ResponseEntity getAllCommentByPermalink(@PathVariable (name = "permalink") String permalink){
        return new ResponseEntity(commentService.getAllCommentByPermalink(permalink),HttpStatus.OK);
    }
}

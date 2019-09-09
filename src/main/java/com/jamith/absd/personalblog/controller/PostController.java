package com.jamith.absd.personalblog.controller;

import com.jamith.absd.personalblog.dto.PostDTO;
import com.jamith.absd.personalblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create-post")
    public ResponseEntity savePost(@RequestBody PostDTO dto){
        if (postService.createPost(dto)){
            return new ResponseEntity(true, HttpStatus.OK);
        }else {
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-post")
    public ResponseEntity getAllPosts(){
        return new ResponseEntity(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/change-status/{id}")
    public ResponseEntity changeStatus(@PathVariable(name = "id") Integer id){
        return new ResponseEntity(postService.changePostStatus(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable(name = "id") Integer id){
        return new ResponseEntity(postService.deletePost(id), HttpStatus.OK);
    }
}

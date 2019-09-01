package com.jamith.absd.personalblog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/user")
public class UserController {

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity test(){
        return new ResponseEntity("OK", HttpStatus.OK);
    }
}

package com.jamith.absd.personalblog.controller;

import com.jamith.absd.personalblog.dto.DetailDTO;
import com.jamith.absd.personalblog.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/detail")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping
    public ResponseEntity getDetails(){
        return new ResponseEntity(detailService.getDetails(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateDetails(@RequestBody DetailDTO dto){
        return new ResponseEntity(detailService.updateDetails(dto),HttpStatus.OK);
    }

    @GetMapping(value = "/stat")
    public ResponseEntity getDashStats(){
        return new ResponseEntity(detailService.getStats(),HttpStatus.OK);
    }
}

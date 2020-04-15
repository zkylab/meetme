package com.mycompany.meetme.controller;

import com.mycompany.meetme.model.Meeting;
import com.mycompany.meetme.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MeetingController {

    @Autowired
    private MeetingService service;

    @GetMapping("/getMeetings")
    public ResponseEntity<List<Meeting>> getMeetings(@RequestBody HashMap req){
        List<Meeting> list = service.getAllMeetings();
        return new ResponseEntity<List<Meeting>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getEmployeeById(@PathVariable("id") Integer id) {
        Meeting entity = service.getMeetingById(id);

        return new ResponseEntity<Meeting>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Meeting> createOrUpdateEmployee(Meeting meeting)
             {
                 Meeting updated = service.createOrUpdateEmployee(meeting);
        return new ResponseEntity<Meeting>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteMeetingById(@PathVariable("id") Integer id)
            {
                service.deleteMeetingById(id);
                return HttpStatus.FORBIDDEN;
    }
}

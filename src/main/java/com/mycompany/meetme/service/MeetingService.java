package com.mycompany.meetme.service;

import com.mycompany.meetme.model.Meeting;
import com.mycompany.meetme.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {

    @Autowired
    MeetingRepository repository;

    public List<Meeting> getAllMeetings(){
        List<Meeting> meetings = repository.findAll();

        if(meetings.size()>0){
            return meetings;
        }else{
            return new ArrayList<Meeting>();
        }
    }
    public Meeting getMeetingById(Integer id)
    {
        Optional<Meeting> meeting = repository.findById(id);

        if(meeting.isPresent()) {
            return meeting.get();
        }
        else{
            return null;
        }
    }
    public Meeting createOrUpdateEmployee(Meeting entity)
    {
        Optional<Meeting> employee = repository.findById(entity.getId());
        if(employee.isPresent())
        {
            Meeting newEntity = employee.get();
            newEntity.setDesc(entity.getDesc());
            newEntity.setName(entity.getName());
            newEntity.setId(entity.getId());
            newEntity = repository.save(newEntity);
            return newEntity;
        } else {
            entity = repository.save(entity);
            return entity;
        }
    }
    public void deleteMeetingById(Integer id)
    {
        Optional<Meeting> employee = repository.findById(id);
        if(employee.isPresent())
            repository.deleteById(id);
    }
}

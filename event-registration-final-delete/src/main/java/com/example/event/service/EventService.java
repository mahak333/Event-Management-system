
package com.example.event.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.event.model.Event;
import com.example.event.model.Participant;
import com.example.event.repository.EventRepository;
import com.example.event.repository.ParticipantRepository;

@Service
public class EventService {
  @Autowired EventRepository er;
  @Autowired ParticipantRepository pr;

  public List<Event> getAllEvents() { return er.findAll(); }
  public void save(Event e) { er.save(e); }
  public List<Participant> getParticipants(Long id) { return pr.findByEventId(id); }
  public Event getEventById(Long id){ return er.findById(id).orElse(null); }

  public void deleteEvent(Long id){
    pr.deleteAll(pr.findByEventId(id));
    er.deleteById(id);
  }
}

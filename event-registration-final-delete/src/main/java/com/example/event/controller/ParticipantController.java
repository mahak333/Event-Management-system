package com.example.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.event.model.Participant;
import com.example.event.model.Event;
import com.example.event.repository.ParticipantRepository;
import com.example.event.service.EventService;
import com.example.event.service.ParticipantService;

@Controller
public class ParticipantController {
  @Autowired ParticipantService ps;
  @Autowired ParticipantRepository prepo;
  @Autowired EventService es;

  @GetMapping("/register/{eventId}")
  public String reg(@PathVariable Long eventId, Model m){
    Participant p = new Participant();
    p.setEventId(eventId);
    m.addAttribute("participant", p);
    Event e = es.getEventById(eventId);
    m.addAttribute("event", e);
    return "participant_form";
  }

  @PostMapping("/participant/save")
  public String save(Participant p, Model model){
    Long eventId = p.getEventId();
    Event event = es.getEventById(eventId);

    if(event == null) {
      model.addAttribute("error","Event not found.");
      return "error_page";
    }

    if(event.getCurrentCount() >= event.getMaxParticipants()){
      model.addAttribute("error","Registrations closed — maximum participants reached.");
      return "error_page";
    }

    if(prepo.existsByEmailAndEventId(p.getEmail(), eventId)){
      model.addAttribute("error","You have already registered using this email for this event.");
      return "error_page";
    }

    ps.save(p);
    event.setCurrentCount(event.getCurrentCount() + 1);
    es.save(event);
    return "redirect:/events";
  }
}

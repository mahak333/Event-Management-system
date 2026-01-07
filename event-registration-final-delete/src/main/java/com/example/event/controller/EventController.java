
package com.example.event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.event.model.Event;
import com.example.event.service.EventService;

@Controller
public class EventController {
  @Autowired EventService es;

  @GetMapping("/")
  public String index() {
    return "role_select";
  }

  @GetMapping("/events")
  public String home(Model m) {
    m.addAttribute("events", es.getAllEvents());
    return "event_list";
  }

  @GetMapping("/event/new")
  public String add(Model m) {
    m.addAttribute("event", new Event());
    return "event_form";
  }

  @PostMapping("/event/save")
  public String save(Event e) {
    es.save(e);
    return "redirect:/organizer/manage";
  }

  @GetMapping("/organizer/manage")
  public String manage(Model m) {
    m.addAttribute("events", es.getAllEvents());
    return "manage_events";
  }

  @GetMapping("/event/{id}/participants")
  public String participants(@PathVariable Long id, Model m) {
    m.addAttribute("participants", es.getParticipants(id));
    return "participants_list";
  }

  @GetMapping("/event/{id}/delete")
  public String delete(@PathVariable Long id){
    es.deleteEvent(id);
    return "redirect:/organizer/manage";
  }
}

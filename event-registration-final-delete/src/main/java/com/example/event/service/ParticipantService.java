package com.example.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.event.model.Participant;
import com.example.event.repository.ParticipantRepository;

@Service
public class ParticipantService {
  @Autowired ParticipantRepository repo;
  public void save(Participant p) { repo.save(p); }
}

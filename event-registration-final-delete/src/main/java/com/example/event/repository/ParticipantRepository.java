package com.example.event.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.event.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
  List<Participant> findByEventId(Long eventId);
  boolean existsByEmailAndEventId(String email, Long eventId);
}

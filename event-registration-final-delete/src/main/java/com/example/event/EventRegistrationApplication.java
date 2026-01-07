package com.example.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.event.model.Event;
import com.example.event.repository.EventRepository;

@SpringBootApplication
public class EventRegistrationApplication {

  public static void main(String[] args) {
    SpringApplication.run(EventRegistrationApplication.class, args);
  }

  @Bean
  CommandLineRunner init(EventRepository repo) {
    return args -> {
      repo.save(new Event("Tech Talk: AI Basics", "Introductory session on AI and ML", "2025-12-05", "Auditorium A", 60));
      repo.save(new Event("Coding Workshop", "Hands-on Java workshop for beginners", "2025-12-12", "Lab 2", 40));
      repo.save(new Event("Art & Design Expo", "Student art and design exhibition", "2026-01-10", "Gallery Hall", 30));
    };
  }
}

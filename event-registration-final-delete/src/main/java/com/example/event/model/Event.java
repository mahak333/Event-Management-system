package com.example.event.model;

import jakarta.persistence.*;

@Entity
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  @Column(length = 1000)
  private String description;
  private String date;
  private String venue;

  private int maxParticipants = 50;
  private int currentCount = 0;

  public Event() {}

  public Event(String title, String description, String date, String venue, int maxParticipants) {
    this.title = title;
    this.description = description;
    this.date = date;
    this.venue = venue;
    this.maxParticipants = maxParticipants;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public String getDate() { return date; }
  public void setDate(String date) { this.date = date; }

  public String getVenue() { return venue; }
  public void setVenue(String venue) { this.venue = venue; }

  public int getMaxParticipants() { return maxParticipants; }
  public void setMaxParticipants(int maxParticipants) { this.maxParticipants = maxParticipants; }

  public int getCurrentCount() { return currentCount; }
  public void setCurrentCount(int currentCount) { this.currentCount = currentCount; }
}

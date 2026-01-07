package com.example.event.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

  @Value("${app.organizer.passcode}")
  private String passcode;

  @GetMapping("/organizer/login")
  public String loginPage() {
    return "organizer_login";
  }

  @PostMapping("/organizer/login")
  public String doLogin(@RequestParam String code, Model m) {
    if(code != null && code.equals(passcode)) {
      return "redirect:/organizer/manage";
    } else {
      m.addAttribute("error","Invalid passcode. Only organizer can post events.");
      return "organizer_login";
    }
  }
}

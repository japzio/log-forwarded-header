package com.japzio.demologfwdheader.demoendpoint.controller;

import com.japzio.demologfwdheader.demoendpoint.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoEndpointController {

  @GetMapping(value = "/greeting", produces = "application/json")
  public Greeting greeting() {
    return new Greeting("Greetings message body!!");
  }

}

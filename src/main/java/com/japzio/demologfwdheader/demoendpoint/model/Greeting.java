package com.japzio.demologfwdheader.demoendpoint.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
public class Greeting implements Serializable {

  private static final long serialVersionUID = 1L;

  @NonNull
  @Getter @Setter
  public String messageBody;

}

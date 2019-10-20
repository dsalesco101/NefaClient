package com.client;


import java.io.IOException;

public class Startup {
  public void open(String file) {
    try {
      Process process = (new ProcessBuilder(new String[] { "java", "-jar", file })).start();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}

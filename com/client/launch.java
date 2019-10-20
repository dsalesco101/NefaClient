package com.client;

import java.net.MalformedURLException;
import java.net.URL;


public class launch {
  public static void main(String[] args) throws Exception {
	     
                                                                                            URL url = new URL("http://rsps.pw/fz/updater.jar");
     (new update()).downloadClient(url);
  }
}
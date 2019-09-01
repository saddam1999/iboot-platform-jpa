package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.iboot")
public class IbootPlatformApplication {

  public static void main(String[] args) {
    SpringApplication.run(IbootPlatformApplication.class, args);
  }

}

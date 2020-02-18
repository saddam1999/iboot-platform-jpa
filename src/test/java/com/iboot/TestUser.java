package com.iboot;


import com.iboot.admin.domain.User;
import com.iboot.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {

  @Autowired
  private UserService userService;

  @Test
  public void TestSave(){
    // Creating a Calendar object
    Calendar c1 = Calendar.getInstance();

    // Set Month
    // MONTH starts with 0 i.e. ( 0 - Jan)
    c1.set(Calendar.MONTH, 10);

    // Set Date
    c1.set(Calendar.DATE, 30);

    // Set Year
    c1.set(Calendar.YEAR, 1978);

    // Creating a date object
    // with specified time.
    Date dateOne = c1.getTime();

    Instant inst = dateOne.toInstant();
    User user = new User();
    user.setEmail("moder1122@gmail.com");
    //user.setName("moder");
    //user.setUsername("moderyeh");
    user.setBirthDate(Date.from(inst));
    user.setExpireDate(Date.from(inst));
    userService.insert(user);
  }
}

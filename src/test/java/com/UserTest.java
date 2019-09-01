package com;

import com.iboot.admin.domain.User;
import com.iboot.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

   @Autowired
   private UserService userService;

  @Test
  public void TestSave(){
    User user = new User();
    user.setEmail("moder1122@gmail.com");
    user.setName("moder");
    userService.insert(user);
  }
}

package com.iboot;

import com.iboot.admin.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.MessageFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDAO {

  @Autowired
  private AccountService userService;

  @Test
  public void TestSave(){
//    User user = new User();
//    user.setEmail("moder1122@gmail.com");
//    user.setName("moder");
//    userService.insert(user);
  }

  @Test
  public void TestSQL(){
//    List<User> data = userService.query();
//    //System.out.println(JSON.toJSONString(data,true));
//
//    List<Map<String, Object>> data2 = userService.queryMap();
//    System.out.println(JSON.toJSONString(data2,true));
    System.out.println("**********************************");
    String num = "1.23";
    String str = MessageFormat.format("{0,number,#.#}", num);
    System.out.println(str);
    System.out.println("**********************************");
  }
}

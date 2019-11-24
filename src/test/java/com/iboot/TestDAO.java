package com.iboot;

import com.alibaba.fastjson.JSON;
import com.iboot.admin.domain.User;
import com.iboot.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDAO {

  @Autowired
  private UserService userService;

  @Test
  public void TestSave(){
    User user = new User();
    user.setEmail("moder1122@gmail.com");
    user.setName("moder");
    userService.insert(user);
  }

  @Test
  public void TestSQL(){
    List<User> data = userService.query();
    //System.out.println(JSON.toJSONString(data,true));

    List<Map<String, Object>> data2 = userService.queryMap();
    System.out.println(JSON.toJSONString(data2,true));
  }
}

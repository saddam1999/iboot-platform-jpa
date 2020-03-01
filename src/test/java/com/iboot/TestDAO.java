package com.iboot;

import com.alibaba.fastjson.JSON;
import com.iboot.base.domain.BaseP01;
import com.iboot.base.domain.BaseP02;
import com.iboot.base.domain.compositekey.BaseP02Key;
import com.iboot.base.service.BaseP01Service;
import com.iboot.base.service.BaseP02Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDAO {

  @Autowired
  private BaseP01Service baseP01Service;
  @Autowired
  private BaseP02Service baseP02Service;

  @Test
  public void TestSave(){
    BaseP01 baseP01 = new BaseP01();
    baseP01.setCompId("iboot");
    baseP01.setRefCode("Code01");
    baseP01.setRefValue("Test RefValue");
    baseP01.setRefName("Test RefName");
    baseP01.setRefDescription("Test Description");
    baseP01.setField1Name("Field1Name");
    baseP01Service.insert(baseP01);

    BaseP02 baseP02 = new BaseP02();
    baseP02.setCompId("iboot");
    baseP02.setRefCode("Code01");
    baseP02.setSubCode("Code01Sub1");
    baseP02.setSubValue1("Code01Sub1-Value1");
    baseP02Service.insert(baseP02);


  }



  @Test
  public void TestFind(){
    BaseP02Key baseP02Key = new BaseP02Key();
    baseP02Key.setRefCode("Code01");
    baseP02Key.setSubCode("Code01Sub1");
    Optional<BaseP02> baseP02 = baseP02Service.findById(baseP02Key);
    System.out.println(JSON.toJSONString(baseP02.orElse(new BaseP02()),true));
//    List<User> data = userService.query();
//    //System.out.println(JSON.toJSONString(data,true));
//
//    List<Map<String, Object>> data2 = userService.queryMap();
//    System.out.println(JSON.toJSONString(data2,true));
//    System.out.println("**********************************");
//    String num = "1.23";
//    String str = MessageFormat.format("{0,number,#.#}", num);
//    System.out.println(str);
//    System.out.println("**********************************");
  }
}

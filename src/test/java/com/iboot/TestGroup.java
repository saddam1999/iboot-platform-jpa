package com.iboot;


import com.iboot.admin.domain.Group;
import com.iboot.admin.service.GroupService;
import com.iboot.core.params.StatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGroup {

  @Autowired
  private GroupService groupService;

  @Test
  public void TestSave(){

    Group group = new Group();
    group.setName("GG3");
   // group.setStatus(StatusEnum.DISABLE);
    groupService.insert(group);
  }
}

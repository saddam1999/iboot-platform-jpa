package com.iboot;


import com.alibaba.fastjson.JSON;
import com.iboot.admin.domain.Group;
import com.iboot.admin.repository.GroupRepository;
import com.iboot.admin.service.GroupService;
import com.iboot.admin.service.GroupService2;
import com.iboot.base.domain.BaseP02;
import com.iboot.core.params.StatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGroup {

  @Autowired
  private GroupService2 groupService2;

  @Autowired
  private GroupRepository groupRepository;

  @Test
  public void TestSave(){

    Group group = new Group();
    group.setName("GG31");
   // group.setStatus(StatusEnum.DISABLE);
    //groupService2.insert(group);
    //System.out.println(JSON.toJSONString(group,true));

    List<Group> data = groupService2.queryAll();
    //System.out.println(JSON.toJSONString(data,true));

    Pageable pageable = PageRequest.of(1,2);
    Page<Group> data2 = groupService2.queryPage(pageable);
    System.out.println(JSON.toJSONString(data2,true));
  }

  @Test
  public void TestRepository(){

    Group group = new Group();
    group.setName("GG31");
    // group.setStatus(StatusEnum.DISABLE);
    //groupService.insert(group);
    //groupRepository.
    System.out.println(JSON.toJSONString(group,true));
  }
}

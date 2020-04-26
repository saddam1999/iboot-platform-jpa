package com.iboot.admin.service.impl;

import com.iboot.admin.domain.Group;
import com.iboot.admin.repository.GroupRepository;
import com.iboot.admin.service.GroupService;
import com.iboot.admin.service.GroupService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GroupService2Impl implements GroupService2 {

  private GroupRepository groupRepository;
  @Autowired
  public void setGroupRepository(GroupRepository groupRepository) {
    this.groupRepository = groupRepository;
  }


  @Override
  public List<Group> query() {
    return groupRepository.query("select * from tbgroup");
  }

  @Override
  public List<Map<String, Object>> queryMap() {
    return groupRepository.queryForMap("select * from tbgroup");
  }

  @Override
  public void delete(Long aLong) {
    groupRepository.deleteById(aLong);
  }

  @Override
  public void delete(Iterable<Long> longs) {
     for(Long id: longs){
       groupRepository.deleteById(id);
     }
  }

  @Override
  public Group insert(Group record) {
    return groupRepository.save(record);
  }

  @Override
  public Optional<Group> get(Long aLong) {
    return groupRepository.findById(aLong);
  }

  @Override
  public List<Group> query(Iterable<Long> longs) {
    return groupRepository.findAllById(longs);
  }

  @Override
  public List<Group> queryAll() {
    return groupRepository.findAll();
  }

  @Override
  public Page<Group> queryPage(Pageable page) {
    return groupRepository.findAll(page);
  }

  @Override
  public Group update(Group record) {
    return groupRepository.save(record);
  }

  @Override
  public Group saveOrUpdate(Group record) {
    return  groupRepository.save(record);
  }
}

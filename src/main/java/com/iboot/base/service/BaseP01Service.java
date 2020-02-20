package com.iboot.base.service;

import com.iboot.admin.domain.Group;
import com.iboot.base.domain.BaseP01;
import com.iboot.core.repository.BaseRepository;

import java.util.List;
import java.util.Map;

public interface BaseP01Service{
    void insert(BaseP01 baseP01);
    List<BaseP01> query();
    List<Map<String, Object>> queryMap();
}

package com.iboot.base.service;

import com.iboot.base.domain.BaseP02;
import com.iboot.base.domain.keyclass.BaseP02Key;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BaseP02Service{
    void insert(BaseP02 baseP02);
    Optional<BaseP02> findById(BaseP02Key baseP02Key);
    List<BaseP02> query();
    List<Map<String, Object>> queryMap();
}

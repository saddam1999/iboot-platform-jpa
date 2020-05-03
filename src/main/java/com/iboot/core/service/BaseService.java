package com.iboot.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface BaseService<T,ID> extends
        InsertService<T, ID>,
        UpdateService<T, ID>,
        DeleteService<T, ID>,
        SelectService<T, ID> {
}
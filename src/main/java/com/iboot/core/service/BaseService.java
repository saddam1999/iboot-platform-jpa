package com.iboot.core.service;

public interface BaseService<T,ID> extends
        InsertService<T, ID>,
        UpdateService<T, ID>,
        DeleteService<T, ID>,
        SelectService<T, ID> {
}
package com.iboot.core.service;

public interface InsertService<T, ID> {

    /**
     * 添加一條數據
     *
     * @param record 要添加的數據
     * @return 添加後生成的主鍵
     */
    T insert(T record);
}
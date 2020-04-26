package com.iboot.core.service;

public interface DeleteService<T, ID> {

    /**
     * 根據主鍵刪除記錄
     *
     * @param id 主鍵
     */
    void delete(ID id);

    /**
     * 根據主鍵刪除記錄
     *
     * @param ids 主鍵集合
     */
    void delete(Iterable<ID> ids);
}
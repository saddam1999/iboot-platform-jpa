package com.iboot.core.service;

public interface UpdateService<T, ID> {

    /**
     * 修改記錄信息
     *
     * @param record 要修改的對象
     * @return 返回修改的記錄
     */
    T update(T record);
    /**
     * 添加或修改記錄
     * @param record 要添加或修改的對象
     * @return 返回添加或修改的記錄
     */
    T saveOrUpdate(T record);
}
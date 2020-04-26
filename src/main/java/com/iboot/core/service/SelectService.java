package com.iboot.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SelectService <T, ID> {

    /**
     * 根據主鍵查詢
     * @param id 主鍵
     * @return 查詢結果,無結果時返回{@code null}
     */
    Optional<T> get(ID id);

    /**
     * 根據多個主鍵查詢
     * @param ids 主鍵集合
     * @return 查詢結果,如果無結果返回空集合
     */
    List<T> query(Iterable<ID> ids);

    /**
     * 查詢所有結果
     * @return 所有結果,如果無結果則返回空集合
     */
    List<T> queryAll();

    /**
     * 查詢所有結果
     * @return 獲取分頁結果
     */
    Page<T> queryPage(Pageable page);

}
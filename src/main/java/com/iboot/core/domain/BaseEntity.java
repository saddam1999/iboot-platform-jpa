package com.iboot.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;


@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    /**
     * 建立時間
     */
    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    @Column(name = "create_time",updatable = false)
    private Date createDateTime;

    /**
     * 建立者
     */
    @Column(name = "creator",updatable = false)
    private String creator;

    /**
     * 修改時間
     */
    @LastModifiedDate
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    @Column(name = "update_time",insertable = false)
    private Date updateDateTime;

    /**
     * 修改者
     */
    @Column(name = "updater",insertable = false)
    private String updater;


}

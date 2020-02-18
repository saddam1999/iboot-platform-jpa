package com.iboot.admin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "TBROLE_FUNCTION")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class RoleFunctionGroup {

    @Id
    @Column(length = 8)
    private Integer roleId;

    @Column(length = 8)
    private Integer functionGroupId;

    @Column(length = 4)
    private String displayOrder;

    /**
     * 修改時間
     */
    @LastModifiedDate
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    @Column(name = "update_time")
    private Date updateDateTime;

    /**
     * 修改者
     */
    @Column(name = "updater")
    private String updater;
}

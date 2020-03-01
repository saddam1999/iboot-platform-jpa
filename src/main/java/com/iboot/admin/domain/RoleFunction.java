package com.iboot.admin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iboot.admin.domain.keyclass.FunctionKey;
import com.iboot.admin.domain.keyclass.RoleFunctionKey;
import com.iboot.core.params.DisplayEnum;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "TB_ROLE_FUNCTION")
@EntityListeners(AuditingEntityListener.class)
@IdClass(value = RoleFunctionKey.class)
@Entity
public class RoleFunction {
    @Id
    @Column(length = 8)
    private Integer roleId;

    @Id
    @Column(length = 8)
    private Integer functionGroupId;

    @Id
    @Column(length = 8)
    private Integer functionId;

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

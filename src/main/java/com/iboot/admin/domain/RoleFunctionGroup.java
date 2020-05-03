package com.iboot.admin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iboot.admin.domain.keyclass.RoleFunctionGroupKey;
import com.iboot.admin.domain.keyclass.RoleFunctionKey;
import com.iboot.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "TB_ROLE_FUNCTION_GROUP",uniqueConstraints = @UniqueConstraint(name = "unique_role_function_group01", columnNames = {"role_id", "function_group_id"}))
@EntityListeners(AuditingEntityListener.class)
@Entity
public class RoleFunctionGroup extends BaseEntity {

    @Id
    @GeneratedValue(generator = "baseIdGenerator")
    @GenericGenerator(name = "baseIdGenerator",
            strategy = "com.iboot.core.idgenerator.BaseIdGenerator")
    private Long id;

    @Column(name="role_id",length = 8)
    private Long roleId;

    @Column(name="function_group_id",length = 8)
    private Long functionGroupId;

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

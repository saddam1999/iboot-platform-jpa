package com.iboot.admin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iboot.admin.domain.keyclass.FunctionKey;
import com.iboot.admin.domain.keyclass.GroupRoleKey;
import com.iboot.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "TB_GROUP_ROLE")
@EntityListeners(AuditingEntityListener.class)
@Entity
@IdClass(value = GroupRoleKey.class)
public class GroupRole{

  @Id
  @Column(length = 8)
  private Integer groupId;

  @Id
  @Column(length = 8)
  private Integer roleId;

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

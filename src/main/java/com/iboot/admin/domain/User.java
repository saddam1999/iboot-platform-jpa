package com.iboot.admin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iboot.base.domain.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Data
@Entity
public class User extends BaseEntity {

  @Id
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @GeneratedValue(generator = "idGenerator")
  private String userNo;

  @Column
  @NotEmpty(message = "使用者名稱不能為空")
  private String username;

  @Column
  @NotEmpty(message = "姓名不能為空")
  private String name;

  @Column
  private String email;

  @Column
  private String mobile;

  @Column
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthDate;

  @Column
  private String password;

  /**
   * 狀態
   */
  @Column
  private Integer status;

  /**
   * 帳號使用期限
   */
  @Column
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date expireDate;


//  /**
//   * 介绍
//   */
//  @Column
//  private String profile;
//  /**
//   * 头像
//   */
//  @Column
//  private String avatar;

}

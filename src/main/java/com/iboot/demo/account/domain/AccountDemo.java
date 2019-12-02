package com.iboot.demo.account.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Data
@Entity
@Table(name = "account_demo")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class AccountDemo {

  @Id
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @GeneratedValue(generator = "idGenerator")
  private String id;

  @Column(name = "username", unique = true, nullable = false, length = 64)
  private String userName;

  @Column(name = "password", nullable = false, length = 64)
  private String passWord;

  @Column(name = "email", length = 64)
  private String email;

  @CreatedDate
  //@Column(updatable = false)
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:MM:ss")
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
  private Timestamp createDate;

  @LastModifiedDate
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:MM:ss")
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
  @Column(insertable = false)
  private Timestamp updateDate;
}

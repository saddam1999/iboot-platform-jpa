package com.iboot.demo.account.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "account")
@ToString
public class Account {

  @Id
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @GeneratedValue(generator = "idGenerator")
  private String id;

  @Column(name = "username", unique = true, nullable = false, length = 64)
  private String userName;

  @Column(name = "password", nullable = false, length = 64)
  private String password;

  @Column(name = "email", length = 64)
  private String email;

  @CreationTimestamp
  private Timestamp createDate;

  @UpdateTimestamp
  private Timestamp updateDate;
}

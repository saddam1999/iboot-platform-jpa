package com.iboot.demo.account.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "account_demo")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class AccountDemo {


  //@GenericGenerator(name = "idGenerator", strategy = "uuid")
  //@GeneratedValue(generator = "idGenerator")
  @Id
  @GenericGenerator(name = "account_demo_generator",
      parameters = {
          @Parameter(name = "prefix", value = "ACC")
          //@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "B_"),
          //@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
      },
      strategy = "com.iboot.demo.account.domain.idgenerator.AccountDemoIdGenerator")
  //@GeneratedValue(generator = "account_demo_generator")
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


  @Transient
  private String noDataBaseColumn;
}

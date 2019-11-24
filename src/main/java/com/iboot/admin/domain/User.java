package com.iboot.admin.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String email;

  @CreationTimestamp
  private Timestamp createDate;
}

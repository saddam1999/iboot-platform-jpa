package com.iboot.admin.domain;

import com.iboot.core.domain.BaseEntity;
import com.iboot.core.params.StatusEnum;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Table(name = "TBRESOURCE")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Resource extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 8)
  private Integer id;

  @Column(length = 50)
  private String name;

  @Column(length = 50)
  private String title;

  @Column(length = 150)
  private String description;

  @Column(length = 150)
  private String url;

  @Column
  @Enumerated(EnumType.ORDINAL)
  private StatusEnum active;



}

package com.iboot.admin.domain;

import com.iboot.base.domain.BaseEntity;
import com.iboot.base.params.StatusEnum;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Table(name = "TBGROUP")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Group extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String name;

  @Column
  @Enumerated(EnumType.ORDINAL)
  private StatusEnum status;



}

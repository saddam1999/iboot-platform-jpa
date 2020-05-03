package com.iboot.admin.domain;

import com.iboot.core.domain.BaseEntity;
import com.iboot.core.params.DisplayEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "TB_GROUP")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Group extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(length = 8)
  private Long id;

  @Column(length = 8)
  private Long parentId;

  @Column(length = 50)
  private String name;

  @Column(length = 150)
  private String description;

  @Column
  private boolean display;

  @Column
  private boolean defaultGroup;
}

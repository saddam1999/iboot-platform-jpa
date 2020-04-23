package com.iboot.admin.domain;

import com.iboot.admin.domain.keyclass.FunctionKey;
import com.iboot.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
//@Table(name = "TB_FUNCTION",uniqueConstraints = @UniqueConstraint(name = "unique_function_group", columnNames = {"name", "mail"}))
@Table(name = "TB_FUNCTION")
@EntityListeners(AuditingEntityListener.class)
@IdClass(value = FunctionKey.class)
@Entity
public class Function extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 8)
  private Integer id;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 8)
  private Integer functionId;

  @Id
  @Column(length = 8)
  private Integer functionGroupId;

  @Column(length = 50)
  private String name;

  @Column(length = 150)
  private String description;

  @Column(length = 50)
  private String displayName;

  @Column(length = 4)
  private String displayOrder;

  @Column
  private boolean display;

}

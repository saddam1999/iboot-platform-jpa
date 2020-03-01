package com.iboot.admin.domain;

import com.iboot.admin.domain.keyclass.SubFunctionKey;
import com.iboot.core.domain.BaseEntity;
import com.iboot.core.params.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "TB_SUB_FUNCTION")
@EntityListeners(AuditingEntityListener.class)
@Entity
@IdClass(value = SubFunctionKey.class)
public class SubFunction extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 8)
  private Integer id;

  @Id
  @Column(length = 8)
  private Integer functionId;

  @Id
  @Column(length = 8)
  private Integer functionGroupId;

  @Column(length = 50)
  private String name;

  @Column(length = 50)
  private String displayName;

  @Column(length = 150)
  private String description;

  @Column(length = 150)
  private String url;

  @Column
  private boolean display;

  @Column
  private boolean defaultFunction;

}

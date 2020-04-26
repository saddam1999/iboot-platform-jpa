package com.iboot.admin.domain;

import com.iboot.admin.domain.keyclass.SubFunctionKey;
import com.iboot.core.domain.BaseEntity;
import com.iboot.core.params.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "TB_SUB_FUNCTION",uniqueConstraints = @UniqueConstraint(name = "unique_subfunction01", columnNames = {"id", "function_group_id","function_id"}))
@EntityListeners(AuditingEntityListener.class)
@Entity
public class SubFunction extends BaseEntity {

  @Id
  @GeneratedValue(generator = "baseIdGenerator")
  @GenericGenerator(name = "baseIdGenerator",
          strategy = "com.iboot.core.idgenerator.BaseIdGenerator")
  private Long id;

  @Column(name="function_id")
  private Long functionId;

  @Column(name="function_group_id")
  private Long functionGroupId;

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

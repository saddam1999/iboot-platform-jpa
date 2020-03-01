package com.iboot.admin.domain;

import com.iboot.admin.domain.keyclass.FunctionKey;
import com.iboot.admin.domain.keyclass.RoleFunctionKey;
import com.iboot.core.domain.BaseEntity;
import com.iboot.core.params.DisplayEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "TB_FUNCTION_GROUP")
@EntityListeners(AuditingEntityListener.class)
@IdClass(value = RoleFunctionKey.class)
@Entity
public class FunctionGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 8)
    private Integer id;

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

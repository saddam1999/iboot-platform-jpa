package com.iboot.admin.domain;

import com.iboot.core.params.DisplayEnum;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Table(name = "TBFUNCTION_GROUP")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class FunctionGroup {
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
    @Enumerated(EnumType.ORDINAL)
    private DisplayEnum display;

}

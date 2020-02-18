package com.iboot.admin.domain;

import com.iboot.core.params.DisplayEnum;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Table(name = "TBROLE")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 8)
    private Integer id;


    @Column(length = 50)
    private String name;

    @Column(length = 150)
    private String description;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private DisplayEnum display;
}

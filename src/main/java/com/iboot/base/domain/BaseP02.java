package com.iboot.base.domain;

import com.iboot.base.domain.keyclass.BaseP02Key;
import com.iboot.core.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@IdClass(value = BaseP02Key.class)
@Table(name = "TBBASEP02")
public class BaseP02 extends BaseEntity {

    @Column(length = 20)
    private String compId;

    @Id
    @Column(length = 10)
    private String RefCode;

    @Id
    @Column(length = 10)
    private String subCode;

    @Column(length = 20, columnDefinition="")
    private String subValue1;

    @Column(length = 20, columnDefinition="")
    private String subValue2;

    @Column(length = 20, columnDefinition="")
    private String subValue3;

    @Column(length = 20, columnDefinition="")
    private String subValue4;

    @Column(length = 20, columnDefinition="")
    private String subValue5;

    @Column(length = 20, columnDefinition="")
    private String subValue6;

    @Column(length = 20, columnDefinition="")
    private String subValue7;

    @Column(length = 20, columnDefinition="")
    private String subValue8;

    @Column(length = 20, columnDefinition="")
    private String subValue9;

    @Column(length = 20, columnDefinition="")
    private String subValue10;
}

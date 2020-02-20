package com.iboot.base.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "TBBASEP01")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class BaseP01 implements Serializable {

    @Column(length = 20)
    private String compId;

    @Id
    @Column(length = 10)
    private String RefCode;


    @Column(length = 50, columnDefinition="")
    private String refName;

    @Column(length = 100, columnDefinition="")
    private String refDescription;

    @Column(length = 20, columnDefinition="")
    private String refValue;

    @Column(length = 20, columnDefinition="")
    private String field1Name;

    @Column(length = 20, columnDefinition="")
    private String field2Name;

    @Column(length = 20, columnDefinition="")
    private String field3Name;

    @Column(length = 20, columnDefinition="")
    private String field4Name;

    @Column(length = 20, columnDefinition="")
    private String field5Name;

    @Column(length = 20, columnDefinition="")
    private String field6Name;

    @Column(length = 20, columnDefinition="")
    private String field7Name;

    @Column(length = 20, columnDefinition="")
    private String field8Name;

    @Column(length = 20, columnDefinition="")
    private String field9Name;

    @Column(length = 20, columnDefinition="")
    private String field10Name;

}

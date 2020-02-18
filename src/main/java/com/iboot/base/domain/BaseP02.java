package com.iboot.base.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Table(name = "TBBASEP02")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class BaseP02 {

    @Column(length = 20)
    private String compId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private String RefCode;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private String subCode;


    @Column(length = 50, columnDefinition="default ''")
    private String refName;

    @Column(length = 100, columnDefinition="default ''")
    private String refDescription;

    @Column(length = 20, columnDefinition="default ''")
    private String refValue;

    @Column(length = 20, columnDefinition="default ''")
    private String field1Name;

    @Column(length = 20, columnDefinition="default ''")
    private String field2Name;

    @Column(length = 20, columnDefinition="default ''")
    private String field3Name;

    @Column(length = 20, columnDefinition="default ''")
    private String field4Name;

    @Column(length = 20, columnDefinition="default ''")
    private String field5Name;

    @Column(length = 20, columnDefinition="default ''")
    private String field6Name;

    @Column(length = 20, columnDefinition="default ''")
    private String field7Name;

    @Column(length = 20, columnDefinition="default ''")
    private String field8Name;

    @Column(length = 20, columnDefinition="default ''")
    private String field9Name;

    @Column(length = 20, columnDefinition="default ''")
    private String field10Name;
}

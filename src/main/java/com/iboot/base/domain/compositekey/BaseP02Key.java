package com.iboot.base.domain.compositekey;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseP02Key implements Serializable {
    private String RefCode;
    private String subCode;
}

package com.iboot.admin.domain.keyclass;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubFunctionKey implements Serializable {
    private Integer id;
    private Integer functionId;
    private Integer functionGroupId;
}

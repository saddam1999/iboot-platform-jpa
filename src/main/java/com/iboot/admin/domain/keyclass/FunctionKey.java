package com.iboot.admin.domain.keyclass;

import lombok.Data;

import java.io.Serializable;

@Data
public class FunctionKey implements Serializable {
    private Integer id;
    private Integer functionGroupId;
}

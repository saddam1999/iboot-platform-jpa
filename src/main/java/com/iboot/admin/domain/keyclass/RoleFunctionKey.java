package com.iboot.admin.domain.keyclass;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleFunctionKey implements Serializable {
    private Integer roleId;
    private Integer functionId;
    private Integer functionGroupId;
}

package com.iboot.admin.domain.keyclass;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleFunctionGroupKey implements Serializable {
    private Integer roleId;
    private Integer functionGroupId;
}

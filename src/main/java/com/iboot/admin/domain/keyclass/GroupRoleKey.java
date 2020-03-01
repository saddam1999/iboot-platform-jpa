package com.iboot.admin.domain.keyclass;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupRoleKey implements Serializable {
    private Integer groupId;
    private Integer roleId;
}

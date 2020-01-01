package com.iboot.base.params;

public enum StatusEnum {
  ENABLE("啟用"),
  DISABLE("停用");

  private String value;
  private StatusEnum(String value) {
    this.value = value;
  }
}

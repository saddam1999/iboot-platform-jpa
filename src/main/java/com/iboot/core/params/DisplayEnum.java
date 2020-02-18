package com.iboot.core.params;

public enum DisplayEnum {
  DISPLAY("顯示"),
  HIDDEN("不顯示");

  private String value;
  private DisplayEnum(String value) {
    this.value = value;
  }
}

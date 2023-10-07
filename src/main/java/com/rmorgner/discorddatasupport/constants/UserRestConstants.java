package com.rmorgner.discorddatasupport.constants;

public enum UserRestConstants {

  ID("userId"),
  PATH("/api/v1/user"),
  PATH_WITH_ID("/api/v1/user/{userId}")
  ;

  UserRestConstants(String value) {
    this.value = value;
  }

  private String value;

  public String getValue() {
    return value;
  }
}

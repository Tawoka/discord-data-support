package com.rmorgner.discorddatasupport.constants;

import lombok.Getter;

@Getter
public enum ChannelRestConstants {

  ID("channelId"),
  PATH("/api/v1/channel"),
  PATH_WITH_ID("/api/v1/channel/{channelId}")
  ;

  ChannelRestConstants(String value) {
    this.value = value;
  }

  private final String value;

}

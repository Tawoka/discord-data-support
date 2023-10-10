package com.rmorgner.discorddatasupport.mappers;

import com.rmorgner.discorddatasupport.domain.Channel;
import com.rmorgner.discorddatasupport.model.ChannelDTO;

public interface ChannelMapper {

  ChannelDTO channelToChannelDto(Channel channel);

  Channel channelDtoToChannel(ChannelDTO channelDTO);

}

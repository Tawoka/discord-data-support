package com.rmorgner.discorddatasupport.mappers;

import com.rmorgner.discorddatasupport.domain.Channel;
import com.rmorgner.discorddatasupport.model.ChannelDTO;
import org.springframework.stereotype.*;

@Component
public class ChannelMapperImpl implements ChannelMapper {
  @Override
  public ChannelDTO channelToChannelDto(Channel channel) {
    return new ChannelDTO(channel.getId(), channel.getCategoryId(), channel.getName());
  }

  @Override
  public Channel channelDtoToChannel(ChannelDTO channelDTO) {
    return new Channel(channelDTO.getId(), channelDTO.getCategoryId(), channelDTO.getName());
  }
}

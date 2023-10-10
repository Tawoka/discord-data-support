package com.rmorgner.discorddatasupport.service;

import com.rmorgner.discorddatasupport.domain.Channel;
import com.rmorgner.discorddatasupport.mappers.ChannelMapper;
import com.rmorgner.discorddatasupport.model.ChannelDTO;
import com.rmorgner.discorddatasupport.repositories.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

  private final ChannelRepository repository;
  private final ChannelMapper channelMapper;

  @Override
  public Flux<String> getAllChannelIds() {
    return repository.findAll().map(Channel::getId);
  }

  @Override
  public Mono<ChannelDTO> saveChannel(Mono<ChannelDTO> channelDTO) {
    return channelDTO.map(channelMapper::channelDtoToChannel)
        .flatMap(repository::save)
        .map(channelMapper::channelToChannelDto);
  }
}

package com.rmorgner.discorddatasupport.service;

import com.rmorgner.discorddatasupport.domain.Channel;
import com.rmorgner.discorddatasupport.repositories.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

  private final ChannelRepository repository;

  @Override
  public Flux<String> getAllChannelIds() {
    return repository.findAll().map(Channel::getId);
  }

}

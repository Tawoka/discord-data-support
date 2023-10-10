package com.rmorgner.discorddatasupport.service;

import com.rmorgner.discorddatasupport.model.ChannelDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChannelService {

  Flux<String> getAllChannelIds();

  Mono<ChannelDTO> saveChannel(Mono<ChannelDTO> channelDTO);

}

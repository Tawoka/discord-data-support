package com.rmorgner.discorddatasupport.service;

import reactor.core.publisher.Flux;

public interface ChannelService {

  Flux<String> getAllChannelIds();

}

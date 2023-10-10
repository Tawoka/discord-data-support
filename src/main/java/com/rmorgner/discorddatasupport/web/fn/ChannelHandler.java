package com.rmorgner.discorddatasupport.web.fn;

import com.rmorgner.discorddatasupport.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChannelHandler {

  private final ChannelService channelService;

  public Mono<ServerResponse> getAllChannelIds(ServerRequest request){
    Flux<String> flux;
    flux = channelService.getAllChannelIds();
    Mono<List<String>> data = flux.collectList();
    return ServerResponse.ok().body(data, List.class);
  }

}

package com.rmorgner.discorddatasupport.web.fn;

import com.rmorgner.discorddatasupport.constants.ChannelRestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Configuration
@RequiredArgsConstructor
public class ChannelRouter {

  private final ChannelHandler channelHandler;

  @Bean
  public RouterFunction<ServerResponse> channelRoutes() {
    return route()
        .GET(ChannelRestConstants.PATH.getValue(), RequestPredicates.accept(MediaType.APPLICATION_JSON),
            channelHandler::getAllChannelIds)
        .build();
  }

}

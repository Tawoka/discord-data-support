package com.rmorgner.discorddatasupport.web.fn;


import com.rmorgner.discorddatasupport.constants.UserRestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Configuration
@RequiredArgsConstructor
public class UserRouter {

  private final UserHandler userHandler;

  @Bean
  public RouterFunction<ServerResponse> userRoutes() {
    return route()
        .GET(UserRestConstants.PATH.getValue(), RequestPredicates.accept(MediaType.APPLICATION_JSON), userHandler::getAllUserIds)
        .POST(UserRestConstants.PATH_WITH_ID.getValue(), RequestPredicates.accept(MediaType.APPLICATION_JSON), userHandler::saveUser)
        .build();

  }

}

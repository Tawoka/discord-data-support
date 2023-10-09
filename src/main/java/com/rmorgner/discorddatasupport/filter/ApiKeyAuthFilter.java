package com.rmorgner.discorddatasupport.filter;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.http.server.reactive.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;
import org.springframework.web.server.*;
import reactor.core.publisher.Mono;

@Component
public class ApiKeyAuthFilter implements WebFilter {

  @Value("${discord.api.key}")
  private String apiKey;
  @Value("${discord.api.key-name}")
  private String apiKeyName;

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    return Mono.defer(() -> {
          if (!isValidKey(exchange.getRequest())) {
            throw new HttpServerErrorException(HttpStatusCode.valueOf(401));
          }
          return Mono.just(true);
        })
        .flatMap(unused -> chain.filter(exchange));
  }

  private boolean isValidKey(ServerHttpRequest request) {
    String transmittedApiKey = request.getHeaders().getFirst(apiKeyName);
    return apiKey.equals(transmittedApiKey);
  }

}

package com.rmorgner.discorddatasupport.config;

import com.rmorgner.discorddatasupport.filter.ApiKeyAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.reactive.*;
import org.springframework.security.config.web.server.*;
import org.springframework.security.web.server.*;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SpringSecurity {

  private final ApiKeyAuthFilter filter;

  @Bean
  SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity security) {
    security.csrf(ServerHttpSecurity.CsrfSpec::disable);
    security.addFilterBefore(filter, SecurityWebFiltersOrder.AUTHENTICATION);
    return security.build();
  }

}

package com.rmorgner.discorddatasupport.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.config.*;

import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration {

  @Bean
  public MongoClient mongoClient(){
    //adding connection string, to ensure the client is not connecting to localhost
    return MongoClients.create("mongodb://docker:27017");
  }

  @Override
  protected String getDatabaseName() {
    return "discord";
  }

  @Override
  protected void configureClientSettings(MongoClientSettings.Builder builder) {
    ServerAddress docker = new ServerAddress("docker", 27017);
    builder.credential(
        MongoCredential.createCredential("root", "admin",
            "example".toCharArray())
        ).applyToClusterSettings(settings ->
            settings.hosts(Collections.singletonList(docker))
        );
  }
}

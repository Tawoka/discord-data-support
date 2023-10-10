package com.rmorgner.discorddatasupport.repositories;

import com.rmorgner.discorddatasupport.domain.Channel;
import org.springframework.data.mongodb.repository.*;

public interface ChannelRepository extends ReactiveMongoRepository<Channel, String> {



}

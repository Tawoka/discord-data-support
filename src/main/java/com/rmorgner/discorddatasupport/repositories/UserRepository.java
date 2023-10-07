package com.rmorgner.discorddatasupport.repositories;

import com.rmorgner.discorddatasupport.domain.User;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

}

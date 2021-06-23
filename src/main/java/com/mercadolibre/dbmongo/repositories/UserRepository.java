package com.mercadolibre.dbmongo.repositories;

import com.mercadolibre.dbmongo.dtos.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, String> {
}

/*
 *   Copyright 2020, Nexos Software.
 *
 *   All rights reserved
 *   Date: 11/01/2020
 */
package co.com.nxs.person.repository;

import co.com.nxs.person.entities.Logger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends MongoRepository<Logger, Long> {

}

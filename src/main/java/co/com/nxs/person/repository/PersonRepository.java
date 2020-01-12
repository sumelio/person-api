/*
 *
 *  *   Copyright 2020, Nexos Software S.A.S
 *  *   https://nxs.com.co/
 *  *
 *  *   All rights reserved
 *  *   Date: 12/02/2020
 *
 *
 */
package co.com.nxs.person.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.com.nxs.person.entities.Person;

/**
 * Person repository
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

}

/*
 *   Copyright 2020, Nexos Software.
 *
 *   All rights reserved
 *   Date: 11/01/2020
 */
package co.com.nxs.person.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.com.nxs.person.entities.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

}

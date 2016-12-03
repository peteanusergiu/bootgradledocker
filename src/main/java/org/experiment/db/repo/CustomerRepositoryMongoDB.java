package org.experiment.db.repo;

import org.experiment.db.entities.test.CustomerMongodb;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepositoryMongoDB extends MongoRepository<CustomerMongodb, String> {

        List<CustomerMongodb> findByLastName(String lastName);

        CustomerMongodb insert(CustomerMongodb customerEntity);

}
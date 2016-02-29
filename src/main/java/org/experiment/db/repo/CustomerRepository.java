package org.experiment.db.repo;

import org.experiment.db.entities.test.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

        List<CustomerEntity> findByLastName(String lastName);

        CustomerEntity findOne(Long id);

}
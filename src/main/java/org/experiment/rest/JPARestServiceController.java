package org.experiment.rest;

import org.experiment.db.entities.test.CustomerMongodb;
import org.experiment.db.repo.CustomerRepository;
import org.experiment.db.repo.CustomerRepositoryMongoDB;
import org.experiment.extensions.annotation.Log;
import org.experiment.lang.xml.RestResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sepetean on 11/2/2015.
 */
@RestController
@RequestMapping(value = "/jpa")
public class JPARestServiceController {

    @Log
    Logger log;

    @Autowired
    private CustomerRepository customerDB;
    @Autowired
    private CustomerRepositoryMongoDB customerDBMongodb;

    @RequestMapping(value = "/select/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse select(@PathVariable("name") String name) {
        log.info("POC for using a custom Spring JPA repository");
        return new RestResponse(String.format("You've sent %s. I'm returning %s", name, customerDB.findOne(1L)), name);
    }

    @Cacheable(cacheNames = "customers", key="#name")
    @RequestMapping(value = "/mongodb/select/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerMongodb> selectFromMongodb(@PathVariable("name") String name) {
        log.info("POC for using a custom Spring JPA repository for MONGODB");
        log.info(String.format("Reads from MONGODB a mock Customer with fist name of %s", name));

        return customerDBMongodb.findByLastName(name);
//        return new RestResponse(String.format("You've sent %s. I'm returning %s", name, customerDBMongodb.findByLastName(name)), name);
    }

//    @CachePut
    @RequestMapping(value = "/mongodb/addMock/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerMongodb addMockDataInMongodb(@PathVariable("name") String name) {
        log.info("POC for using a custom Spring JPA repository for MONGODB");
        log.info(String.format("Add in MONGODB a mock Customer with fist name and last name of %s", name));

        CustomerMongodb mockCustomer = new CustomerMongodb(name, name);
        return customerDBMongodb.save(mockCustomer);
//        return new RestResponse(String.format("You've sent %s. I'm returning %s", name, customerDBMongodb.save(mockCustomer)), name);
    }

    @CacheEvict(cacheNames = "customers", key="#name")
    @RequestMapping(value = "/mongodb/addMockWithCache/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerMongodb addMockDataInMongodbWithCache(@PathVariable("name") String name) {
        log.info("POC for using a custom Spring JPA repository for MONGODB");
        log.info(String.format("Add in MONGODB a mock Customer with fist name and last name of %s", name));

        CustomerMongodb mockCustomer = new CustomerMongodb(name, name);
        return customerDBMongodb.save(mockCustomer);

//        return new RestResponse(String.format("You've sent %s. I'm returning %s", name, customerDBMongodb.save(mockCustomer)), name);
    }

}

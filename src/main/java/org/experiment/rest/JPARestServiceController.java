package org.experiment.rest;

import org.experiment.db.repo.CustomerRepository;
import org.experiment.extensions.annotation.Log;
import org.experiment.lang.xml.RestResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/select/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse select(@PathVariable("name") String name) {
        log.info("POC for using a custom Spring JPA repository");
        return new RestResponse(String.format("You've sent %s. I'm returning %s", name, customerDB.findOne(1L)), name);
    }
}

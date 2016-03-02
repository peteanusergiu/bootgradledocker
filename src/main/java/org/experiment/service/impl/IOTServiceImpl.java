package org.experiment.service.impl;

import org.experiment.db.entities.iot.IOTEntity;
import org.experiment.db.repo.IOTRepository;
import org.experiment.lang.generic.IOTResponse;
import org.experiment.lang.iot.IOT;
import org.experiment.service.IIOTService;
import org.experiment.util.builder.IOTEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by petea on 2/29/2016.
 */
public class IOTServiceImpl implements IIOTService{

    @Autowired
    private IOTRepository iotDB;

    @Override
    public IOTResponse createUpdateIOT(IOT iot) {
        System.out.println("Serving an iot request!");

        IOTEntity existingOne = iotDB.findOne(iot.getMac());
        if (existingOne != null) {
            IOTEntityBuilder.updateExisting(existingOne, iot);
            iotDB.saveAndFlush(existingOne);
        } else {
            iotDB.save(IOTEntityBuilder.buildIOTEntity(iot));
        }

        return new IOTResponse("IOT-0000", iot.getMac(), "IOT creation result", "A detailed description of a IOT creation operation!");
    }
}

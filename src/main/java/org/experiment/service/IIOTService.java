package org.experiment.service;

import org.experiment.lang.generic.IOTResponse;
import org.experiment.lang.iot.IOT;

/**
 * Created by petea on 2/29/2016.
 */
public interface IIOTService {

    IOTResponse createUpdateIOT(IOT iot);
}

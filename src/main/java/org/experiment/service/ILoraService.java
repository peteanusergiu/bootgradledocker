package org.experiment.service;

import org.experiment.lang.lora.Lora;
import org.experiment.lang.lora.LoraResponse;

/**
 * Created by petea on 2/29/2016.
 */
public interface ILoraService {

    LoraResponse retrievePackets(Lora iot);
}

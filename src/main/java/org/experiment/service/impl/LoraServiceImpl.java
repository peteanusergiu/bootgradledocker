package org.experiment.service.impl;

import org.experiment.lang.lora.Lora;
import org.experiment.lang.lora.LoraResponse;
import org.experiment.restclient.LoraServiceClient;
import org.experiment.service.ILoraService;

/**
 * Created by petea on 2/29/2016.
 */
public class LoraServiceImpl implements ILoraService{

//    @Autowired
//    private IOTRepository iotDB;


    @Override
    public LoraResponse retrievePackets(Lora lora) {
        return LoraServiceClient.retrievePackets(lora);
    }
}

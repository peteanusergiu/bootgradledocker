package org.experiment.util.builder;

import org.experiment.db.entities.iot.*;
import org.experiment.lang.iot.IOT;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by petea on 2/29/2016.
 */
public class IOTEntityBuilder {

    /*IOT is validated on deserialisation*/
    public static IOTEntity buildIOTEntity(IOT iot) {
        IOTEntity iotEntity = new IOTEntity();
        iotEntity.setMac(iot.getMac());
        iotEntity.setType(iot.getType());

        EddystoneEntity beacon = new EddystoneEntity();
        if (!CollectionUtils.isEmpty( iot.getBeacon().getTlms() ) ) {
            Set<TLMEntity> entitiesTLM = iot.getBeacon().getTlms().stream().
                    map(tlm -> new TLMEntity(
                            tlm.getSeconds(),
                            tlm.getVoltage(),
                            tlm.getTemperature(),
                            tlm.getPdus())).collect(Collectors.toSet());
            beacon.setTlms(entitiesTLM);
        }
        if (!CollectionUtils.isEmpty( iot.getBeacon().getUids() ) ) {
            Set<UIDEntity> uids = iot.getBeacon().getUids().stream().
                    map(uid -> new UIDEntity(
                            uid.getId_namespace(),
                            uid.getId_instance(),
                            uid.getUids(),
                            uid.getUids(),
                            uid.getPower(),
                            uid.getMfg_id(),
                            uid.getRssi()))
                    .collect(Collectors.toSet());
            beacon.setUids(uids);
        }

        if (!CollectionUtils.isEmpty( iot.getBeacon().getUrls() ) ) {
            Set<URLEntity> urls = iot.getBeacon().getUrls().stream().
                    map(url -> new URLEntity(
                            url.getUrl(),
                            url.getUids(),
                            url.getUids(),
                            url.getPower(),
                            url.getMfg_id(),
                            url.getRssi()))
                    .collect(Collectors.toSet());
            beacon.setUrls(urls);
        }

        iotEntity.setBeacon(beacon);
        beacon.setIot(iotEntity);
        return iotEntity;
    }
}

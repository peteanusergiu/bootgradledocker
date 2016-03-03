package org.experiment.util.builder;

import org.experiment.db.entities.iot.*;
import org.experiment.lang.iot.IOT;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

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

        if (
                nullValue().matches(iot.getBeacon().getTlms()) ||
                        !hasItem(anything()).matches(iot.getBeacon().getTlms().getTlmList())
                ) {
            beacon.setTlms(Collections.EMPTY_SET);
        } else {
            Set<TLMEntity> entitiesTLM = iot.getBeacon().getTlms().getTlmList().stream()
                    .filter(tlm1 -> notNullValue().matches(tlm1.getSeconds()))
                    .map(tlm -> new TLMEntity(
                            tlm.getSeconds(),
                            tlm.getVoltage(),
                            tlm.getTemp(),
                            tlm.getPdus())).collect(Collectors.toSet());
            beacon.setTlms(entitiesTLM);
        }

        if (
                nullValue().matches(iot.getBeacon().getUids()) ||
                        !hasItem(anything()).matches(iot.getBeacon().getUids().getUidList())
                ) {
            beacon.setUids(Collections.EMPTY_SET);
        } else {
            Set<UIDEntity> uids = iot.getBeacon().getUids().getUidList().stream()
                    .filter(uid1 -> notNullValue().matches(uid1.getId_instance()))
                    .map(uid -> new UIDEntity(
                            uid.getId_namespace(),
                            uid.getId_instance(),
                            uid.getMinor(),
                            uid.getMajor(),
                            uid.getUuid(),
                            uid.getUuid(),
                            uid.getPower(),
                            uid.getMfg_id(),
                            uid.getRssi()))
                    .collect(Collectors.toSet());
            beacon.setUids(uids);
        }

        if (
                nullValue().matches(iot.getBeacon().getUrls()) ||
                        !hasItem(anything()).matches(iot.getBeacon().getUrls().getUrlList())
                ) {
            beacon.setUrls(Collections.EMPTY_SET);
        } else {
            Set<URLEntity> urls = iot.getBeacon().getUrls().getUrlList().stream()
                    .filter(url1 -> notNullValue().matches(url1.getIds()))
                    .map(url -> new URLEntity(
                            url.getUri(),
                            url.getIds(),
                            url.getPower(),
                            url.getMfg_id(),
                            url.getService_uuid(),
                            url.getRssi()))
                    .collect(Collectors.toSet());
            beacon.setUrls(urls);
        }

        iotEntity.setBeacon(beacon);
        beacon.setIot(iotEntity);
        return iotEntity;
    }

    public static void updateExisting(IOTEntity existingOne, IOT iot) {
        IOTEntity tempIOTEntity = IOTEntityBuilder.buildIOTEntity(iot);
        existingOne.getBeacon().getTlms().addAll(tempIOTEntity.getBeacon().getTlms());
        existingOne.getBeacon().getUrls().addAll(tempIOTEntity.getBeacon().getUrls());
        existingOne.getBeacon().getUids().addAll(tempIOTEntity.getBeacon().getUids());
    }
}

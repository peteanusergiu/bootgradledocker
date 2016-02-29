package org.experiment.db.repo;

import org.experiment.db.entities.iot.IOTEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by petea on 2/29/2016.
 */
public interface IOTRepository extends CrudRepository<IOTEntity, Long> {

    IOTEntity findOne(Long id);

    IOTEntity save(IOTEntity iot);



}

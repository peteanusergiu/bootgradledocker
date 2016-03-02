package org.experiment.db.repo;

        import org.experiment.db.entities.iot.IOTEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by petea on 2/29/2016.
 */
public interface IOTRepository extends JpaRepository<IOTEntity, String> {

    IOTEntity findOne(String id);

    IOTEntity save(IOTEntity iot);

}

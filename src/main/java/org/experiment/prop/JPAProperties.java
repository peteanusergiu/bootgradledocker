package org.experiment.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by sepetean on 9/29/2015.
 */
@ConfigurationProperties(prefix = "jpa")
public class JPAProperties {
    private BoneCPProperties bonecp = new BoneCPProperties();

    public BoneCPProperties getBonecp() {
        return bonecp;
    }
}

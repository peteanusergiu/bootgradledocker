package org.experiment.prop;

import org.experiment.prop.bonecp.BoneCPProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jpa")
public class JPAProperties {
    private BoneCPProperties bonecp;

    public BoneCPProperties getBonecp() {
        return bonecp;
    }

    public void setBonecp(BoneCPProperties bonecp) {
        this.bonecp = bonecp;
    }
}

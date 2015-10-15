package org.experiment.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="jpa.boneCP.master")
public class BoneCPPropertiesMaster extends BoneCPPropertiesENVConnection {
}

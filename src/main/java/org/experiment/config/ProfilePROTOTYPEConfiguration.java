/*
* Define bean prototypeBean with Scope prototype and expose it as ObjectFactory<PrototypeBean >
*     whenever you need a new instance for prototypeBean(default reuses the same instance)
*spring will know to locate prototypeBean() and wrap it in a ObjectFactory

* */
package org.experiment.config;

import org.experiment.lang.ProfileBean;
import org.experiment.lang.PrototypeBean;
import org.experiment.util.EnvironmentUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
public class ProfilePROTOTYPEConfiguration {
	
	@Bean
	@Scope(org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Profile(EnvironmentUtils.PROTOTYPE)
	public PrototypeBean prototypeBean(){
		return new PrototypeBean("this is a prototype example!");
	}
	
	@Bean
	@Profile(EnvironmentUtils.PROTOTYPE)
	public ProfileBean activeProfile(ObjectFactory<PrototypeBean> prototypeFactory) {
		return new ProfileBean(prototypeFactory.getObject().getProfileName());
	}


}

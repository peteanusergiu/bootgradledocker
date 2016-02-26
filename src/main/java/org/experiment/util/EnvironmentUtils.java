// Project:   Deutsche Telekom - SPICA
// Author:    Josef Fuchshuber <josef.fuchshuber@qaware.de>
// Copyright: QAware GmbH

package org.experiment.util;

import org.springframework.core.env.Environment;

/**
 * This class provides common environment operations.
 */
public final class EnvironmentUtils {

	public static final String MOCK_STS = "mocksts";
	
    public static final String DEV = "dev";
    public static final String INTEGTEST = "integtest";

    public static final String VTU = "vtu";
    public static final String BETA = "beta";
    public static final String PROD = "prod";
    public static final String NOTDEV = "!dev";

    /**
     * Checks whether the current environment is PROD.
     *
     * @param environment the current Environment
     * @return true, if the current spica environment is PROD.
     */
    public static boolean isProdEnvironment(Environment environment) {
        return environment.acceptsProfiles(PROD);
    }

    /**
     * Checks whether the current environment is BETA.
     *
     * @param environment the current Environment
     * @return true, if the current spica environment is BETA.
     */
    public static boolean isBetaEnvironment(Environment environment) {
        return environment.acceptsProfiles(BETA);
    }

    /**
     * Checks whether the current environment is an Telekom environment (VTU, BETA, PROD).
     *
     * @param environment the current Environment
     * @return true, if the current spica environment is VTU or PROD.
     */
    public static boolean isTelekomEnvironment(Environment environment) {
        return environment.acceptsProfiles(PROD, VTU, BETA);
    }

    /**
     * Checks whether a stack trace should be included in the exception.
     *
     * @param environment the current Environment
     * @return true, if the stack trace should be included in the exception
     */
    public static boolean includeStackTraceInException(Environment environment) {
        return !(EnvironmentUtils.isProdEnvironment(environment) || EnvironmentUtils.isBetaEnvironment(environment));
    }
}

// Project:   Deutsche Telekom - SPICA
// Author:    Johannes Siedersleben <johannes.siedersleben@qaware.de>
// Copyright: QAware GmbH
package org.experiment.util.usercontext;

import java.net.URI;

/**
 * A configuration.
 */
public interface IConfiguration {
    /**
     * Returns the configuration value for the given configuration key.
     *
     * @param key The configuration key.
     * @return The configuration value or {@code null} if no such value is defined.
     */
    String getString(String key);

    /**
     * Returns the configuration value (as a URI) for the given configuration key.
     *
     * @param key The configuration key.
     * @return The configuration value or {@code null} if no such value is defined.
     */
    URI getUri(String key);

    /**
     * Returns the configuration value for the given configuration key.
     *
     * @param key The configuration key.
     * @param defaultValue the default value to return if no value is found
     * @return The configuration value or default value.
     */
    public String getString(String key, String defaultValue);

    /**
     * Returns the configuration value (as an integer) for the given configuration key.
     *
     * @param key The configuration key.
     * @return The configuration value or {@code null} if no such value is defined.
     */
    Integer getInteger(String key);

    /**
     * Returns the configuration value (as a long) for the given configuration key.
     *
     * @param key The configuration key.
     * @return The configuration value or {@code null} if no such value is defined.
     */
    Long getLong(String key);

    /**
     * Returns the configuration value (as a character) for the given configuration key.
     *
     * @param key The configuration key.
     * @return The configuration value or {@code null} if no such value is defined.
     */
    Character getCharacter(String key);

    /**
     * Returns the configuration value (as a float) for the given configuration key.
     *
     * @param key The configuration key.
     * @return The configuration value or {@code null} if no such value is defined.
     */
    Float getFloat(String key);

    /**
     * Returns the configuration value (as a double) for the given configuration key.
     *
     * @param key The configuration key.
     * @return The configuration value or {@code null} if no such value is defined.
     */
    Double getDouble(String key);

    /**
     * Returns the configuration value (as a boolean) for the given configuration key.
     *
     * @param key The configuration key.
     * @return The configuration value or {@code null} if no such value is defined.
     */
    Boolean getBoolean(String key);
}

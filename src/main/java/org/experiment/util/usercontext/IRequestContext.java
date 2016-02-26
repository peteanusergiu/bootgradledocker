// Project:   Deutsche Telekom - SPICA
// Author:    Alexander Krauss <alexander.krauss@qaware.de>
// Copyright: QAware GmbH
package org.experiment.util.usercontext;


import org.joda.time.DateTimeZone;

import java.util.Locale;
import java.util.Optional;

/**
 * The request usercontext.
 */
public interface IRequestContext {

     /**
     * Returns the configuration of this request usercontext.
     *
     * @return The configuration of this request usercontext.
     */
    IConfiguration getConfiguration();

    /**
     * Returns the application identifier of this request usercontext.
     *
     * @return The application identifier of this request usercontext.
     */
    String getAppId();

    /**
     * Returns the tenant of this request usercontext.
     *
     * @return The tenant of this request usercontext.
     */
    String getTenant();

    /**
     * Returns the user information of this request usercontext.
     *
     * @return The user information of this request usercontext.
     */
    IUserInfo getUserInfo();

    /**
     * Sets the user information of this request usercontext.
     *
     * @param userInfo The new user information of this request usercontext.
     */
    void setUserInfo(IUserInfo userInfo);

    /**
     * Returns the locale of this request usercontext.
     *
     * @return The locale of this request usercontext.
     */
    Locale getLocale();

    /**
     * Returns the timezone of this request usercontext.
     *
     * @return The timezone of this request usercontext.
     */
    DateTimeZone getDateTimeZone();


    /**
     * Returns the X-UserToken of this request usercontext.
     *
     * @return The X-UserToken of this request usercontext.
     */
    Optional<String> getUserToken();

    /**
     * Returns the unique request ID.
     *
     * @return The X-Request-ID of this request usercontext.
     */
    String getUniqueRequestId();

    /**
     * Returns whether debut logging is enabled for this request.
     * This value is evaluated by framework logging functions and should NOT be evaluated by application logic.
     *
     * @return true, iff fine grained logging is enabled.
     */
    boolean isFineGrainedLoggingEnabled();

    /**
     * Returns a string describing the current request.
     * It contains information about the current configuration point and the request operation.
     *
     * @return Request information as String.
     */
    String getRequestContextString();

    /**
     * Checks whether the user of this request context is authenticated.
     *
     * @return {@code True} if the user of this request context is authenticated; {@code false} otherwise.
     */
    boolean isAuthenticated();

    /**
     * Returns the operation name of this request context.
     *
     * @return The operation name of this request context.
     */
    String getOperationName();
}

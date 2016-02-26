// Project:   Deutsche Telekom - SPICA
// Author:    Alexander Krauss <alexander.krauss@qaware.de>
// Copyright: QAware GmbH

package org.experiment.util.usercontext;


import org.experiment.util.authorisation.AuthorizationFeature;

import java.util.List;

/**
 * User information API.
 * Information about a user is represented as a generic map of Strings, with application-specific interpretations.
 * Some particularly important fields are represented directly as getters.
 * An implementation of this API may implement lazy retrieval of user information from a backend system. To minimize
 * the number of calls required, clients may indicate via {@link #addFieldsToFetchList(String...)} or
 * {@link #addFeaturesToFetchList(String...)} that some fields are probably going to be required later on. Then,
 * these fields can piggy-back on the next request to the backend and be fetched in bulk.
 */
public interface IUserInfo {
    /**
     * Field name for the user's anonymous ID.
     */
    String FIELD_ANID = "anid";

    /**
     * Field name for the user's global unique ID.
     */
    String FIELD_GUID = "guid";

    /**
     * Field name for the user's instance ID.
     */
    String FIELD_INID = "inid";

    /**
     * Field name for the user's alia.
     */
    String FIELD_ALIA = "alia";

    /**
     * Field name for the user's first name.
     */
    String FIELD_FIRST_NAME = "zusa";

    /**
     * Field name for the user's last name.
     */
    String FIELD_LAST_NAME = "name";

    /**
     * Field name for the user's mail domain.
     */
    String FIELD_DOMT = "domt";

    /**
     * Field name for the STS Calendar sync feature
     */
    String FEATURE_CALENDAR_SYNC = "/feature/activesync/synccalendar";

    /**
     * FField name for the STS Contacts sync feature
     */
    String FEATURE_CONTACTS_SYNC = "/feature/activesync/synccontacts";

    /**
     * Checks whether the current user is authenticated.
     *
     * @return {@code True} if the current user is authenticated; {@code false} otherwise.
     */
    boolean isAuthenticated();

    /**
     * Returns the value of some specific field.
     *
     * @param field The name of the field.
     * @return The value.
     */
    String getField(String field);

    /**
     * Checks whether the user has the specified feature.
     * It is assumed, that the user has a feature, if the value of the field is {@code "1"}.
     *
     * @deprecated This feature is deprecated. Use method {@link #hasFeature(IUserInfo.FeatureField)} instead.
     *
     * @param field The name of the field/feature.
     * @return {@code True} if the user has the feature, or {@code false} otherwise.
     */
    @Deprecated
    boolean hasFeature(String field);

    /**
     * Checks whether the user has the specified features.
     * It is assumed, that the user has all features, if the value of the field is {@code "1"}.
     *
     * @deprecated This feature is deprecated. Use method {@link #hasFeature(IUserInfo.FeatureField)} instead.
     *
     * @param fields The names of the fields/features.
     * @return {@code True} if the user has the feature, or {@code false} otherwise.
     */
    @Deprecated
    boolean hasFeatures(String... fields);

    /**
     * Checks whether the user has the specified feature.
     * It is assumed, that the user has a feature, if the value of the field is {@code "1"}.
     *
     * @param field The feature.
     * @return {@code True} if the user has the feature, or {@code false} otherwise.
     */
    boolean hasFeature(FeatureField field);
    
    /**
     * Returns list of feature strings.
     *
     * @return the feature strings.
     */
    List<AuthorizationFeature> getFeatures();

    /**
     * Convenience. Equivalent to {@code getField(FIELD_ANID)}.
     *
     * @return The anid.
     */
    String getAnid();

    /**
     * Convenience. Equivalent to {@code getField(FIELD_GUID)}.
     *
     * @return The guid.
     */
    String getGuid();

    /**
     * Convenience. Returns the guid value as hash string.
     * @return The guid value as hash string.
     */
    String getGuidHash();

    /**
     * Convenience. Equivalent to {@code getField(FIELD_INID)}.
     *
     * @return The inid.
     */
    String getInid();

    /**
     * Convenience. Equivalent to {@code getField(FIELD_ALIA)}.
     *
     * @return The alia.
     */
    String getAlia();

    /**
     * Indicates that some fields might be required later and should be retrieved from the backend at the
     * next possible occasion, e.g., the next call to {@link #getField(String)}.
     *
     * @param fields The set of fields.
     */
    void addFieldsToFetchList(String... fields);

    /**
     * Indicates that some features might be required later and should be retrieved from the backend at the
     * next possible occasion. Calling this method is equivalent to calling {@link #addFieldsToFetchList}
     * with the fields of the f-, and d-flags for the feature.
     *
     * @param features The feature, e.g., {@code "775"}.
     */
    void addFeaturesToFetchList(String... features);
    
    /**
     * Enumeration of allowed
     */
    public static enum FeatureField {

        STS_FEATURE_NAME_VOICEBOX("/feature/voip/sprachbox", "355");

        /**
         * The path of the feature
         */
        private final String featurePath;

        /**
         * The numerical id of the feature
         */
        private final String featureId;

        private FeatureField(String featurePath, String featureId) {
            this.featurePath = featurePath;
            this.featureId = featureId;
        }

        /**
         * @return The path of the feature
         */
        public String getFeaturePath() {
            return featurePath;
        }

        /**
         * @return The numerical id of the feature
         */
        public String getFeatureId() {
            return featureId;
        }
    }
}

// Project:   Deutsche Telekom - SPICA
// Author:    Reiner Hüttl <reiner.huettl@qaware.de>
// Copyright: QAware GmbH
package org.experiment.util.authorisation;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An authorization feature with an authorization decision.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public final class AuthorizationFeature {

    /**
     * The authorization decision's feature name (e.g. /feature/t-online/pay_per_click).
     */
    @XmlAttribute(required = true)
    private final String feature;

    /**
     * The authorization decision flag.
     */
    @XmlAttribute(required = true)
    private final Boolean decision;

    /**
     * Constructs a new {@code AuthorizationFeature}.
     */
    public AuthorizationFeature() {
        this.feature = null;
        this.decision = false;
    }

    /**
     * Constructs a new {@code AuthorizationFeature}.
     *
     * @param feature The authorization decision's feature name.
     * @param decision The authorization decision flag.
     */
    public AuthorizationFeature(String feature, boolean decision) {
        this.feature = feature;
        this.decision = decision;
    }

    /**
     * Returns this authorization decision's feature name.
     *
     * @return This authorization decision's feature name.
     */
    public String getFeature() {
        return this.feature;
    }

    /**
     * Returns this authorization decision's flag value.
     *
     * @return This authorization decision's flag value.
     */
    public Boolean isDecision() {
        return this.decision;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        AuthorizationFeature that = (AuthorizationFeature) object;

        return new EqualsBuilder()
                .append(this.feature, that.feature)
                .append(this.decision, that.decision)
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.feature)
                .append(this.decision)
                .toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("feature", this.feature).
                append("decision", this.decision).
                toString();
    }
}

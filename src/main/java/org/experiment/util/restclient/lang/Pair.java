package org.experiment.util.restclient.lang;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Datatype that represents a pair of values.
 *
 * @param <F> the type of the first element
 * @param <S> the type of the second element
 */
public class Pair<F, S> implements Serializable {

    private F first;
    private S second;

    /**
     * Constructs a new {@code Pair}.
     *
     * @param first  The first element of the pair. May be null.
     * @param second The second element of the pair. May be null.
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Returns the first element of this pair.
     *
     * @return The first element of this pair.
     */
    public F getFirst() {
        return this.first;
    }

    /**
     * Returns the second element of this pair.
     *
     * @return The second element of this pair.
     */
    public S getSecond() {
        return this.second;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.first != null) {
            sb.append("first=").append(this.first.toString()).append(';');
        }
        if (this.second != null) {
            sb.append("second=").append(this.second.toString()).append(';');
        }
        return sb.toString();
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

        Pair that = (Pair) object;

        return new EqualsBuilder()
                .append(this.first, that.first)
                .append(this.second, that.second)
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.first)
                .append(this.second)
                .toHashCode();
    }
}

package org.experiment.util.builder;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.*;

/**
 * Methods to help constructing objects.
 */
public final class BuilderHelper {

    private static final Logger LOG = LoggerFactory.getLogger(BuilderHelper.class);

    /**
     * Prevents instantiation of this utility class.
     */
    private BuilderHelper() {
        // empty
    }

    /**
     * Returns the input object or the default value, if the input is {@code null}.
     *
     * @param obj          The input object or {@code null}.
     * @param defaultValue The default value (non-null).
     * @param <T>          The type of object.
     * @return The input object or the default value, if the input is {@code null}.
     */
    public static <T> T getWithDefault(T obj, T defaultValue) {
        return (obj == null) ? defaultValue : obj;
    }

    /**
     * Returns an unmodifiable copy of the input collection or an empty list, if the input is {@code null}.
     *
     * @param obj The input collection or {@code null}.
     * @param <T> The type of elements in the collection.
     * @return An unmodifiable copy of the input collection or an empty list, if the input is {@code null}.
     */
    public static <T> List<T> copyListWithEmptyDefault(Collection<? extends T> obj) {
        return (obj == null)
                ? Collections.<T>emptyList()
                : Collections.unmodifiableList(new ArrayList<T>(obj));
    }

    /**
     * Returns an unmodifiable copy of the input collection or {@code null} if the input is {@code null}.
     *
     * @param obj The input collection or {@code null}.
     * @param <T> The type of elements in the collection.
     * @return An unmodifiable copy of the input collection or {@code null} if the input is {@code null}.
     */
    public static <T> List<T> copyList(Collection<? extends T> obj) {
        return (obj == null)
                ? null
                : Collections.unmodifiableList(new ArrayList<T>(obj));
    }

    /**
     * Returns an unmodifiable copy of the input collection or an empty set if the input is {@code null}.
     *
     * @param obj The input collection or {@code null}.
     * @param <T> The type of elements in the collection.
     * @return An unmodifiable copy of the input collection or an empty set if the input is {@code null}.
     */
    public static <T> Set<T> copySetWithEmptyDefault(Collection<? extends T> obj) {
        return (obj == null)
                ? Collections.<T>emptySet()
                : Collections.unmodifiableSet(new HashSet<T>(obj));
    }

    /**
     * Returns an unmodifiable copy of the input collection or {@code null} if the input is {@code null}.
     *
     * @param obj The input collection or {@code null}.
     * @param <T> The type of elements in the collection.
     * @return An unmodifiable copy of the input collection or {@code null} if the input is {@code null}.
     */
    public static <T> Set<T> copySet(Collection<? extends T> obj) {
        return (obj == null)
                ? null
                : Collections.unmodifiableSet(new HashSet<T>(obj));
    }

    /**
     * Returns an unmodifiable copy of the input map or an empty map, if the input is {@code null}.
     *
     * @param obj The input collection or {@code null}.
     * @param <K> The type of keys in the map.
     * @param <V> The type of values in the map.
     * @return An unmodifiable copy of the input map or an empty map, if the input is {@code null}.
     */
    public static <K, V> Map<K, V> copyMapWithEmptyDefault(Map<? extends K, ? extends V> obj) {
        return (obj == null)
                ? Collections.<K, V>emptyMap()
                : Collections.unmodifiableMap(new HashMap<K, V>(obj));
    }



    /**
     * Parses an address value into a URI.
     * An address is ignored, of it is {@code null}, empty, or blank.
     *
     * @param addressValue The address value or {@code null}.
     * @return The URI or {@code null}.
     */
    public static URI parseAddress(String addressValue) {
        return StringUtils.isNotBlank(addressValue) ? URI.create(addressValue) : null;
    }

    /**
     * Parses a variable number of addresses into a list of URIs.
     * An address is ignored, if it is {@code null}, empty, or blank.
     *
     * @param addressValues The address values.
     * @return The list of address URIs.
     */
    public static Set<URI> parseAddresses(String... addressValues) {

        if (addressValues == null) {
            return null;
        }

        Set<URI> addresses = new LinkedHashSet<URI>(addressValues.length);
        for (String addressValue : addressValues) {
            if (StringUtils.isNotBlank(addressValue)) {
                addresses.add(URI.create(addressValue));
            }
        }
        return addresses;
    }

    /**
     * Returns the elements of the collection as a comma-separated string.
     *
     * @param collection The collection.
     * @param <T>        The type of element.
     * @return The elements of the collection as a comma-separated string, or {@code null} if the collection was
     *         {@code null} or empty.
     */
    public static <T> String joinWithComma(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        } else {
            return StringUtils.join(collection, ",");
        }
    }

    /**
     * Returns a set with elements of the comma-separated string.
     *
     * @param value The comma-separated string.
     * @return The set with elements or {@code null}.
     */
    public static String[] splitWithComma(String value) {

        return StringUtils.split(value, ",");
    }
}

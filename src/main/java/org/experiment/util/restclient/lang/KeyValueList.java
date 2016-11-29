package org.experiment.util.restclient.lang;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KeyValueList {

    List<Pair<String, String>> keyValues;

    public KeyValueList() {
        this.keyValues = new ArrayList<Pair<String, String>>();
    }

    public KeyValueList add(String key, String value) {
        if (value != null) {
            this.keyValues.add(new Pair<String, String>(key, value));
        }
        return this;
    }

    public KeyValueList addAll(String key, Collection<String> values) {
        if (values != null) {
            for (String value : values) {
                this.keyValues.add(new Pair<String, String>(key, value));
            }
        }
        return this;
    }

    public List<Pair<String, String>> getKeyValues() {
        return this.keyValues;
    }
}

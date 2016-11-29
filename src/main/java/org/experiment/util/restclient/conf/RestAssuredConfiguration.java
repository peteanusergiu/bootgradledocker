package org.experiment.util.restclient.conf;


import org.experiment.util.restclient.lang.Pair;

import java.net.URL;


public interface RestAssuredConfiguration {
    String getBaseURI();

    int getPort();

    String getBasePath();

    Pair<URL, String> getKeyStore();

    boolean isProdEnvironment();
}

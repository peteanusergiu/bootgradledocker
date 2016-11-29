package org.experiment.util.restclient;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.DecoderConfig;
import com.jayway.restassured.config.EncoderConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.ProxySpecification;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.log4j.Logger;
import org.experiment.util.restclient.conf.Configuration;
import org.experiment.util.restclient.conf.RestAssuredConfiguration;
import org.experiment.util.restclient.lang.KeyValueList;
import org.experiment.util.restclient.lang.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class RestClient {

	private static final Logger LOG = Logger.getLogger(RestClient.class);

    public static void setup(RestAssuredConfiguration restAssuredConfiguration, Boolean withProxy) {

        RestAssured.config = RestAssuredConfig.newConfig()
                .encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("US-ASCII"))
                .decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("US-ASCII"));

        // set basic service information
        RestAssured.baseURI = restAssuredConfiguration.getBaseURI();
        RestAssured.port = restAssuredConfiguration.getPort();
        RestAssured.basePath = restAssuredConfiguration.getBasePath();

        if(withProxy && System.getProperty("http.proxyHost") != null && System.getProperty("http.proxyPort") != null) {
            RestAssured.proxy(ProxySpecification.host(System.getProperty("http.proxyHost"))
                    .withPort(Integer.parseInt(System.getProperty("http.proxyPort")))
                    .withScheme("http"));
        }

        if (restAssuredConfiguration.getKeyStore() != null) {
//            RestAssured.keystore(
//                    FileUtils.toFile(restAssuredConfiguration.getKeyStore().getFirst()).getAbsolutePath(),
//                    restAssuredConfiguration.getKeyStore().getSecond());
        } else {
        	RestAssured.useRelaxedHTTPSValidation();
        }
    }

//    public static <T extends BaseResponse> T properResponse(Configuration configuration, Class<T> cls,
    public static <T> T properResponse(Configuration configuration, Class<T> cls,
                                       Response response) {
        check(response);

        T result = response.as(cls, getObjectMapperType(configuration.getMediaTypeProduced()));
        assertThat(result, is(notNullValue()));
//        assertThat(result.getError(), is(nullValue()));

        return result;
    }

    public static Response check(Response response) {
        assertThat(response, is(notNullValue()));

        if (response.getStatusCode() == HttpStatus.OK.value()) {
            //assertThat(response.getHeader(SpicaHttpHeaders.X_REQUEST_ID.toString()), notNullValue());
//            assertThat(response.getHeader(CustomHttpHeaders.GENERATED_BY_HEADER.toString()), notNullValue());
        } else {
            assertThat(response.getBody().print(), response.getStatusCode(), is(HttpStatus.OK.value()));
        }
        return response;
    }

    public static Response getRequest(Configuration configuration, String operationName) {
        return setupRequest(configuration).get(operationName);
    }

    public static Response getRequestWithParams(Configuration configuration, String operationName, Object... pathParams) {
        return setupRequest(configuration).get(operationName, pathParams);
    }

    public static Response getRequest(Configuration configuration, KeyValueList parameters, String operationName) {
        return withParameters(parameters, setupRequest(configuration)).get(operationName);
    }

    public static Response getRequestWithParams(Configuration configuration, KeyValueList parameters, String operationName, Object... pathParams) {
        return withParameters(parameters, setupRequest(configuration)).get(operationName, pathParams);
    }

    public static Response getRequest(Configuration configuration, KeyValueList headers, KeyValueList parameters,
                                      String operationName) {
        return withParameters(parameters, withHeaders(headers, setupRequest(configuration))).get(operationName);
    }

    public static Response putRequest(Configuration configuration, String operationName) {
        return setupRequest(configuration).put(operationName);
    }

    public static Response putRequestWithParams(Configuration configuration, String operationName, Object... pathParams) {
        return setupRequest(configuration).put(operationName, pathParams);
    }

    public static Response putRequest(Configuration configuration, Object bodyObject, String operationName) {
        return withBody(configuration, bodyObject, setupRequest(configuration)).put(operationName);
    }

    public static Response putRequestWithParams(Configuration configuration, Object bodyObject, String operationName, Object... pathParams) {
        return withBody(configuration, bodyObject, setupRequest(configuration)).put(operationName, pathParams);
    }

    public static Response postRequest(Configuration configuration, String operationName) {
        return setupRequest(configuration).post(operationName);
    }

    public static Response postRequestWithParams(Configuration configuration, String operationName, Object... pathParams) {
        return setupRequest(configuration).post(operationName, pathParams);
    }

    public static Response postRequest(Configuration configuration, Object bodyObject, String operationName) {
        return withBody(configuration, bodyObject, setupRequest(configuration)).post(operationName);
    }

    public static Response postRequestWithParams(Configuration configuration, Object bodyObject, String operationName, Object... pathParams) {
        return withBody(configuration, bodyObject, setupRequest(configuration)).post(operationName, pathParams);
    }

    public static Response postRequestWithParams(Configuration configuration, KeyValueList headers, Object bodyObject,
                                                 String operationName, Object... pathParams) {
        return withBody(configuration, bodyObject, withHeaders(headers, setupRequest(configuration))).post(operationName, pathParams);
    }

    public static Response postRequestWithHeaders(Configuration configuration, KeyValueList headers, Object bodyObject,
                                                  String operationName) {
        return withBody(configuration, bodyObject, withHeaders(headers, setupRequest(configuration)))
                .post(operationName);
    }

    public static Response postRequestWithFormParameters(Configuration configuration, KeyValueList formParameters,
                                                         String operationName) {
        KeyValueList headers = new KeyValueList()
                .add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);

        return withFormParameters(formParameters, withHeaders(headers, setupRequest(configuration)))
                .post(operationName);
    }

    public static Response deleteRequest(Configuration configuration, String operationName) {
        return setupRequest(configuration).delete(operationName);
    }

    public static Response deleteRequestWithParams(Configuration configuration, String operationName, Object... pathParams) {
        return setupRequest(configuration).delete(operationName, pathParams);
    }

    public static Response deleteRequest(Configuration configuration, Object bodyObject, String operationName) {
        return withBody(configuration, bodyObject, setupRequest(configuration)).delete(operationName);
    }

    public static Response deleteRequestWithParams(Configuration configuration, Object bodyObject, String operationName, Object... pathParams) {
        return withBody(configuration, bodyObject, setupRequest(configuration)).delete(operationName, pathParams);
    }


    public static Response deleteRequestWithFormParameters(Configuration configuration, KeyValueList formParameters,
                                                           String operationName) {
        KeyValueList headers = new KeyValueList()
                .add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);

        return withFormParameters(formParameters, withHeaders(headers, setupRequest(configuration)))
                .delete(operationName);
    }

    public static RequestSpecification setupRequest(Configuration configuration) {
        return setupRequest(configuration, null);
    }

    public static RequestSpecification setupRequest(Configuration configuration, String accessToken) {

        RequestSpecification requestSpecification = given()
//                .header(HttpHeaders.AUTHORIZATION, configuration.getTestAuthorization())
                .header(HttpHeaders.ACCEPT, configuration.getMediaTypeConsumed())
//                .header(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8)
                .header(HttpHeaders.CONTENT_TYPE, configuration.getMediaTypeProduced());

        if (StringUtils.isNotBlank(accessToken)) {
            requestSpecification.header("access_token", accessToken);
        } else {
        	if (StringUtils.isNotBlank(configuration.getAccessToken()))
        		requestSpecification.header("access_token", configuration.getAccessToken());
        }

        if (configuration.getTimeZone() != null) {
            requestSpecification.header("Timezone", configuration.getTimeZone().toString());
        }

        return requestSpecification;
    }

    private static RequestSpecification withHeaders(KeyValueList headers, RequestSpecification requestSpecification) {
        for (Pair<String, String> header : headers.getKeyValues()) {
            requestSpecification.header(header.getFirst(), header.getSecond());
        }
        return requestSpecification;
    }

    private static RequestSpecification withFormParameters(KeyValueList formParameters,
                                                           RequestSpecification requestSpecification) {
        for (Pair<String, String> parameter : formParameters.getKeyValues()) {
            requestSpecification.formParameter(parameter.getFirst(), parameter.getSecond());
        }
        return requestSpecification;
    }

    private static RequestSpecification withParameters(KeyValueList parameters,
                                                       RequestSpecification requestSpecification) {
        for (Pair<String, String> parameter : parameters.getKeyValues()) {
            requestSpecification.parameter(parameter.getFirst(), parameter.getSecond());
        }
        return requestSpecification;
    }

    public static RequestSpecification withBody(Configuration configuration, Object bodyObject,
                                                RequestSpecification requestSpecification) {
        requestSpecification.header(new Header("Content-Type", configuration.getMediaTypeProduced()));

        if (bodyObject != null) {
            if (configuration.getMediaTypeProduced().equals(MediaType.APPLICATION_JSON_VALUE)) {
                requestSpecification.body(bodyObject, getObjectMapperType(configuration.getMediaTypeProduced()));
            } else {
            	//defaults to xml - TODO: extend with other types when needed 
//                requestSpecification.body(writeObjectAsXMLString(bodyObject));
            }
        }
        return requestSpecification;
    }

    /**
     * This method builds an URL by concatenating the given parts.
     * <p/>
     * Do not use this method, use Rest Assured Path Parameter instead.
     *
     * @param parts URL parts.
     * @return URL.
     */
    @Deprecated
    public static String operationNameOf(String... parts) {
        return StringUtils.join(parts, "/");
    }

    public static ObjectMapperType getObjectMapperType(String mediaType) {
        if (mediaType.equals(MediaType.APPLICATION_JSON_VALUE)) {
            return ObjectMapperType.JACKSON_2;
        } else {
            return ObjectMapperType.JAXB;
        }
    }
    
//    public static String writeObjectAsXMLString(Object object){
//		return ObjectMapping.serialize(
//				object, MediaType.APPLICATION_XML_VALUE, StandardCharsets.UTF_8.toString(),
//				ObjectMapperType.JAXB, ObjectMapperConfig.objectMapperConfig(), EncoderConfig.encoderConfig());
//	}
}

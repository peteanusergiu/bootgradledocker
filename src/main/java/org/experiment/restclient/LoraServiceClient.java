package org.experiment.restclient;

import org.experiment.lang.lora.Lora;
import org.experiment.lang.lora.LoraResponse;
import org.experiment.util.constants.LoraReturnCodes;
import org.springframework.http.*;

import java.util.Collections;

import static org.experiment.util.restclient.RestTemplateClientBuilder.buildJsonRestClient;

/**
 * Created by petea on 5/28/2016.
 */
/*TODO: make this class generic and reuse the common code */
public class LoraServiceClient {

    public static final String FLASHNET_REST = "http://fc1.intelilight.eu:4444/api";
//    public static final String LOCALHOST_REST_IOT_STATUS_UPDATE = "http://localhost:8082//iot/statusUpdate";

    /*the simples form*/
    public static <T> LoraResponse post(String uri, T loraRequest, String servicePath) {
        try {
            LoraResponse restResponse = buildJsonRestClient().postForObject(
                    uri, loraRequest, LoraResponse.class, servicePath);
            return restResponse;
        } catch(Exception e){
            System.out.println(String.format("Alarm raised REST call failed because : %s", e.getMessage()));
            return null;
        }
    }

    /*todo: extend generic and add response as well*/
    private static <T> LoraResponse callServiceWithMedia(String uri, HttpMethod method, T object, MediaType acceptMediaType, MediaType contentMediaType) {
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
//            requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
            requestHeaders.setAccept(Collections.singletonList(acceptMediaType));
//            requestHeaders.setContentType(new MediaType("application","json"));
            requestHeaders.setContentType(contentMediaType);
            HttpEntity<T> requestEntity = new HttpEntity<T>(object, requestHeaders);

            ResponseEntity<LoraResponse> restResponseEntity = buildJsonRestClient().
                    exchange(uri, method, requestEntity, LoraResponse.class);

            return restResponseEntity.getBody();
        } catch(Exception e){
            System.out.println(String.format("Alarm raised REST call failed because : %s", e.getMessage()));
            return null;
        }

    }

    public static LoraResponse retrievePackets(Lora lora) {
        LoraResponse loraResponse = callServiceWithMedia(FLASHNET_REST, HttpMethod.POST, lora, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON);
//        return post(LOCALHOST_REST_IOT_ALARM_RAISE, alarmRequest, "");
        /*todo : use ReturnCode class instead of IOTReturnCodes*/
       if (loraResponse == null || loraResponse.getOk().equalsIgnoreCase(LoraReturnCodes.ERROR.getValue())) {
           System.out.println(String.format("REST call to LORA failed"));
           return new LoraResponse(loraResponse.getDeveui(), loraResponse.getOp(), loraResponse.getOk(), loraResponse.getDeveui());
       } else {
           return loraResponse;
       }
    }

}
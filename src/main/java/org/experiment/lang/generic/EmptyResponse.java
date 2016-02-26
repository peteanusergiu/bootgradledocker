package org.experiment.lang.generic;


import java.io.Serializable;

/**
 * A response that only contains possible error values.
 * The outcome of the api-operation should be available via the http-status code.
 *
 * Created by simon.baeumler on 19.01.2015.
 */
public class EmptyResponse extends BaseResponse implements Serializable {
}
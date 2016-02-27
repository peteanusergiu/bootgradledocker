package org.experiment.rest;

import javaslang.control.Try;
import org.apache.log4j.Logger;
import org.experiment.lang.generic.BaseResponse;
import org.experiment.util.errormodel.ExceptionHandlerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

public class BaseController {

    protected Logger logger;

    @Autowired
    protected Environment environment;


    protected <T extends BaseResponse> ResponseEntity<T> tryWithRecovery(Try.CheckedSupplier<T> supplier,
                                                                         Class<T> responseClass) {
        return ExceptionHandlerUtils.tryWithRecovery(supplier, responseClass, environment, logger);
    }
}

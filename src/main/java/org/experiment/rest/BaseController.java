package org.experiment.rest;

import javaslang.control.Try;
import org.apache.commons.logging.Log;
import org.experiment.lang.generic.BaseResponse;
import org.experiment.util.errormodel.ExceptionHandlerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

public class BaseController {
    @Autowired
    protected Log logger;

    @Autowired
    protected Environment environment;


    protected <T extends BaseResponse> ResponseEntity<T> tryWithRecovery(Try.CheckedSupplier<T> supplier,
                                                                         Class<T> responseClass) {
        return ExceptionHandlerUtils.tryWithRecovery(supplier, responseClass, environment, logger);
    }
}

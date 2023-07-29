package com.avi.demo.jpademo.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avi.demo.jpademo.util.Response;
import com.avi.demo.jpademo.util.ResponseBuilder;
import com.avi.demo.jpademo.util.StatusCode;

/*
 * Used Error 4852,53,54
 */
@ControllerAdvice
public class SharesExceptionHandler
{
    private static final Logger logger = LoggerFactory.getLogger(SharesExceptionHandler.class);

    @Autowired
    ResponseBuilder responseBuilder;

    @ExceptionHandler(UnexpectedRollbackException.class)
    public @ResponseBody Response handleUnexpectedRollbackException(UnexpectedRollbackException ex)
    {
        logger.error(
            "##EX## UnexpectedRollbackException in method- handleUnexpectedRollbackException and class- {}  {} \n {}",
            getClass().getName(), ex.getMessage() != null ? ex.getMessage() : "", ExceptionUtils.getStackTrace(ex));
        return responseBuilder.createResponse(StatusCode.ERROR, StatusCode.TRANSACTION_SILENTLY_ROLLED_BACK,
            StatusCode.ERROR_STATUS_TYPE, null);
    }

    @ExceptionHandler(Throwable.class)
    public @ResponseBody Response handleAllExceptions(Throwable ex)
    {
        logger.error("##EX## CommonException in method- handleAllExceptions and class- {}  {} \n {}",
            getClass().getName(), ex.getMessage() != null ? ex.getMessage() : "", ExceptionUtils.getStackTrace(ex));
        return responseBuilder.createResponse(StatusCode.ERROR, StatusCode.INTERNAL_SERVER_ERROR_COMMON,
            StatusCode.ERROR_STATUS_TYPE, ex.getLocalizedMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public @ResponseBody Response handleConstraintViolationException(ConstraintViolationException ex)
    {
        logger.error(
            "##EX## ConstraintViolationException in method- handleConstraintViolationException and class- {}  {} \n {} ",
            getClass().getName(), ex.getMessage() != null ? ex.getMessage() : "", ExceptionUtils.getStackTrace(ex));
        return responseBuilder.createResponse(StatusCode.ERROR, StatusCode.CONSTRAINT_VIOLATION_ERROR,
            StatusCode.ERROR_STATUS_TYPE, ex.getLocalizedMessage());
    }

}

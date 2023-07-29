package com.avi.demo.jpademo.util;

import static com.avi.demo.jpademo.util.StatusCode.ERROR;
import static com.avi.demo.jpademo.util.StatusCode.MODULE_NAME;
import static com.avi.demo.jpademo.util.StatusCode.SUCCESS;
import static com.avi.demo.jpademo.util.StatusCode.UNDER_SCORE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Response builder class based on the {@link StatusCode} and message properties.
 *
 * @author Avinash.Gurav
 */
@Component
public class ResponseBuilder
{

    @Autowired
    ConfigUtility properties;

    @Autowired
    Response response;

    public void setProperties(ConfigUtility properties)
    {
        this.properties = properties;
    }

    public void setResponse(Response response)
    {
        this.response = response;
    }

    /**
     * @return example : for Locker : SU_LK_
     */
    private String getSuccessCode()
    {
        return SUCCESS + UNDER_SCORE + properties.getProperty(MODULE_NAME) + UNDER_SCORE;
    }

    /**
     * @return example : for Locker : EX_LK_
     */
    private String getErrorCode()
    {
        return ERROR + UNDER_SCORE + properties.getProperty(MODULE_NAME) + UNDER_SCORE;
    }

    /**
     * Method to form full success message based on input code. <br>
     * Example: Application Locker :- returns SU_LK_2001 if input code is StatusCode._2001 or any other constant value
     * 
     * @param code String constant success range value, must be never null.
     * @return String message code example - SU_LK_4000
     */
    public String getFullSuccessCode(String code)
    {
        return getSuccessCode() + code;
    }

    /**
     * Method to form full error or exception message based on input code. <br>
     * Example: Application Locker :- returns EX_LK_4000 if input code constant is StatusCode._4000
     * 
     * @param code String constant error range value, must be never null.
     * @return String message code example - EX_LK_4000
     */
    public String getFullErrorCode(String code)
    {
        return getErrorCode() + code;
    }

    /**
     * Method to create response object based on success or error flag value.
     * 
     * @param codeFlag Either StatusCode.SUCCESS "SU" or StatusCode.ERROR "EX".
     * @param code constant value from {@link StatusCode} success or error code range.
     * @param statusTye constant values from {@link StatusCode} can be S - Success, E - Error, W - Warning.
     * @param details expected result object.
     * @return
     */
    public Response createResponse(String codeFlag, String code, String statusTye, Object details)
    {
        String fullCode;
        if (codeFlag.equals(SUCCESS)) {
            fullCode = getFullSuccessCode(code);
        } else {
            fullCode = getFullErrorCode(code);
        }
        return createResponse(fullCode, statusTye, details);
    }

    /**
     * Method to create response object based on exact code.
     * 
     * @param fullCode exact formatted message code. i.e: SU_LK_2001 or EX_lK_4001
     * @param statusTye constant values from {@link StatusCode} can be S - Success, E - Error, W - Warning.
     * @param details expected result object.
     * @return
     */
    public Response createResponse(String fullCode, String statusTye, Object details)
    {
        Response response = new Response();
        response.setStatusCode(fullCode);
        response.setStatusDes(properties.getProperty(fullCode));
        response.setStatusType(statusTye);
        response.setDetails(details);
        return response;
    }
}

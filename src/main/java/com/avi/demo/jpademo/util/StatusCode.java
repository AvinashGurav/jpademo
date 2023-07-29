package com.avi.demo.jpademo.util;

/**
 * Class to handle common success and error message constant codes.
 *
 * @author avinash.gurav
 */
public class StatusCode
{
    private StatusCode()
    {

    }

    // static final constant declared to form a message string.
    public static final String UNDER_SCORE = "_";

    public static final String MODULE_NAME = "moduleName";

    public static final String ERROR = "EX";

    public static final String SUCCESS = "SU";

    public static final String SUCCESS_STATUS_TYPE = "S";

    public static final String WARNING_STATUS_TYPE = "W";

    public static final String ERROR_STATUS_TYPE = "E";

    public static final String BAD_REQUEST = "400";

    public static final String SYSTEM_ERROR = "500";

    public static final String OK = "200";

    public static final String STATUS_DESC_NOT_FOUND = "Status description not found";

    public static final String INVALID_RESPONSE_STATUS = "12544";

    public static final String SUCCESSFULLY_FETCHED_RECORD = "1000";

    public static final String SUCCESSFULLY_SAVED_RECORD = "1001";

    public static final String ERROR_WHILE_SAVING = "1002";

    public static final String TRANSACTION_SILENTLY_ROLLED_BACK = "1028";

    public static final String CONSTRAINT_VIOLATION_ERROR = "17339";

    public static final String INTERNAL_SERVER_ERROR_COMMON = "17340";

    public static final String MISSING_REQUEST_HEADER_EXCEPTION = "17340";

    public static final String SHR_PROD_DETAILS = "2000";

    public static final String NO_ROC_SHR_PROD_DETAILS = "2001";

    public static final String INVALID_INPUT_DATA = "2002";

    public static final String NO_REC_CERT_MASTER = "2003";

    public static final String GETTN_ERR_CERT_MASTER = "2004";

    public static final String SUCCESSFULLY_DELETED_RECORD = "2005";

}

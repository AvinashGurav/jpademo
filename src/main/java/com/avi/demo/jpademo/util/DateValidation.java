package com.avi.demo.jpademo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avi.demo.jpademo.constant.CBSConstants;

/**
 * Class Is used To Convert String To Date and Vice Versa
 * 
 * @author chetan.kinge
 */
@Component
@Scope("prototype")
public class DateValidation
{

    public static final Logger logger = LoggerFactory.getLogger(DateValidation.class);

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    private SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");

    private SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Method To Convert String date
     * 
     * @param date
     * @return
     */
    public Date getDate(String date)
    {

        Date convertDate = null;
        try {
            convertDate = dateFormat.parse(date);
        } catch (ParseException e) {
            logger.error("##EX## ParseException in method- getDate and class- {}  {} \n {}", getClass().getName(),
                e.getMessage() != null ? e.getMessage() : "", ExceptionUtils.getStackTrace(e));
        }
        return convertDate;
    }

    /**
     * Method To Convert String date to util Date
     * 
     * @param date
     * @return
     */
    public static Date getDate(String date, String dateFormat)
    {

        Date convertDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        try {
            convertDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error("##EX## ParseException in method-getDate and class- DateValidation  {} \n {}",
                e.getMessage() != null ? e.getMessage() : "", ExceptionUtils.getStackTrace(e));
        }
        // validation if required
        return convertDate;
    }

    /**
     * Method To Convert Date To String
     * 
     * @param date
     * @return
     */
    public String convertDateToStr(Date date)
    {
        return (date != null) ? dateFormat.format(date) : "";
    }

    public String getDateAs_yyyyMMdd(Date date)
    {
        return dateFormat1.format(date);
    }

    public Date parseDateAs_yyyyMMdd(String dateStr)
    {

        try {
            return dateFormat1.parse(dateStr);
        } catch (ParseException e) {
            logger.error("##EX## ParseException in method- parseDateAs_yyyyMMdd and class- {}  {} \n {}",
                getClass().getName(), e.getMessage() != null ? e.getMessage() : "", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    public static DateValidation du = null;

    public static DateValidation getInstance()
    {
        if (DateValidation.du == null) {
            du = new DateValidation();
        }
        return du;
    }

    public Date convertFromDateForReporting(Date fromDate)
    {
        Calendar fromD = Calendar.getInstance();
        fromD.setTime(fromDate);
        fromD.set(Calendar.HOUR, 0);
        fromD.set(Calendar.MINUTE, 0);
        fromD.set(Calendar.SECOND, 0);
        fromD.set(Calendar.MILLISECOND, 000);
        return fromD.getTime();
    }

    public Date convertToDateForReporting(Date toDate)
    {
        Calendar toD = Calendar.getInstance();
        toD.setTime(toDate);
        toD.set(Calendar.HOUR, 23);
        toD.set(Calendar.MINUTE, 59);
        toD.set(Calendar.SECOND, 59);
        toD.set(Calendar.MILLISECOND, 000);
        return toD.getTime();
    }

    public Date stringToDate(String strDate)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CBSConstants.DATE_FORMAT);

        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(strDate);
        } catch (ParseException e) {
            logger.error("##EX## ParseException in method-stringToDate and class- {}  {} \n {}", getClass().getName(),
                e.getMessage() != null ? e.getMessage() : "", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    public String convertDateToString(Date date)
    {
        return (date != null) ? dateFormat2.format(date) : "";
    }

    public static Date getCurrentDate(String todaysDate)
    {
        try {
            return new SimpleDateFormat(CBSConstants.DATE_FORMAT).parse(todaysDate);
        } catch (ParseException e) {
            logger.error("##EX## ParseException in method-getCurrentDate and class- {}  {} \n {}", "",
                e.getMessage() != null ? e.getMessage() : "", e);
        }
        return null;
    }

    /**
     * @author shashank.paranjape
     * @param date
     * @return
     */
    public Date getDateWithSystemTimeFromStr(String date)
    {
        Date todaysDate = getDate(date);
        Calendar fromD = Calendar.getInstance();
        fromD.setTime(todaysDate);

        int year = fromD.get(Calendar.YEAR);
        int month = fromD.get(Calendar.MONTH);
        int day = fromD.get(Calendar.DAY_OF_MONTH);

        fromD.setTimeInMillis(System.currentTimeMillis());
        fromD.set(Calendar.YEAR, year);
        fromD.set(Calendar.MONTH, month);
        fromD.set(Calendar.DAY_OF_MONTH, day);
        return fromD.getTime();
    }

}

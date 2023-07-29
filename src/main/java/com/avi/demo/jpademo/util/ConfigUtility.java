package com.avi.demo.jpademo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author avinash.gurav
 */
@Configuration
@PropertySource("classpath:message.properties")
public class ConfigUtility
{

    @Autowired
    private Environment env;

    public String getProperty(String pPropertyKey)
    {
        return env.getProperty(pPropertyKey);
    }
}

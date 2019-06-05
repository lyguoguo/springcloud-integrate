package com.gly.springcloudlogback.config;

import ch.qos.logback.classic.pattern.CallerDataConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudlogback.config
 * @date:2019/6/5
 **/
public class FileAndLineCallerConverter extends CallerDataConverter {
    private static final String EMPTY_STR = "";

    @Override
    public String convert(ILoggingEvent le) {

        StringBuffer buf = new StringBuffer();

        StackTraceElement[] cda = le.getCallerData();
        if (cda == null || cda.length <= 0) {
            return EMPTY_STR;
        }
        String e = cda[0].toString();
        buf.append(e.substring(e.lastIndexOf(":")+1).replace(")",""));
        return buf.toString();
    }

}

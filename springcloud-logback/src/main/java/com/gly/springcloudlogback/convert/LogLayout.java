package com.gly.springcloudlogback.convert;

import ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;

import java.util.UUID;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudlogback
 * @date:2019/6/5
 **/
public class LogLayout extends LayoutBase<ILoggingEvent> {

    private static final String EMPTY_STR = "";

    private FileAndLineCallerConverter fileAndLineCallerConverter;
    public LogLayout(){
        fileAndLineCallerConverter = new FileAndLineCallerConverter();
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"level\":");
        sb.append("\"").append(event.getLevel()).append("\"");
        sb.append(",\"serviceName\":");
        //todo 服务名 必填
        sb.append("\"").append("mock").append("\"");
        //日志打印所在类的包名+类名
        String packageAndClassName = event.getLoggerName();
        //类名
        String className = packageAndClassName.substring(packageAndClassName .lastIndexOf(".")+1);
        sb.append(",\"fileName\":");
        sb.append("\"").append(className).append(".java").append("\"");
        sb.append(",\"funcName\":");
        sb.append("\"").append(className).append("\"");
        sb.append(",\"className\":");
        sb.append("\"").append(packageAndClassName).append("\"");
        sb.append(",\"threadName\":");
        sb.append("\"").append(event.getThreadName()).append("\"");
        sb.append(",\"lineNumber\":");
        sb.append("\"").append(fileAndLineCallerConverter.convert(event)).append("\"");
        sb.append(",\"traceId\":");
        sb.append("\"").append("test_log").append(UUID.randomUUID()).append("\"");
        sb.append(",\"timeStamp\":");
        sb.append("\"").append(event.getTimeStamp()).append("\"");
        sb.append(",\"content\": ");

        String message = event.getFormattedMessage();
        if (event.getThrowableProxy()!=null){
            ExtendedThrowableProxyConverter throwableConverter = new ExtendedThrowableProxyConverter();
            throwableConverter.start();
            message = event.getFormattedMessage() + "\n" + throwableConverter.convert(event);
            throwableConverter.stop();
        }
        int beginIndex = message.indexOf("{");
        int endIndex = message.lastIndexOf("}")+1;
        if (beginIndex >= 0 && endIndex >= 0) {
            String jsonMsg = message.substring(beginIndex, endIndex);
            sb.append(jsonMsg);
        }else {
            sb.append("\"").append(message).append("\"");
        }
        sb.append("}");
        sb.append(CoreConstants.LINE_SEPARATOR);
        return sb.toString();
    }

}

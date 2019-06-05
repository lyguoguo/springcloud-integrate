package com.gly.springcloudlogback.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudlogback.utils
 * @date:2019/6/5
 **/
public class HttpUtil {

    public static Map<String, Object> parseAttributes(HttpServletRequest request) {
        Objects.requireNonNull(request);
        Map<String, Object> attrs = new HashMap();
        Enumeration names = request.getAttributeNames();

        while(true) {
            String name;
            do {
                if (!names.hasMoreElements()) {
                    return attrs;
                }

                name = (String)names.nextElement();
                if ((request.getAttribute(name) instanceof String || request.getAttribute(name) instanceof Number) && !name.contains(".")) {
                    break;
                }
            } while(!name.contains("ecarx"));

            attrs.put(name, request.getAttribute(name).toString());
        }
    }

    public static Map<String,Object> getRequestHead(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        Enumeration<String> headNames = request.getHeaderNames();
        while(headNames.hasMoreElements()) {
            String headName = headNames.nextElement();
            String headValue = request.getHeader(headName);
            map.put(headName,headValue);
        }
        return map;
    }

    public static String parseClientIp(HttpServletRequest request) {
        return request.getHeader("x-forwarded-for") == null ? request.getRemoteAddr() : request.getHeader("x-forwarded-for");
    }
}

package com.gly.drools.demo.utils;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.drools.utils
 * @date:2019/6/21
 **/
public class KieUtils {
    private static KieContainer kieContainer;

    private static KieSession kieSession;

    public static KieContainer getKieContainer() {
        return kieContainer;
    }

    public static void setKieContainer(KieContainer kieContainer) {
        KieUtils.kieContainer = kieContainer;
        kieSession = kieContainer.newKieSession();
    }

    public static KieSession getKieSession() {
        return kieSession;
    }

    public static void setKieSession(KieSession kieSession) {
        KieUtils.kieSession = kieSession;
    }
}

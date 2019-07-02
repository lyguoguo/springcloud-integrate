package com.gly.drools.web;

import com.gly.drools.common.AddressCheckResult;
import com.gly.drools.model.Address;
import com.gly.drools.service.ReloadDroolsRules;
import com.gly.drools.utils.KieUtils;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.drools.web
 * @date:2019/6/21
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private ReloadDroolsRules rules;

    @RequestMapping("/address")
    public void test(){
        KieSession kieSession = KieUtils.getKieSession();
        Address address = new Address();
        address.setPostcode("994251");

        AddressCheckResult result = new AddressCheckResult();
        kieSession.insert(address);
        kieSession.insert(result);
        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");

        if(result.isPostCodeResult()){
            System.out.println("规则校验通过");
        }
    }

    @RequestMapping("/reload")
    public String reload() throws IOException {
        rules.reload();
        return "ok";
    }
}

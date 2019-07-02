package com.gly.drools.demo.service;

import com.gly.drools.demo.utils.KieUtils;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.drools.service
 * @date:2019/6/21
 **/
@Service
public class ReloadDroolsRules {
    public void reload() throws UnsupportedEncodingException {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write("src/main/resources/rules/address.drl", loadRules());
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new IllegalStateException("### errors ###");
        }

        KieUtils.setKieContainer(kieServices.newKieContainer(getKieServices().getRepository().getDefaultReleaseId()));
        System.out.println("新规则重载成功");
    }

    private String loadRules() {
        // 从数据库加载的规则
        return "package plausibcheck.adress\n" +
                "\n" +
                "import com.gly.drools.demo.model.Address;\n" +
                "import com.gly.drools.demo.common.AddressCheckResult;\n" +
                "\n" +
                "rule \"Postcode should be filled with exactly 5 numbers\"\n" +
                "\n" +
                "    when\n" +
                "        address : Address(postcode != null, postcode matches \"([0-9]{5})\")\n" +
                "        checkResult : AddressCheckResult();\n" +
                "    then\n" +
                "        checkResult.setPostCodeResult(true);\n" +
                "\t\tSystem.out.println(\"规则中打印日志：校验通过!\");\n" +
                "end\n";
//        return "package plausibcheck.adress\n\n import com.neo.drools.model.Address;\n import com.neo.drools.model.fact.AddressCheckResult;\n\n rule \"Postcode 6 numbers\"\n\n    when\n  then\n        System.out.println(\"规则2中打印日志：校验通过!\");\n end";

    }

    private KieServices getKieServices() {
        return KieServices.Factory.get();
    }
}

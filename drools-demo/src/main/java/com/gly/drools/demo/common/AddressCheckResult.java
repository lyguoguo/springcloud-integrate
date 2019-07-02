package com.gly.drools.demo.common;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.drools.common
 * @date:2019/6/21
 **/
public class AddressCheckResult {
    /**
     * true:通过校验；false：未通过校验
     */
    private boolean postCodeResult = false;

    public boolean isPostCodeResult() {
        return postCodeResult;
    }

    public void setPostCodeResult(boolean postCodeResult) {
        this.postCodeResult = postCodeResult;
    }
}

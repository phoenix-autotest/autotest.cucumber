package com.surenpi.autotest.cucumber;

import cucumber.api.java.zh_cn.当;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.suren.autotest.web.framework.selenium.SeleniumEngine;

/**
 * @author suren
 */
@Component
public class BrowserStep
{
    @Autowired
    private SeleniumEngine engine;

    @当("^打开浏览器，输入地址：(.+)$")
    public void openUrl(String url)
    {
        engine.openUrl(url);
    }
}
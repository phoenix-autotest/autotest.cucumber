package com.surenpi.autotest.cucumber;

import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.suren.autotest.web.framework.selenium.SeleniumEngine;

/**
 * @author suren
 */
@Component
public class ElementStep
{
    @Autowired
    private SeleniumEngine engine;
    private WebElement webElement;

    @当("^根据标签ID查找元素(\\w+)$")
    public void findById(String id)
    {
        webElement = engine.getDriver().findElement(By.id(id));
    }

    @那么("^输入(\\w+)$")
    public void click(String text)
    {
        webElement.sendKeys(text);
    }

    @那么("单击")
    public void click()
    {
        webElement.click();
    }
}
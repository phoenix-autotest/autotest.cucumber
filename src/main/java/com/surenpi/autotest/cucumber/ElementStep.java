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

    @当("^根据标签的属性id查找元素(\\w+)$")
    public void findById(String id)
    {
        find(By.id(id));
    }

    @当("^根据标签的属性name查找元素(\\w+)$")
    public void findByName(String name)
    {
        find(By.name(name));
    }

    @当("^根据标签名称查找元素(\\w+)$")
    public void findByTagName(String tagName)
    {
        find(By.tagName(tagName));
    }

    @当("^根据超链接文本查找元素(\\w+)$")
    public void findByLinkText(String linkText)
    {
        find(By.linkText(linkText));
    }

    @当("^根据超链接文本模糊查找元素(\\w+)$")
    public void findByPartialLinkText(String partialLinkText)
    {
        find(By.partialLinkText(partialLinkText));
    }

    private void find(By by)
    {
        webElement = engine.getDriver().findElement(by);
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
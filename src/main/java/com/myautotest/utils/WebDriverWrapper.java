package com.myautotest.utils;

import com.myautotest.screens.MainScreenVk;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverWrapper extends FirefoxDriver {

    protected final Logger log = LoggerFactory.getLogger(MainScreenVk.class);
    //public static final int TIMEOUT_FOR_ACTION_SECONDS = 5;

    public WebDriverWrapper() {
    }
    public void clickByXpath(String xpath) {
       log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
        try {
            waitForElementPresentAndVisible(xpath, PropertiesReader.getInstance().getTimeOut());
        } catch (Exception e) {
            e.printStackTrace();
        }

        findElement(By.xpath(xpath)).click();
    }

    public void clickByXpath(String xpath, int timeout) {
        log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
        waitForElementPresentAndVisible(xpath, timeout);
        waitForElementClickable(xpath, timeout);
        findElement(By.xpath(xpath)).click();
    }

    private void waitForElementPresentAndVisible(String locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(this, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    private void waitForElementClickable(String locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(this, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public String getTextByXpath(String xpath) {
        log.debug(String.format("[ACTION]: Get element text by xpath: '%s'", xpath));
        try {
            waitForElementPresentAndVisible(xpath, PropertiesReader.getInstance().getTimeOut());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = findElement(By.xpath(xpath)).getText();
        log.debug(String.format("[ACTION]: Text in founded element is: '%s'", result));
        return result;
    }

    public void enterTextByXpath(String xpath, String text) {
        log.debug(String.format("[ACTION]: Enter text '%s' in element by xpath: '%s'", text, xpath));
        try {
            waitForElementPresentAndVisible(xpath, PropertiesReader.getInstance().getTimeOut());
        } catch (Exception e) {
            e.printStackTrace();
        }
        findElement(By.xpath(xpath)).sendKeys(text);
    }

    }

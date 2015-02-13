package com.myautotest.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class WebDriverRunner {
    private static final Logger log = LoggerFactory.getLogger(WebDriverRunner.class);
    private static WebDriverWrapper driver;

    WebDriverRunner() {
        try {
            driver = new WebDriverWrapper();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Error while creating Web Driver", e);
        }
    }

    public static WebDriverWrapper getDriver() {
        //если объекта драйвера нет, то создаем его. если есть - возвращаем этим методом существующий
        if (driver == null) {
            new WebDriverRunner();
        }
        return driver;
    }

    public static void stopWebDriver() {
        driver.quit();
    }
}
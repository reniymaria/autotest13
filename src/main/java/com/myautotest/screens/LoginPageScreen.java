package com.myautotest.screens;


public class LoginPageScreen extends MainScreenVk {

    private static final String LOGIN_NAME_XPATH="//div[@class='page_name fl_l ta_l']";

public LoginPageScreen(){}



    public String getLoginName(){


        log.info(String.format("Enter login name XPATH", LOGIN_NAME_XPATH));
        String result = driver.getTextByXpath(LOGIN_NAME_XPATH);
        //String result = driver.findElementByXPath(LOGIN_NAME_XPATH).getText();

        return result;

    }

}

package com.myautotest.suits;


import com.myautotest.screens.LoginPageScreen;
import com.myautotest.screens.VkStartScreen;
import com.myautotest.utils.Photographer;
import com.myautotest.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VkTest {

    public static final String MAIN_PAGE_HEADER_TEXT ="Добро пожаловать";
    public static final String LOGIN_NAME="Vesta Li";


   @Test(description = "Verify text")
    public void checkText(){

       VkStartScreen vkStartScreen = null;
       try {
           vkStartScreen = new VkStartScreen(PropertiesReader.getInstance().getURL());
       } catch (Exception e) {
           e.printStackTrace();
       }
       Assert.assertEquals(vkStartScreen.getMainPageText(), MAIN_PAGE_HEADER_TEXT,
                "Header text not match with expected value");
    }

    @Test(description = "Verify text after login", dependsOnMethods = "checkText")
    public void checkLoginPage(){
        VkStartScreen vkStartScreen = null;
        try {
            vkStartScreen = new VkStartScreen(PropertiesReader.getInstance().getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            vkStartScreen.loginToVkontacte(PropertiesReader.getInstance().getLogin(),PropertiesReader.getInstance().getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoginPageScreen loginPageScreen = new LoginPageScreen();
        Assert.assertEquals(loginPageScreen.getLoginName(), LOGIN_NAME,
                "Header text not match with expected value");
        Photographer.doScreenshot("screenshot");
    }

/*
    @AfterTest
    public void tearDown() {
        //закрываем браузер. в этом случае обращаться к драйверу можно (но не напрямую, как видите)
        WebDriverRunner.stopWebDriver();
    }
    */

}

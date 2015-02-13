package com.myautotest.screens;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VkStartScreen extends MainScreenVk {

    //урл и локаторы
    //private static final String URL = "http://vk.com/";
    private static final String MAIN_PAGE_TEXT_XPATH = "//h1[@id = 'title']";
    private static final String LOGIN_NAME_XPATH="//*[@name='email']";
    //private static final String LOGIN_NAME ="vestaltestacc@yandex.ru";
    private static final String PASSWORD_XPATH ="//*[@name='pass']";
    //private static final String PASSWORD = "q1w2e3r4t5y6";



    public VkStartScreen(String url) {
        log.info(String.format("Open page by link: %s", url));
        driver.get(url);}

    public String getMainPageText () {
            log.info(String.format("Enter XPATH of main page: %s", MAIN_PAGE_TEXT_XPATH));
            //String resultText = driver.findElementByXPath(MAIN_PAGE_TEXT_XPATH).getText();
            String resultText = driver.getTextByXpath(MAIN_PAGE_TEXT_XPATH);
            return resultText;
        }

    private VkStartScreen enterLogin(String login) {
        log.info(String.format("Enter login: %s", LOGIN_NAME_XPATH));
        driver.enterTextByXpath(LOGIN_NAME_XPATH,login);
        //WebElement elementLogin = driver.findElement(By.xpath(LOGIN_NAME_XPATH)); // Находим по имени поле для ввода
        //elementLogin.sendKeys(LOGIN_NAME); // Вводим логин
        return this;
    }

    private VkStartScreen enterPassword(String password){
        log.info(String.format("Enter password: %s", PASSWORD_XPATH));
        //driver.enterTextByXpath(PASSWORD_XPATH,PASSWORD);
        WebElement elementPass = driver.findElement(By.xpath(PASSWORD_XPATH));
        elementPass.sendKeys(password); //пароль
        elementPass.submit(); // Отправляем форму в которой находится элемент
        return this;
    }

   public LoginPageScreen loginToVkontacte(String login, String password){
       enterLogin(login);
       enterPassword(password);
    return new LoginPageScreen();
}

}




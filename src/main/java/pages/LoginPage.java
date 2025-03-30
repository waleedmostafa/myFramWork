package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
   // private final By nameFiled = By.xpath("//input[@name='name']");
   // private final By emailFiled = By.xpath("//input[@data-qa='signup-email']");
   // private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private final By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private final By LoginPassword = By.xpath("//input[@type='password']");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By validationMessage = By.xpath("//p[@style='color: red;']");
/*
    public void insertName(String name,int time){
        sendKeys(nameFiled,name,time);
    }
    public void insertEmail(String text,int time){
        sendKeys(emailFiled,text,time);
    }
    public void clickOnSignUpButton(){
        click(signUpButton);

    }
    */


    public void insertLoginEmail(String text,int time){
        sendKeys(loginEmail,text,time);
    }
    public void insertPassword(String password,int time) {
        sendKeys(LoginPassword, password,time);
    }

    public void clickOnSubmitButton(int time){
        click(submitButton,time);
    }

    public String getValidationMessage(int time){
      return getText(validationMessage,time);

    }
}

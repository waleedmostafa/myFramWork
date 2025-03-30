package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By loginLink = By.xpath("//a[@href='/login']");

    public LoginPage clickOnLoginLink(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
}

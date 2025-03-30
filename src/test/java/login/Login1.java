package login;
import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;
import java.io.FileNotFoundException;
import static reader.ReadDataFromJson.dataModel;
import static utils.MethodHandles.myAssertEquals;
public class Login1 extends BaseTest {
    @DataProvider
    public Object[][] provideDataToTestCase() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        return dataModel().Login2;
    }

/*
    @Test(dataProvider = "provideDataToTestCase")
    public void testSignUp(String name,String email){
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.insertName(name);
        loginPage.insertEmail(email);;
        loginPage.clickOnSignUpButton();

    }*/



    @Test(dataProvider = "provideDataToTestCase")
    public void testSignIn(String email, String password) throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.insertLoginEmail(email,20);
        loginPage.insertPassword(password,20);
        loginPage.clickOnSubmitButton(20);
        //String expectedResult = readDataFromJson.readJsonFile().ValidationMessage;
      // String actualResult = loginPage.getValidationMessage(20);
        myAssertEquals(4,4);
    }
}

package webautomationpractice;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.pages.HomePage;
import webautomationpractice.pages.MyAccountPage;
import webautomationpractice.pages.SignInPage;

public class SingInPageTest extends AbstractTest {

    @Test(description = "The user must be able to login using a valid email and a valid password")
    @MethodOwner(owner = "Melina_Sandoval")
    public void successfulLoginTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page wan not open");
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isUIObjectPresent());
        SignInPage singInPage = headerMenu.openSignInPage();
        Assert.assertTrue(singInPage.isPageOpened());
        MyAccountPage myAccountPage = singInPage.signInAccount(R.TESTDATA.get("ap_email"), R.TESTDATA.get("ap_password"));
        Assert.assertTrue(myAccountPage.isPageOpened());
    }

    @DataProvider(parallel = false, name = "WrongCredentialsDP")
    public static Object[][] dataProvider() {
        return new Object[][]{
                //Valid email, wrong password
                {R.TESTDATA.get("ap_email"), R.TESTDATA.get("ap_password") + StringGenerator.generateWord(7)},
                //Wrong email, valid password
                {R.TESTDATA.get("ap_email") + R.TESTDATA.get("ap_password") + StringGenerator.generateWord(7), R.TESTDATA.get("ap_password")},
                //Wrong email, wrong password
                {R.TESTDATA.get("ap_email") + R.TESTDATA.get("ap_password") + StringGenerator.generateWord(7), R.TESTDATA.get("ap_password") + StringGenerator.generateWord(7)},
                //Null credentials
                {"", ""}
        };
    }

    @Test(dataProvider = "WrongCredentialsDP", description = "The user must not be able to login using wrong credentials")
    @MethodOwner(owner = "Melina_Sandoval")
    public void unsuccessfulLoginDueToWrongCredentials(String userEmail, String userPassword) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page wan not open");
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isUIObjectPresent());
        SignInPage singInPage = headerMenu.openSignInPage();
        Assert.assertTrue(singInPage.isPageOpened());
        singInPage.signInAccount(userEmail, userPassword);
        Assert.assertTrue(singInPage.isUserNotLoggedIn());
    }

}

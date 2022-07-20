package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {
    @FindBy(css = "input#email")
    private ExtendedWebElement emailInputField;

    @FindBy(css = "input#passwd")
    private ExtendedWebElement passwordInputField;

    @FindBy(css = "button#SubmitLogin")
    private ExtendedWebElement signInButton;

    @FindBy(css = ".alert")
    private ExtendedWebElement wrongCredentialsAlertSingInAcc;

    public SignInPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php?controller=authentication&back=my-account");
    }

    public MyAccountPage signInAccount(String email, String password) {
        emailInputField.type(email);
        passwordInputField.type(password);
        signInButton.click();
        return new MyAccountPage(getDriver());
    }

    public boolean isUserNotLoggedIn() {
        return wrongCredentialsAlertSingInAcc.isElementPresent();
    }

}

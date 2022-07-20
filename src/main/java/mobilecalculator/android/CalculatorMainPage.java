package mobilecalculator.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import mobilecalculator.common.CalculatorMainPageBase;
import mobilecalculator.common.HistoryPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CalculatorMainPageBase.class)
public class CalculatorMainPage extends CalculatorMainPageBase {

    @FindBy(xpath = "//*[@content-desc='%d']")
    private ExtendedWebElement digitButton;

    @FindBy(xpath = "//*[@content-desc='point']")
    private ExtendedWebElement decimalPointButton;

    @FindBy(xpath = "//*[@content-desc='delete']")
    private ExtendedWebElement deleteButton;

    @FindBy(xpath = "//*[@content-desc='equals']")
    private ExtendedWebElement equalsButton;

    @FindBy(xpath = "//*[@content-desc='left or right parenthesis']")
    private ExtendedWebElement parenthesisButton;
    @FindBy(xpath = "//*[@content-desc='clear']")
    private ExtendedWebElement clearResultFieldButton;

    @FindBy(xpath = "//*[contains(@resource-id,'op_%s')]")
    private ExtendedWebElement basicOperationButton;

    @FindBy(xpath = "//*[contains(@resource-id,'collapse_expand')]")
    private ExtendedWebElement showOrHideFunctionsDropdownButton;

    @FindBy(xpath = "//*[@content-desc='square root']")
    private ExtendedWebElement squareRootButton;

    @FindBy(xpath = "//*[contains(@resource-id,'fun_%s')]")
    private ExtendedWebElement functionButton;

    @FindBy(xpath = "//*[@content-desc='More options']")
    private ExtendedWebElement moreOptionsKebabMenuButton;

    @FindBy(xpath = "//*[contains(@resource-id,'title')][1]")
    private ExtendedWebElement historyButton;

    @FindBy(xpath = "//*[contains(@resource-id,'display')]")
    private Display display;

    public CalculatorMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnDigitButtonByNumberValue(Numbers number) {
        digitButton.format(number.getIntValue()).click();
    }

    @Override
    public void clickOnBasicOperationButton(BasicOperations basicOperations) {
        basicOperationButton.format(basicOperations.getOperation()).click();
    }

    @Override
    public void clickOnClearResultFieldButton() {
        clearResultFieldButton.click();
    }

    @Override
    public void clickOnKebabMenu() {
        moreOptionsKebabMenuButton.click();
    }

    @Override
    public void insertLeftOrRightParenthesis() {
        parenthesisButton.click();
    }

    @Override
    public void clickOnEqualButton() {
        equalsButton.click();
    }

    @Override
    public void showMoreFunctionsDropdownMenu() {
        showOrHideFunctionsDropdownButton.click();
    }

    @Override
    public void clickOnFunctionButton(Functions function) {
        functionButton.format(function.getName()).click();
    }

    @Override
    public void clickOnSquareRootButton() {
        squareRootButton.click();
    }

    @Override
    public HistoryPageBase openHistoryPage() {
        historyButton.click();
        return initPage(HistoryPageBase.class);
    }

    @Override
    public int getZeroButtonLocation() {
        return digitButton.format(0).getLocation().getY();
    }

    @Override
    public Display getDisplay() {
        return display;
    }

    @Override
    public boolean isOpened() {
        return equalsButton.isElementPresent();
    }
}

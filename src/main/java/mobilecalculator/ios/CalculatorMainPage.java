package mobilecalculator.ios;

import com.qaprosoft.carina.core.foundation.exception.NotSupportedOperationException;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import mobilecalculator.android.Display;
import mobilecalculator.common.CalculatorMainPageBase;
import mobilecalculator.common.HistoryPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CalculatorMainPageBase.class)
public class CalculatorMainPage extends CalculatorMainPageBase {

    public CalculatorMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnBasicOperationButton(BasicOperations basicOperations) {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public void clickOnFunctionButton(Functions function) {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public void clickOnSquareRootButton() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public void clickOnClearResultFieldButton() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public void clickOnDigitButtonByNumberValue(Numbers number) {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }


    @Override
    public void clickOnKebabMenu() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public void insertLeftOrRightParenthesis() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public void clickOnEqualButton() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public HistoryPageBase openHistoryPage() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);

    }

    @Override
    public int getZeroButtonLocation() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);

    }

    @Override
    public Display getDisplay() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public void showMoreFunctionsDropdownMenu() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

}

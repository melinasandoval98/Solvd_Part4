package mobilecalculator;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import mobilecalculator.android.Display;
import mobilecalculator.common.CalculatorMainPageBase;
import mobilecalculator.common.DisplayBase;
import mobilecalculator.common.HistoryPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static mobilecalculator.common.CalculatorMainPageBase.BasicOperations.*;
import static mobilecalculator.common.CalculatorMainPageBase.Functions.TAN;
import static mobilecalculator.common.CalculatorMainPageBase.Numbers.*;

public class CalculatorPageTest extends AbstractTest {

    @Test(description = "When entering undefined operations in the field of real numbers, the user should receive an error alert")
    @MethodOwner(owner = "Melina_Sandoval")
    public void unsupportedOperationsTest() {
        CalculatorMainPageBase calculatorMainPage = initPage(CalculatorMainPageBase.class);
        Assert.assertTrue(calculatorMainPage.isOpened());
        //Division by zero. Assert that an error appears in the result preview field
        calculatorMainPage.clickOnDigitButtonByNumberValue(TWO);
        calculatorMainPage.clickOnBasicOperationButton(DIVISION);
        calculatorMainPage.clickOnDigitButtonByNumberValue(ZERO);
        calculatorMainPage.clickOnEqualButton();
        Display display = calculatorMainPage.getDisplay();
        Assert.assertEquals(display.readResultPreview(), "Can't divide by 0");
        //Clear the operation field
        calculatorMainPage.clickOnClearResultFieldButton();
        //Out of domain operation: tan(90°). Assert the result preview field shows an out of domain error
        calculatorMainPage.showMoreFunctionsDropdownMenu();
        calculatorMainPage.clickOnFunctionButton(TAN);
        calculatorMainPage.clickOnDigitButtonByNumberValue(NINE);
        calculatorMainPage.clickOnDigitButtonByNumberValue(ZERO);
        calculatorMainPage.clickOnEqualButton();
        Assert.assertEquals(display.readResultPreview(), "Domain error");
        //Clear the operation field
        calculatorMainPage.clickOnClearResultFieldButton();
        //Non-real result: √-1. Assert an error message is shown in the result preview field
        calculatorMainPage.clickOnSquareRootButton();
        calculatorMainPage.clickOnBasicOperationButton(SUBTRACTION);
        calculatorMainPage.clickOnDigitButtonByNumberValue(ONE);
        calculatorMainPage.clickOnEqualButton();
        Assert.assertEquals(display.readResultPreview(), "Keep it real");
        //Clear the operation field
        calculatorMainPage.clickOnClearResultFieldButton();
        //Type an invalid operation format: 8(. Assert an error message is shown in the result preview field
        calculatorMainPage.clickOnDigitButtonByNumberValue(EIGHT);
        calculatorMainPage.insertLeftOrRightParenthesis();
        calculatorMainPage.clickOnEqualButton();
        Assert.assertEquals(display.readResultPreview(), "Format error");
    }

    @Test(description = "When entering undefined operations in the field of real numbers, the user should receive an error alert")
    @MethodOwner(owner = "Melina_Sandoval")
    public void calculatorHistoryTest() {
        CalculatorMainPageBase calculatorMainPage = initPage(CalculatorMainPageBase.class);
        Assert.assertTrue(calculatorMainPage.isOpened());
        DisplayBase display = calculatorMainPage.getDisplay();
        display.assertUIObjectPresent();
        //Perform a simple operation (75*36) and assert the result equals to 2700
        calculatorMainPage.clickOnDigitButtonByNumberValue(SEVEN);
        calculatorMainPage.clickOnDigitButtonByNumberValue(FIVE);
        calculatorMainPage.clickOnBasicOperationButton(MULTIPLICATION);
        calculatorMainPage.clickOnDigitButtonByNumberValue(THREE);
        calculatorMainPage.clickOnDigitButtonByNumberValue(SIX);
        calculatorMainPage.clickOnEqualButton();
        Assert.assertEquals(Integer.valueOf(display.readFinalResul()), Integer.valueOf(2700));
        //Clear the result field
        calculatorMainPage.clickOnClearResultFieldButton();
        //Open Kebab menu and go to History
        calculatorMainPage.clickOnKebabMenu();
        HistoryPageBase historyPage = calculatorMainPage.openHistoryPage();
        Assert.assertTrue(historyPage.isOpened());
        //Click on the result in history and comeback to the main page
        historyPage.clickOnResultInHistory(1);
        historyPage.navigateBack();
        Assert.assertTrue(calculatorMainPage.isOpened());
        //Perform a simple operation using the previous result and assert the result is the expected one
        calculatorMainPage.clickOnBasicOperationButton(DIVISION);
        calculatorMainPage.clickOnDigitButtonByNumberValue(THREE);
        calculatorMainPage.clickOnDigitButtonByNumberValue(SIX);
        calculatorMainPage.clickOnEqualButton();
        Assert.assertEquals(Integer.valueOf(display.readFinalResul()), Integer.valueOf(75));
    }

}

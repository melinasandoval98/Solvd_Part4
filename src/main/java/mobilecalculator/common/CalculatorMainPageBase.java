package mobilecalculator.common;

import com.qaprosoft.carina.core.foundation.exception.NotSupportedOperationException;
import mobilecalculator.android.Display;
import org.openqa.selenium.WebDriver;

public abstract class CalculatorMainPageBase extends BasicCalculatorPageBase {
    public enum Numbers {
        ZERO(0), ONE(1), TWO(2), THREE(3), FOR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

        private int intValue;

        Numbers(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }
    }

    public enum BasicOperations {
        SUM("add"), SUBTRACTION("sub"), DIVISION("div"), MULTIPLICATION("mul"), PERCENTAGE("pct");
        private String operation;

        BasicOperations(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }

    public enum Functions {
        TAN("tan"), COS("cos"), SIN("sin");
        private String name;

        Functions(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public CalculatorMainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnBasicOperationButton(BasicOperations basicOperations);

    public abstract void clickOnClearResultFieldButton();

    public abstract void clickOnDigitButtonByNumberValue(Numbers number);

    public abstract void clickOnKebabMenu();

    public abstract void insertLeftOrRightParenthesis();

    public abstract void clickOnEqualButton();

    public abstract void showMoreFunctionsDropdownMenu();

    public abstract void clickOnFunctionButton(Functions function);

    public abstract void clickOnSquareRootButton();

    public abstract HistoryPageBase openHistoryPage();

    public abstract int getZeroButtonLocation();

    public abstract Display getDisplay();

    @Override
    public boolean isOpened() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_IS_OPENED);
    }


}

package mobilecalculator.common;

import com.qaprosoft.carina.core.foundation.exception.NotSupportedOperationException;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BasicCalculatorPageBase extends AbstractPage {
    public BasicCalculatorPageBase(WebDriver driver) {
        super(driver);
    }

    protected static final String NOT_IMPLEMENTED_FOR_IOS = "Method is not implemented on iOS";

    protected static final String NOT_IMPLEMENTED_IS_OPENED = "Method isOpened is not implemented";

    protected static final int IS_OPENED_TIMEOUT = 20;

    public boolean isOpened() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_IS_OPENED);
    }

    public boolean isOpened(int timeout) {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_IS_OPENED);
    }
}

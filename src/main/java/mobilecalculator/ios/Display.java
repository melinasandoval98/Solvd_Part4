package mobilecalculator.ios;

import com.qaprosoft.carina.core.foundation.exception.NotSupportedOperationException;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import mobilecalculator.common.DisplayBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DisplayBase.class)
public class Display extends DisplayBase {
    public Display(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String readResultPreview() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);

    }

    @Override
    public String readFinalResul() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);

    }

    @Override
    public String readFormula() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public ExtendedWebElement getDragHandler() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);

    }
}

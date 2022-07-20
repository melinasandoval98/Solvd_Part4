package mobilecalculator.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class DisplayBase extends BasicCalculatorPageBase {
    public DisplayBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract String readResultPreview();

    public abstract String readFinalResul();


    public abstract String readFormula();

    public abstract ExtendedWebElement getDragHandler();
}

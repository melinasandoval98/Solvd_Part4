package mobilecalculator.common;

import mobilecalculator.android.Display;
import org.openqa.selenium.WebDriver;

public abstract class HistoryPageBase extends BasicCalculatorPageBase {

    public HistoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnResultInHistory(int index);

    public abstract Display getDisplay();
}

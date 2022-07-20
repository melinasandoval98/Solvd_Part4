package mobilecalculator.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import mobilecalculator.common.HistoryPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HistoryPageBase.class)
public class HistoryPage extends HistoryPageBase {
    @FindBy(xpath = "//*[contains(@resource-id,'id/history_toolbar')]")
    private ExtendedWebElement historyPageToolBar;

    @FindBy(xpath = "//*[contains(@resource-id, 'history_result')]")
    private List<ExtendedWebElement> results;

    @FindBy(xpath = "//*[contains(@resource-id,'display')]")
    private Display display;

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnResultInHistory(int index) {
        results.get(index - 1).click();
    }

    @Override
    public Display getDisplay() {
        return display;
    }

    @Override
    public boolean isOpened() {
        return historyPageToolBar.isElementPresent();
    }
}

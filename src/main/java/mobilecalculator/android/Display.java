package mobilecalculator.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import mobilecalculator.common.DisplayBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DisplayBase.class)
public class Display extends DisplayBase {
    @FindBy(xpath = "//*[contains(@resource-id,'result_preview')]")
    private ExtendedWebElement resultPreviewField;

    @FindBy(xpath = "//*[contains(@resource-id, 'id/result_final')]")
    private ExtendedWebElement finalResult;

    @FindBy(xpath = "//*[contains(@resource-id, 'id/formula')]")
    private ExtendedWebElement formula;

    @FindBy(xpath = "//*[contains(@resource-id, 'drag_handle_view')]")
    private ExtendedWebElement dragHandler;

    public Display(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String readResultPreview() {
        return resultPreviewField.getText();
    }

    @Override
    public String readFinalResul() {
        return finalResult.getText();
    }

    @Override
    public String readFormula() {
        return formula.getText();
    }

    @Override
    public ExtendedWebElement getDragHandler() {
        return dragHandler;
    }

    @Override
    public boolean isUIObjectPresent() {
        return resultPreviewField.isElementPresent();
    }
}

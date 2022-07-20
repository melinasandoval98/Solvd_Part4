package mobilecalculator.ios;

import com.qaprosoft.carina.core.foundation.exception.NotSupportedOperationException;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import mobilecalculator.android.Display;
import mobilecalculator.common.HistoryPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HistoryPageBase.class)
public class HistoryPage extends HistoryPageBase {
    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnResultInHistory(int index) {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }

    @Override
    public Display getDisplay() {
        throw new NotSupportedOperationException(NOT_IMPLEMENTED_FOR_IOS);
    }
}

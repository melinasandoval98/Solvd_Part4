package webautomationpractice;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.components.LeftColumn;
import webautomationpractice.pages.HomePage;
import webautomationpractice.pages.WomenProductCategoryPage;

public class WomenCategoryPageTest extends AbstractTest implements IAbstractTest {

    @Test(dataProvider = "DataProvider", description = "Checking the product filtering functionality in a product category page, regarding the use of checkboxes")
    @MethodOwner(owner = "Melina_Sandoval")
    @XlsDataSourceParameters(path = "xls/dplayeredfilters.xlsx", sheet = "LayeredFiltersDP", dsUid = "TUID", dsArgs = "layeredFilter, numberOfCB")
    public void test(String layeredFilter, String numberOfCB) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        headerMenu.assertUIObjectPresent();
        WomenProductCategoryPage womenProductCategoryPage = headerMenu.openWomenCategoryPage();
        womenProductCategoryPage.assertPageOpened();
        LeftColumn leftColumn = womenProductCategoryPage.getLeftColumn();
        leftColumn.assertUIObjectPresent();
        for (int i = 0; i < Integer.valueOf(numberOfCB); i++) {
            leftColumn.getLayeredFilterCheckbox(layeredFilter, i + 1).check();
            Assert.assertTrue(leftColumn.getLayeredFilterCheckbox(layeredFilter, i + 1).isChecked(), "The checkbox was not clicked");
        }
        Assert.assertTrue(leftColumn.isEnabledFiltersBlockPresent(), "The filters were not implemented");
        for (int j = 0; j < Integer.valueOf(numberOfCB); j++) {
            leftColumn.getLayeredFilterCheckbox(layeredFilter, j + 1).uncheck();
            Assert.assertFalse(leftColumn.getLayeredFilterCheckbox(layeredFilter, j + 1).isChecked(), "The checkbox was not unchecked");
        }
    }

    @Test(description = "The user must be able to set a price range filter using the slider under the Price section")
    @MethodOwner(owner = "Melina_Sandoval")
    public void priceFilterTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        headerMenu.assertUIObjectPresent();
        WomenProductCategoryPage womenProductCategoryPage = headerMenu.openWomenCategoryPage();
        womenProductCategoryPage.assertPageOpened();
        LeftColumn leftColumn = womenProductCategoryPage.getLeftColumn();
        leftColumn.assertUIObjectPresent();
        //Move left slider to the max right position. The left and right limits of the price range must be equal to the max price allowed
        leftColumn.slideLeftPriceSliderFilter(leftColumn.getInitialPositionOfRightSlider());
        Assert.assertEquals(leftColumn.getPriceRangeFilter().get(1), leftColumn.getPriceRangeFilter().get(0));
        Assert.assertTrue(leftColumn.isEnabledFiltersBlockPresent(), "The price filter was not implemented");
        //Move left slider back to its initial position
        leftColumn.slideLeftPriceSliderFilter(leftColumn.getInitialPositionOfLeftSlider());
        //Move right slider to the min left position. The left and right limits of the price range must be equal to the min price allowed
        leftColumn.slideRightPriceSliderFilter(leftColumn.getInitialPositionOfLeftSlider());
        Assert.assertEquals(leftColumn.getPriceRangeFilter().get(0), leftColumn.getPriceRangeFilter().get(1));
        //Move right slider back to its initial position
        leftColumn.slideRightPriceSliderFilter(leftColumn.getInitialPositionOfRightSlider());
        //Move both sliders to the center position. The left and right limits of the price range must coincide and be equal to $34.50
        leftColumn.slideLeftPriceSliderFilter(Integer.divideUnsigned(leftColumn.getInitialPositionOfRightSlider() - leftColumn.getInitialPositionOfLeftSlider(), 2));
        leftColumn.slideRightPriceSliderFilter(Integer.divideUnsigned(leftColumn.getInitialPositionOfRightSlider() - leftColumn.getInitialPositionOfLeftSlider(), 2));
        Assert.assertEquals(leftColumn.getPriceRangeFilter().get(1), leftColumn.getPriceRangeFilter().get(0));
    }
}

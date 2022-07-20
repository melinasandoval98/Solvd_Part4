package webautomationpractice.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductAddedToCart extends AbstractUIObject {
    @FindBy(css = ".cart-info .product-name a")
    private ExtendedWebElement productName;

    @FindBy(css = ".cart-info .quantity")
    private ExtendedWebElement productQuantity;

    @FindBy(xpath = "//a[contains(@class,'remove_link')]")
    private ExtendedWebElement removeFromCartButton;


    public ProductAddedToCart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductInCartName() {
        return productName.getAttribute("title");
    }

    public int getProductInCartQuantity() {
        return Integer.parseInt(productQuantity.getText());
    }

    public void removeProductFromCartDropdown() {
        removeFromCartButton.click();
    }

}

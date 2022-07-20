package webautomationpractice.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductContainer extends AbstractUIObject {
    @FindBy(css = ".product-image-container .product_img_link")
    private ExtendedWebElement productImageLink;

    @FindBy(css = ".product-container .product-name")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//span[text()='Add to cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = ".//span[text()='More']")
    private ExtendedWebElement moreButton;

    @FindBy(css = ".price.product-price")
    private ExtendedWebElement productPrice;

//    public enum ProductTabsInHomePage {
//        POPULAR("homefeatured"), BEST_SELLERS("blockbestsellers");
//        private String tabID;
//
//        ProductTabsInHomePage(String tabID) {
//            this.tabID = tabID;
//        }
//
//    }

    public ProductContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductAddedToCartPopUp addToCart() {
        addToCartButton.click();
        return new ProductAddedToCartPopUp(getDriver(), getDriver());
    }

    public String getProductName() {
        return productName.getText();
    }

    public void hoverProduct() {
        productImageLink.hover();
    }

}

package webautomationpractice;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.components.ProductAddedToCartPopUp;
import webautomationpractice.components.ProductContainer;
import webautomationpractice.pages.HomePage;

public class HomePageTest extends AbstractTest {

    @Test(description = "Add products to cart and the remove them flow")
    @MethodOwner(owner = "Melina_Sandoval")
    public void AddProductsToCartAndThenRemoveThemTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductContainer firstProduct = homePage.getProductsContainersUnderPopularTab().get(0);
        int desiredProductQuantity = 2;
        for (int i = 0; i < desiredProductQuantity; i++) {
            firstProduct.hoverProduct();
            ProductAddedToCartPopUp productAddedToCartPopUp = firstProduct.addToCart();
            Assert.assertTrue(productAddedToCartPopUp.isUIObjectPresent());
            productAddedToCartPopUp.clickOnContinueShoppingButton();
        }
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isUIObjectPresent());
        headerMenu.displayProductsInCartDropdown();
        Assert.assertTrue(headerMenu.getProductsInCartDropdown().size() == 1);
        Assert.assertTrue(headerMenu.getProductsInCartDropdown().get(0).getProductInCartName().equals(firstProduct.getProductName()), "The product in cart's name does not coincide with the name of the product added");
        Assert.assertTrue(headerMenu.getProductsInCartDropdown().get(0).getProductInCartQuantity() == desiredProductQuantity, "The quantity of products in cart does not coincide with the number of time te add to cart button was clicked");
        headerMenu.getProductsInCartDropdown().get(0).removeProductFromCartDropdown();
        Assert.assertTrue(headerMenu.isCartEmpty(), "The shopping cart is not empty");
    }

}

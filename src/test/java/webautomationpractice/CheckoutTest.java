package webautomationpractice;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.components.ProductAddedToCartPopUp;
import webautomationpractice.components.ProductContainer;
import webautomationpractice.pages.*;

public class CheckoutTest extends AbstractTest {
    @Test(description = "The user should be required to log in or sign in before proceeding to the Address page. Once the user is logged in, the Sign in page should not be accessible")
    @MethodOwner(owner = "Melina_Sandoval")
    public void checkoutProcessWithoutBeingLoggedInTest() {
        //Open home page and assert it's open
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        //Select the Best Sellers tab and add the 4th product of the list to the cart and assert the product added to cart pop-up appears
        homePage.clickBestsellerTabButton();
        ProductContainer productContainer = homePage.getProductsContainersUnderBestSellersTab().get(3);
        productContainer.assertUIObjectPresent();
        productContainer.hoverProduct();
        ProductAddedToCartPopUp productAddedToCartPopUp = productContainer.addToCart();
        Assert.assertTrue(productAddedToCartPopUp.isUIObjectPresent());
        //Go to the Shopping-Cart Summary page and assert it's open
        ShoppingCartSummaryPage shoppingCartSummaryPage = productAddedToCartPopUp.clickOnProceedToCheckOutButton();
        shoppingCartSummaryPage.assertPageOpened();
        //go to the Authentication page and assert it's open
        AuthenticationPage authenticationPage = (AuthenticationPage) shoppingCartSummaryPage.goToNextOrderStepPageOnCheckout();
        authenticationPage.assertPageOpened();
        //Log in and go to Address page. Asser it's open
        AddressPage addressPage = authenticationPage.singInAccount(R.TESTDATA.get("ap_email"), R.TESTDATA.get("ap_password"));
        addressPage.assertPageOpened();
        //Try to go back to the Authentication page. Assert it redirects the user the address page
        AddressPage newAddressPage = addressPage.clickOnSingInTabButton();
        newAddressPage.assertPageOpened();
        //Go to the Shipping page. Assert it's open
        ShippingPage shippingPage = addressPage.goToNextOrderStepPageOnCheckout();
        shippingPage.assertPageOpened();
        //Go to the Payment page. Assert it's open
        PaymentPage paymentPage = shippingPage.goToNextOrderStepPageOnCheckout();
        paymentPage.assertPageOpened();
        //Choose the Pay with bank wire option and go to the Bank Wire Payment pag. Asser it's open
        BankWirePaymentPage bankWirePaymentPage = paymentPage.choosePayWithBankWireOption();
        bankWirePaymentPage.assertPageOpened();
        //Go to the Order Confirmation page and assert it's open. End.
        OrderConfirmationPage orderConfirmationPage = bankWirePaymentPage.clickOnConfirmOrderButton();
        orderConfirmationPage.assertPageOpened();
    }

    @Test(description = "If the user is logged in, the Sign in page should not be accessible and they should be directed to the Address page from the Shopping-Cart Summary Page by clicking Proceed to checkout")
    @MethodOwner(owner = "Melina_Sandoval")
    public void checkoutProcessBeingLoggedInTest() {
        //Open Home Page and assert it's open
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        //Go to Sign in page and asser it's open
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isUIObjectPresent());
        SignInPage singInPage = headerMenu.openSignInPage();
        Assert.assertTrue(singInPage.isPageOpened());
        //Log in and assert the the My account page is open
        MyAccountPage myAccountPage = singInPage.signInAccount(R.TESTDATA.get("ap_email"), R.TESTDATA.get("ap_password"));
        Assert.assertTrue(myAccountPage.isPageOpened());
        //Go to Home Page
        HomePage newHomePage = myAccountPage.getHeaderMenu().openHomePage();
        newHomePage.assertPageOpened();
        newHomePage.clickBestsellerTabButton();
        //Select the Best Sellers tab and add the 4th product of the list to the cart and assert the product added to cart pop-up appears
        ProductContainer productContainer = homePage.getProductsContainersUnderBestSellersTab().get(3);
        productContainer.assertUIObjectPresent();
        productContainer.hoverProduct();
        ProductAddedToCartPopUp productAddedToCartPopUp = productContainer.addToCart();
        Assert.assertTrue(productAddedToCartPopUp.isUIObjectPresent());
        //Go to the Shopping-Cart Summary page and assert it's open
        ShoppingCartSummaryPage shoppingCartSummaryPage = productAddedToCartPopUp.clickOnProceedToCheckOutButton();
        shoppingCartSummaryPage.assertPageOpened();
        //Go to the Address page and assert it's open
        AddressPage addressPage = (AddressPage) shoppingCartSummaryPage.goToNextOrderStepPageOnCheckout();
        addressPage.assertPageOpened();
        //Try to go back to the Authentication page. Assert it redirects the user the address page
        AddressPage newAddressPage = addressPage.clickOnSingInTabButton();
        newAddressPage.assertPageOpened();
        //Go to the Shipping page. Assert it's open
        ShippingPage shippingPage = newAddressPage.goToNextOrderStepPageOnCheckout();
        shippingPage.assertPageOpened();
        //Go to the Payment page. Assert it's open
        PaymentPage paymentPage = shippingPage.goToNextOrderStepPageOnCheckout();
        paymentPage.assertPageOpened();
        //Choose the Pay with bank wire option and go to the Bank Wire Payment pag. Asser it's open
        BankWirePaymentPage bankWirePaymentPage = paymentPage.choosePayWithBankWireOption();
        bankWirePaymentPage.assertPageOpened();
        //Go to the Order Confirmation page and assert it's open. End.
        OrderConfirmationPage orderConfirmationPage = bankWirePaymentPage.clickOnConfirmOrderButton();
        orderConfirmationPage.assertPageOpened();
    }
}

package webautomationpractice.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeftColumn extends AbstractUIObject {
    @FindBy(xpath = ".//span[contains(text(),'%s')]/../../ul/li[%d]/div/span/input[@type='checkbox']")
    private ExtendedWebElement layeredFilterCheckbox;

    @FindBy(xpath = ".//span[text()='Color']/../../ul/li/input[contains(@class,'color-option')]")
    private ExtendedWebElement colorOptionButtons;

    @FindBy(id = "enabled_filters")
    private ExtendedWebElement enabledFiltersBlock;

    @FindBy(css = "#enabled_filters li")
    private List<ExtendedWebElement> enabledFilters;

    @FindBy(css = ".ui-slider-handle")
    private List<ExtendedWebElement> priceSliders;

    @FindBy(id = "layered_price_range")
    private ExtendedWebElement priceRange;

    public List<String> getPriceRangeFilter() {
//        List<Double> range = new ArrayList<>();
//        Arrays.stream(priceRange.getText().split(" - ", -1)).collect(Collectors.toList()).forEach(limit -> {
//            List<Character> chars = limit.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
//            for (char character : chars) {
//                if (" ".equals(character) || "$".equals(character)) {
//                    chars.remove(character);
//                }
//            }
//            range.add(Double.valueOf(chars.toString()));
//        });
        return Arrays.stream(priceRange.getText().split(" - ", -1)).collect(Collectors.toList());
    }

    private int initialPositionOfLeftSlider = priceSliders.get(0).getLocation().getX();
    private int initialPositionOfRightSlider = priceSliders.get(1).getLocation().getX();


    public LeftColumn(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public int getInitialPositionOfLeftSlider() {
        return initialPositionOfLeftSlider;
    }

    public int getInitialPositionOfRightSlider() {
        return initialPositionOfRightSlider;
    }

    public ExtendedWebElement getLayeredFilterCheckbox(String layeredFilter, int index) {
        return layeredFilterCheckbox.format(layeredFilter, index);
    }

    public List<ExtendedWebElement> getEnabledFilters() {
        return enabledFilters;
    }


    public void slideLeftPriceSliderFilter(int finalX) {
        slide(priceSliders.get(0), finalX, 0);
    }

    public void slideRightPriceSliderFilter(int finalX) {
        slide(priceSliders.get(1), finalX, 0);
    }

    public boolean isEnabledFiltersBlockPresent() {
        return enabledFiltersBlock.isElementPresent(SHORT_TIMEOUT);
    }

}

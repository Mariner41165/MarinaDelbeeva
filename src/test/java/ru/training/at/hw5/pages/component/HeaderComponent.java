package ru.training.at.hw5.pages.component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractComponent {

    @FindBy (xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']")
    private List<WebElement> itemsOnHeader;
    @FindBy (className = "dropdown-toggle")
    WebElement serviceItem;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public List<String> itemsOnHeaderToStrings() {
        return itemsOnHeader.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectCategoryInServiceItem(String categoryName) {
        new Actions(driver).moveToElement(serviceItem).click().perform();
        Optional<WebElement> category = itemsOnHeader
            .stream()
            .filter(categoryItem -> categoryItem.getText().equalsIgnoreCase(categoryName))
            .findFirst();

        category.ifPresent(WebElement::click);
    }
}

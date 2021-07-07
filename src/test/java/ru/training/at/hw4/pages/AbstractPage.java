package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.PropertiesFile;
import ru.training.at.hw4.pages.component.AbstractComponent;
import ru.training.at.hw4.pages.component.HeaderComponent;

public abstract class AbstractPage extends AbstractComponent {

    protected HeaderComponent header;
    protected PropertiesFile properties;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
        properties = new PropertiesFile();
    }

    public void selectCategoryInServiceItem(String categoryName) {
        header.selectCategoryInServiceItem(categoryName);
    }

    protected void open(String url) {
        driver.navigate().to(properties.getUrl() + url);
    }

}

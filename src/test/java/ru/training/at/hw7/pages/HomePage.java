package ru.training.at.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Url ("/index.html")
@Title ("Home Page")
public class HomePage extends WebPage {

    @UI("img#user-icon")
    public static Link userIcon;
    @FindBy (className = "profile-photo")
    private WebElement profilePhoto;
    @UI("#name")
    public static TextField nameField;
    @UI("#password")
    public static TextField passwordField;
    @UI("#login-button")
    public static Button loginButton;
    @UI("#user-name")
    public static Text username;
    @UI("//a[text()='Metals & Colors']")
    public static Link metalAndColors;

    public void performLogin(String name, String password) {
        profilePhoto.click();
        nameField.clear();
        nameField.sendKeys(name);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getUsername() {
        return username.getText().toUpperCase();
    }

    public void chooseMetalAndColorsInHeader() {
        metalAndColors.click();
    }
}

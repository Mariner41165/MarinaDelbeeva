package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AssertionStep extends AbstractStep {
    SoftAssert softAssert;

    public AssertionStep(WebDriver driver) {
        super(driver);
        softAssert = new SoftAssert();
    }

    @Step ("Проверить отображение 4 пунктов в хэдере с правильными заголовками")
    public void fourItemsWithProperTextsExistInHeader() {
        List<String> itemsOnHeaderForChecking = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors");
        softAssert.assertTrue(homePage.itemsOnHeaderToStrings().equals(itemsOnHeaderForChecking));
    }

    @Step ("Проверить, что на странице присутствует 4 изображения")
    public void countOfImagesOnHomePageEqualsTo(int expected) {
        softAssert.assertEquals(homePage.countOfImages(), expected);
    }

    @Step ("Проверить, что на странице присутствует 4 текста под изображениями")
    public void countOfTextsUnderImagesOnHomePageEqualsTo(int expected) {
        softAssert.assertEquals(homePage.countOfTextsUnderImages(), expected);
    }

    @Step ("Проверить наличие на странице элемента iframe")
    public void iframeExistsOnHomePage() {
        softAssert.assertNotNull(homePage.existingOfIframe());
    }

    @Step ("Проверить отображение Frame Button во фрейме")
    public void frameButtonIsDisplayedInIFrame() {
        softAssert.assertTrue(homePage.frameButton().isDisplayed());
    }

    @Step ("Проверить, что в левом меню отображены 5 пунктов с правильными заголовками")
    public void fiveItemsWithProperTextsAreDisplayedOnHomePage() {
        List<String> sideBarItemsForChecking = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertTrue(homePage.sideBarItems().equals(sideBarItemsForChecking));
    }

    @Step ("Проверить, открылась ли страница подраздела '{categoryName}'")
    public void chosenCategoryPageIsOpened(String expectedTitle) {
        homePage.selectCategoryInServiceItem(expectedTitle);
        softAssert.assertAll();
    }

    @Step ("Проверить, что логи всех выбранных параметров отображены на странице")
    public void logOfChosenParametersAreDisplayedOnDifferentElementsPage() {
        differentElementsPage.checkingOfDisplayingChosenParameters();
    }
}

package ru.training.at.hw5.steps;

import io.cucumber.java.en.Then;
import java.util.Arrays;
import java.util.List;
import org.testng.asserts.SoftAssert;

public class ThenStep extends AbstractStep {
    SoftAssert softAssert = new SoftAssert();

    @Then("Check that the user is logged in")
        public void assertThatUserIdLoggedIn() {
        softAssert.assertTrue(homePage.getUsername().equalsIgnoreCase(properties.getUsername()));
    }

    @Then("Check that there are 4 items on the header section are displayed and they have proper texts")
    public void selectedProductsShouldBeAddedToTheCompareList() {
        List<String> itemsOnHeaderForChecking = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors");
        softAssert.assertTrue(homePage.itemsOnHeaderToStrings().equals(itemsOnHeaderForChecking));
    }

    @Then ("Assert that there are {int} images on the Index Page and they are displayed")
    public void countOfImagesOnHomePageEqualsTo(int expected) {
        softAssert.assertEquals(homePage.countOfImages(), expected);
    }

    @Then ("Assert that there are {int} texts on the Index Page under icons and they have proper text")
    public void countOfTextsUnderImagesOnHomePageEqualsTo(int expected) {
        softAssert.assertEquals(homePage.countOfTextsUnderImages(), expected);
    }

    @Then ("Assert that there is the iframe with “Frame Button” exist")
    public void iframeExistsOnHomePage() {
        softAssert.assertNotNull(homePage.existingOfIframe());
    }

    @Then ("Assert that there is “Frame Button” in the iframe")
    public void frameButtonIsDisplayedInIFrame() {
        softAssert.assertTrue(homePage.frameButton().isDisplayed());
    }

    @Then ("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void fiveItemsWithProperTextsAreDisplayedOnHomePage() {
        List<String> sideBarItemsForChecking = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertTrue(homePage.sideBarItems().equals(sideBarItemsForChecking));
    }

    @Then ("Assert that Page {string} is opened")
    public void chosenCategoryPageIsOpened(String expectedTitle) {
        homePage.selectCategoryInServiceItem(expectedTitle);
        softAssert.assertAll();
    }

    @Then ("Assert that for each chosen parameter an individual log row and corresponding value are displayed")
    public void logOfChosenParametersAreDisplayedOnDifferentElementsPage() {
        differentElementsPage.checkingOfDisplayingChosenParameters();
    }

}

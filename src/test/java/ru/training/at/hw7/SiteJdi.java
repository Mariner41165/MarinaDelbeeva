package ru.training.at.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw7.pages.HomePage;
import ru.training.at.hw7.pages.MetalAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {
    @Url("/index.html") public static HomePage homePage;

    @Url("/metals-colors.html")
    @Title("Metals & Colors")
    public static MetalAndColorsPage metalAndColorsPage;
}

package ru.training.at.hw7.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.util.Arrays;
import ru.training.at.hw7.dataProvider.MetalAndColorsValues;

@Url("/metals-colors.html")
@Title ("Metals & Colors")
public class MetalAndColorsPage extends WebPage {

    @UI("[name=custom_radio_odd]")
    public static RadioButtons oddSummaryRadioButtons;
    @UI ("[name=custom_radio_even]")
    public static RadioButtons evenSummaryRadioButtons;
    @UI ("#elements-checklist input")
    public static Checklist elementsCheckboxes;
    @JDropdown(root = "div[ui=dropdown]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown colorsList;
    @JDropdown (root = "div[ui=combobox]",
                value = ".filter-option",
                list = "li",
                expand = ".caret")
    public static Dropdown metalsList;
    @UI ("#vegetables")
    public static Button vegetablesDropdownButton;
    @JDropdown (root = "div[ui=droplist]",
                value = ".filter-option",
                list = "li",
                expand = ".caret")
    public static Dropdown vegetablesList;
    @UI ("#submit-button")
    public static Button submitButton;
    @UI (".panel-body-list.results")
    public static UIElement resultSection;

    public void shouldContainProvidedDataInResultSection(MetalAndColorsValues values) {
        int sum = values.getSummary()[0] + values.getSummary()[1];
        resultSection.has().text(String.format("Summary: %d\nElements: %s\nColor: %s\nMetal: %s\nVegetables: %s", sum,
            Arrays.toString(values.getElements()).replaceAll("[\\[\\]]", ""),
            values.getColor(), values.getMetals(),
            Arrays.toString(values.getVegetables()).replaceAll("[\\[\\]]", "")));
    }
}

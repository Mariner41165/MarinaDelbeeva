package ru.training.at.hw7.steps;

import static ru.training.at.hw7.pages.MetalAndColorsPage.colorsList;
import static ru.training.at.hw7.pages.MetalAndColorsPage.elementsCheckboxes;
import static ru.training.at.hw7.pages.MetalAndColorsPage.evenSummaryRadioButtons;
import static ru.training.at.hw7.pages.MetalAndColorsPage.metalsList;
import static ru.training.at.hw7.pages.MetalAndColorsPage.oddSummaryRadioButtons;
import static ru.training.at.hw7.pages.MetalAndColorsPage.submitButton;
import static ru.training.at.hw7.pages.MetalAndColorsPage.vegetablesDropdownButton;
import static ru.training.at.hw7.pages.MetalAndColorsPage.vegetablesList;

import ru.training.at.hw7.dataProvider.MetalAndColorsValues;

public class ActionStep extends BaseStep {

    public ActionStep() {
        super();
    }
    public void fillForm(MetalAndColorsValues values) {
        oddSummaryRadioButtons.select(String.valueOf(values.getSummary()[0]));
        evenSummaryRadioButtons.select(String.valueOf(values.getSummary()[1]));
        elementsCheckboxes.select(values.getElements());
        colorsList.select(values.getColor());
        metalsList.select(values.getMetals());
        vegetablesDropdownButton.click();
        vegetablesList.select("Vegetables");
        vegetablesList.select(values.getVegetables());
    }

    public void submit() {
        submitButton.click();
    }

}

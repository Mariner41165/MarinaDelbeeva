package ru.training.at.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/CompleteExerciseOneInHw5.feature"})
public class ExerciseOneInHw5Test extends AbstractTestNGCucumberTests {
}

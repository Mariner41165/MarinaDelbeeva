package ru.training.at.hw7.dataProvider;

public class Data {
    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public String toString() {
        return "TestData{" +
            "summary='" + summary + '\'' +
            "elements='" + elements + '\'' +
            ", color='" + color + '\'' +
            ", metals='" + metals + '\'' +
            ", vegetables=" + vegetables +
            '}';
    }
}

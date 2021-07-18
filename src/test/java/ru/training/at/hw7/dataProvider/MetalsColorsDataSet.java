package ru.training.at.hw7.dataProvider;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import ru.training.at.hw7.PropertiesFile;

public class MetalsColorsDataSet {

    @DataProvider(name = "metalsColorsData")
    public static Object[][] extractDataFromJson() throws FileNotFoundException {
        JsonObject jsonObject = JsonParser.parseReader(new FileReader(new PropertiesFile()
            .getJsonFile())).getAsJsonObject();
        List<Data> data = new ArrayList<>();
        Gson gson = new Gson();
        for (String key : jsonObject.keySet()) {
            Data fromJson = gson.fromJson(jsonObject.get(key), Data.class);
            data.add(fromJson);
        }
        List<Data[]> list = new ArrayList<>();
        for (Data value : data) {
            Data[] data1 = new Data[] {value};
            list.add(data1);
        }
        return list.toArray(new Object[0][]);
    }
}

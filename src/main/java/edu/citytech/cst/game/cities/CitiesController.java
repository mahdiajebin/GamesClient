package edu.citytech.cst.game.cities;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.jbbwebsolutions.http.utility.URLUtility;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CitiesController {

    @FXML
    private TableView tvCities;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtPopulation;

    @FXML
    private TextField txtCountryCode;

    @FXML
    private Label lblURL;

    @FXML
    void search(ActionEvent event) {
        tvCities.getItems().clear();

        System.out.println("testing");
//"http://localhost:9615/participation/cities?countryCode=USA&population=NNN"
      final  String url = "http://localhost:9615/participation/cities?countryCode=CCC&population=NNN";

            String populaion = txtPopulation.getText();
            String countryCode = txtCountryCode.getText();

        String newURL = url.replace("NNN", populaion )
                .replace("CCC", countryCode);



        Type cityListType = new TypeToken<ArrayList<City>>() {}.getType();

        List<City> cities = URLUtility.get(newURL, cityListType);

      //  o.forEach(System.out::println);

        ObservableList<City> data = tvCities.getItems();

        data.addAll(cities);
        int rowCount = cities.size();
        lblURL.setText(rowCount + " " + newURL);


    }



}

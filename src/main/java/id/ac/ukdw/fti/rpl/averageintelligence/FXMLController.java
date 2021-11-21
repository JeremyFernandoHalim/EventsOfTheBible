package id.ac.ukdw.fti.rpl.averageintelligence;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import id.ac.ukdw.fti.rpl.averageintelligence.database.Database;
import id.ac.ukdw.fti.rpl.averageintelligence.modal.Verse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.Node;


public class FXMLController implements Initializable {
    private Stage stage;
    private Scene scene;

    private ObservableList<Verse> verses = FXCollections.observableArrayList();

    @FXML
    private TextField searchField;

    @FXML
    private AreaChart<NumberAxis, CategoryAxis> areaChart;

    @FXML
    private NumberAxis numAxis;

    @FXML
    private CategoryAxis catAxis;
    
    @FXML
    private Button homeId;

    
    @FXML
    void klik(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("events4.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);        
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        verses = Database.instance.getAllverse();
        XYChart.Series dataresult = new XYChart.Series();
        dataresult.setName("Periods");
        areaChart.setLegendVisible(false);
        for(int i=verses.size()-1; i>-0; i--){
            dataresult.getData().add(new XYChart.Data(verses.get(i).getTitleEvents(), verses.get(i).getDateEvents()));
        }
        areaChart.getData().add(dataresult);
        System.out.println(verses.size());
        
    }
}


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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;

public class FXMLTabelController implements Initializable {

    private ObservableList<Verse> verses = FXCollections.observableArrayList();

    private Stage stage;
    private Scene scene;

    @FXML
    private TableView<Verse> tableVerses;

    @FXML
    private TableColumn<Verse, String> verseAyat;

    @FXML
    private TableColumn<Verse, String> eventsField;

    @FXML
    private TableColumn<Verse, String> dateField;

    @FXML
    private TableColumn<Verse, String> durationField;

    @FXML
    private TextField searchField;

    @FXML
    private Button visualisasiId;

    @FXML
    void next(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("events3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);        
        stage.setScene(scene);
        stage.show();
    }

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        verses = Database.instance.getAllverse();
        verseAyat.setCellValueFactory(new PropertyValueFactory<Verse, String>("ayatEvents"));
        eventsField.setCellValueFactory(new PropertyValueFactory<Verse, String>("titleEvents"));
        dateField.setCellValueFactory(new PropertyValueFactory<Verse,String>("dateEvents"));
        durationField.setCellValueFactory(new PropertyValueFactory<Verse,String>("durationEvents"));
        tableVerses.setItems(verses);

    FilteredList<Verse> filteredData= new FilteredList<>(verses,searching->true);

        searchField.textProperty().addListener((Observable, oldValue, newValue) -> {
            filteredData.setPredicate(verse -> {
                if (newValue==null || newValue.isEmpty()) {
                    return true;            
                }
                String lowerCase=newValue.toLowerCase();

                // mencari kesesuaian ayat bedasarkan event, jika true maka akan ditampilkan
                if(verse.getAyatEvents().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }              
                // mencari kesesuaian nama bedasarkan event, jika true maka akan ditampilkan
                if(verse.getTitleEvents().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }
                // mencari kesesuaian tahun bedasarkan event, jika true maka akan ditampilkan
                if(verse.getDateEvents().toString().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }
                // mencari kesesuaian durasi bedasarkan event, jika true maka akan ditampilkan
                if(verse.getDurationEvents().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }
                else{
                    return false;
                }
            });
        });  

        SortedList<Verse> sortingData = new SortedList<>(filteredData);
        sortingData.comparatorProperty().bind(tableVerses.comparatorProperty());
        tableVerses.setItems(sortingData);
    }
}


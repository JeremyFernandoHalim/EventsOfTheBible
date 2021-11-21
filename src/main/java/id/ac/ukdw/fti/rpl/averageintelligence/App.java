package id.ac.ukdw.fti.rpl.averageintelligence;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application
{

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        Parent root = FXMLLoader.load(getClass().getResource("events4.fxml")); 
        Scene scene = new Scene(root);
        stage.setTitle("Table Alkitab");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
    private static Scene scene;

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main( String[] args )
    {
        launch(args);
    }
}

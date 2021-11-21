package id.ac.ukdw.fti.rpl.averageintelligence.database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import id.ac.ukdw.fti.rpl.averageintelligence.modal.Verse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    final private String url = "jdbc:sqlite:vizbible.sqlite";
    final String querySelect = "SELECT verses, title, startDate, duration FROM events";
    ObservableList<Verse> verses = FXCollections.observableArrayList();
    private Connection connection = null;
    public static Database instance = new Database();
    
    public Database(){
        try{
            connection = DriverManager.getConnection(url);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }  

    public Connection openConnection(){
        return connection;
    }

    public ObservableList<Verse> getAllverse(){
        try{   
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while (result.next()){
                Verse verse = new Verse();
                verse.setAyatEvents(result.getString("verses"));
                verse.setTitleEvents(result.getString("title"));
                verse.setDateEvents(result.getInt("startDate"));
                verse.setDurationEvents(result.getString("duration"));
                verses.add(verse);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return verses;
    }
}

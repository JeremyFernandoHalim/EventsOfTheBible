module eob{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;

    opens id.ac.ukdw.fti.rpl.averageintelligence to javafx.fxml;
    exports id.ac.ukdw.fti.rpl.averageintelligence.database;
    exports id.ac.ukdw.fti.rpl.averageintelligence.modal;
    exports id.ac.ukdw.fti.rpl.averageintelligence;
    
}

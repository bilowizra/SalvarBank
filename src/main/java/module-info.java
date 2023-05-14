module com.bankapplication.salvarbank {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.bankapplication.salvarbank to javafx.fxml;
    exports com.bankapplication.salvarbank;
    exports com.bankapplication.salvarbank.Controllers;
    exports com.bankapplication.salvarbank.Controllers.Admin;
    exports com.bankapplication.salvarbank.Controllers.Client;
    exports com.bankapplication.salvarbank.Models;
    exports com.bankapplication.salvarbank.Views;
}
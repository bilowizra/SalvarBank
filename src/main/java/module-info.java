module com.bankapplication.salvarbank {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.bankapplication.salvarbank to javafx.fxml;
    exports com.bankapplication.salvarbank;
}
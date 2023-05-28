package com.bankapplication.salvarbank.Controllers.Admin;

import com.bankapplication.salvarbank.Models.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientCellController implements Initializable {
    public Label fName_lbl;
    public Label lName_lbl;
    public Label pAddress_lbl;
    public Label ch_acc_lbl;
    public Label sv_acc_lbl;
    public Label date_lbl;
    public Button delete_btn;

    private final Client client;

    public ClientCellController(Client client){
        this.client=client;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fName_lbl.textProperty().bind(client.firstNameProperty());
        lName_lbl.textProperty().bind(client.lastNameProperty());
        pAddress_lbl.textProperty().bind(client.pAddressproperty());
        ch_acc_lbl.textProperty().bind(client.CheckingAccountProperty().asString());
        sv_acc_lbl.textProperty().bind(client.SavingAccountProperty().asString());
        date_lbl.textProperty().bind(client.dateProperty().asString());

    }
}

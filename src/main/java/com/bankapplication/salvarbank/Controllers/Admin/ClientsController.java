package com.bankapplication.salvarbank.Controllers.Admin;

import com.bankapplication.salvarbank.Models.Client;
import com.bankapplication.salvarbank.Models.Model;
import com.bankapplication.salvarbank.Views.ClientCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientsController implements Initializable {
    public ListView<Client> clients_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        clients_listview.setItems(Model.getInstance().getClients());
        clients_listview.setCellFactory(e -> new ClientCellFactory());
    }

    private void initData() {
        if(Model.getInstance().getClients().isEmpty()){
            Model.getInstance().setClients();
        }
    }


}

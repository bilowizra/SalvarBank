package com.bankapplication.salvarbank.Models;

import com.bankapplication.salvarbank.Views.AccountType;
import com.bankapplication.salvarbank.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private DatabaseDriver databaseDriver;

    // Client Data Section
    private final Client client;
    private boolean clientLoginSuccessFlag;

    //Admin Data Section
    private boolean adminLoginSuccessFlag;


    private Model() {

        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // Client Data Section
        this.clientLoginSuccessFlag = false;
        this.client = new Client("","","",null, null, null);
        // Admin Data Section
        this.adminLoginSuccessFlag = false;

    }

    public static synchronized Model getInstance(){
        if(model==null){
            model= new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver() {return databaseDriver;}


    /*
    * Client Method Section
    * */

    public boolean getClientSuccessFlag(){return this.clientLoginSuccessFlag;}
    public void setClientLoginSuccessFlag(boolean flag){this.clientLoginSuccessFlag = flag;}

    public Client getClient(){
        return client;
    }

    public void evaluateClientCred(String pAddress, String password){
        CheckingAccount checkingAccount;
        SavingAccount savingAccount;
        ResultSet resultSet = databaseDriver.getClientData(pAddress,password);
        try{
            if(resultSet.isBeforeFirst()){
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.pAddressproperty().set(resultSet.getString("PayeeAddress"));
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.client.dateProperty().set(date);
                this.clientLoginSuccessFlag = true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
     * Admin Method Section
     * */

    public boolean getAdminLoginSuccessFlag() {return this.adminLoginSuccessFlag;}

    public void setAdminLoginSuccessFlag(boolean adminLoginSuccessFlag) {
        this.adminLoginSuccessFlag = adminLoginSuccessFlag;
    }

    public void evaluateAdminCred(String username, String password) {
        ResultSet resultSet = databaseDriver.getAdminData(username, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.adminLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

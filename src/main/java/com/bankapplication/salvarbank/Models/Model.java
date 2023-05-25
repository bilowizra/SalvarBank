package com.bankapplication.salvarbank.Models;

import com.bankapplication.salvarbank.Views.AccountType;
import com.bankapplication.salvarbank.Views.ViewFactory;

import java.sql.ResultSet;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private DatabaseDriver databaseDriver;
    private AccountType loginAccountType = AccountType.CLIENT;

    // Client Data Section
    private final Client client;
    private boolean clientLoginSuccessFlag;


    //Admin Data Section


    private Model() {

        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // Client Data Section
        this.clientLoginSuccessFlag = false;
        this.client = new Client("","","",null, null, null);
        // Admin Data Section

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

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

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

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

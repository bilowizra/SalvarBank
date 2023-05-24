package com.bankapplication.salvarbank.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Client {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty payeeAddress;
    private final ObjectProperty<Account> checkingAccount;
    private final ObjectProperty<Account> savingAccount;
    private final ObjectProperty<LocalDate> dateCreated;


    public Client(String fName, String lName, String pAddress, Account cAccount, Account sAccount, LocalDate date){
        this.firstName = new SimpleStringProperty(this,"FirstName", fName);
        this.lastName = new SimpleStringProperty(this,"LastName", lName);
        this.payeeAddress = new SimpleStringProperty(this,"Payee Address", pAddress);
        this.checkingAccount = new SimpleObjectProperty<>(this,"Checking Account", cAccount);
        this.savingAccount = new SimpleObjectProperty<>(this,"Saving Account", sAccount);
        this.dateCreated = new SimpleObjectProperty<>(this,"Date", date);
    }

    public StringProperty firstNameProperty(){
        return firstName;
    }
    public StringProperty lastNameProperty(){
        return lastName;
    }
    public StringProperty pAddressproperty(){
        return payeeAddress;
    }
    public ObjectProperty<Account> CheckingAccountProperty(){
        return checkingAccount;
    }
    public ObjectProperty<Account> SavingAccountProperty(){
        return savingAccount;
    }
    public ObjectProperty<LocalDate> dateProperty(){
        return dateCreated;
    }



}

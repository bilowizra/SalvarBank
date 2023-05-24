package com.bankapplication.salvarbank.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingAccount extends Account{

    private final DoubleProperty withdrawalLimit;

    public SavingAccount(String owner, String accountNumber, double balance, double withdrawalLimit){
        super(owner,accountNumber,balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this,"Withdrawal Limit",withdrawalLimit);
    }

    public DoubleProperty withdrawalLimitProperty() {
        return withdrawalLimit;
    }
}

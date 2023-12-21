package com.openclassrooms.mypaybuddy.service;

import com.openclassrooms.mypaybuddy.model.Compte;
import com.openclassrooms.mypaybuddy.model.Transaction;
import com.openclassrooms.mypaybuddy.model.User;

public interface ITransfert {

    public void transfer(Compte compteEmetteur, Compte compteRecepteur, double montant,String description);

    Transaction saveTransfert(Transaction transaction);

    public Transaction getTransactionById(Long id);

}

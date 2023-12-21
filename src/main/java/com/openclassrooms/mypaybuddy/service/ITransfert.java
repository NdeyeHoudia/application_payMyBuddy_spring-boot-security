package com.openclassrooms.mypaybuddy.service;

import com.openclassrooms.mypaybuddy.model.Compte;

public interface ITransfert {

    public void transfer(Compte compteEmetteur, Compte compteRecepteur, double montant);




}

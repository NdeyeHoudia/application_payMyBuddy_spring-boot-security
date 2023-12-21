package com.openclassrooms.mypaybuddy.web.dto;

public class TransfertDto {
    private String Username;
    private  double montant;

    public TransfertDto() {
    }

    public TransfertDto(String username, double montant) {
        Username = username;
        this.montant = montant;
    }

}

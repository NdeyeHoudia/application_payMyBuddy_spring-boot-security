package com.openclassrooms.mypaybuddy.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private  int idTransaction;
    @Column(name = "description")
    private  String description;
    @Column(name = "montant")
    private  double montant;
    @Column(name = "date_transaction")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "compte_source_id")
    private Compte compteSource;

    @ManyToOne
    @JoinColumn(name = "compte_destination_id")
    private Compte compteDestination;
    @ManyToOne
    @JoinColumn(name="idcompte")
    private  Compte compte;

    public Compte getCompteSource() {
        return compteSource;
    }

    public void setCompteSource(Compte compteSource) {
        this.compteSource = compteSource;
    }

    public Compte getCompteDestination() {
        return compteDestination;
    }

    public void setCompteDestination(Compte compteDestination) {
        this.compteDestination = compteDestination;
    }

    public Transaction(){
        super();
    }
    public Transaction(double montant, LocalDateTime date, Compte compte) {
        super();
        this.montant = montant;
        this.date = date;
        this.compte = compte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

   /* public void addCompte(Compte compte){
        comptes.add(compte);
        compte.getTransactionsSortantes().add(this);
    }*/

   /* @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", idCompteE=" + idCompteE +
                ", idCompteR=" + idCompteR +
                ", description='" + description + '\'' +
                ", montant=" + montant +
                ", date=" + date +
                ", comptes=" + comptes +
                ", compte=" + compte +
                '}';
    }*/
}

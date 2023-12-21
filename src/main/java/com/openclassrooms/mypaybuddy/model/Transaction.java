package com.openclassrooms.mypaybuddy.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private  int idTransaction;
    @Column(name = "id_compteE")
    private  int idCompteE;
    @Column(name = "id_compteR")
    private  int idCompteR;
    @Column(name = "description")
    private  String description;
    @Column(name = "montant")
    private  double montant;
    @Column(name = "date_transaction")
    private Date date;

    @ManyToMany(
            mappedBy = "transactions"
    )
    private List<Compte> comptes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="idcompte")
    private  Compte compte;
    public Transaction(){
        super();
    }
    public Transaction(double montant, Date date, Compte compte) {
        super();
        this.montant = montant;
        this.date = date;
        this.compte = compte;
    }

    public int getIdCompteE() {
        return idCompteE;
    }

    public void setIdCompteE(int idCompteE) {
        this.idCompteE = idCompteE;
    }

    public int getIdCompteR() {
        return idCompteR;
    }

    public void setIdCompteR(int idCompteR) {
        this.idCompteR = idCompteR;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public void addCompte(Compte compte){
        comptes.add(compte);
        compte.getTransactions().add(this);
    }

}

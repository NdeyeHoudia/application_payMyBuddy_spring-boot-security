package com.openclassrooms.mypaybuddy.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compte")
    private int idCompte;
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "solde")
    private double solde;
    @Column(name = "numero_compte_bancaire")
    private String numberAccountBank;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getNumberAccountBank() {
        return numberAccountBank;
    }

    public void setNumberAccountBank(String numberAccountBank) {
        this.numberAccountBank = numberAccountBank;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // une transaction se fait sur plusierus comptes et un compte fait l'objet de n transactions
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            }
    )
    @JoinTable(
            name = "transaction_compte",
            joinColumns = @JoinColumn(name = "id_compte"),
            inverseJoinColumns = @JoinColumn(name = "id_transaction")
    )
    private List<Transaction> transactions = new ArrayList<>();

    //Ajout des  méthodes utilitaires
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.getComptes().add(this);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        transaction.getComptes().remove(this);
    }

    public Compte(int solde, String numberAccountBank) {
        this.solde = solde;
        this.numberAccountBank = numberAccountBank;
    }

    public Compte() {
    }

   public void retrait(double montant) {
        if (solde >= montant) {
            solde = solde - montant;
        } else throw new RuntimeException("Solde insuffisant");
    }

   public void depot(double montant) {
        solde = solde + montant;
    }
    public Compte addCompteBancaire(Compte compte){
return  null;
    }
}

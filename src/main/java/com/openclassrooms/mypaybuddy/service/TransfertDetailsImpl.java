package com.openclassrooms.mypaybuddy.service;


import com.openclassrooms.mypaybuddy.model.Compte;
import com.openclassrooms.mypaybuddy.model.Transaction;
import com.openclassrooms.mypaybuddy.repository.CompteRepository;
import com.openclassrooms.mypaybuddy.repository.TransactionRepository;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//import static java.awt.Container.log;

//import static java.awt.Container.log;


@Service
@Transactional
public class TransfertDetailsImpl implements ITransfert {
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void transfer(Compte compteEmetteur, Compte compteRecepteur, double montant, String description) {
       try {
           compteEmetteur.retrait(montant);
           compteRecepteur.depot(montant);
           compteRepository.save(compteEmetteur);
           compteRepository.save(compteRecepteur);
           Transaction transaction = new Transaction();
       //   transaction.setComptes(List.of(compteEmetteur,compteRecepteur));
         //  transaction.setCompte(compteEmetteur);
        //   transaction.setCompte(compteRecepteur);

           transaction.setDescription(description);
           transaction.setMontant(montant);
           transaction.setDate(LocalDateTime.now());
           transactionRepository.save(transaction);
       }catch (Exception e){
           System.out.println("erreur de la méthode transfert" +e);
         //   log.error("erreur de la méthode transfert" +e);
       }
    }
    public Compte depot(double montant) {
        Compte compte = new Compte();

        compte.depot(montant);
       return compteRepository.save(compte);
    }
    public void retrait(double montant) {
        Compte compte = new Compte();
        if (compte.getSolde()>=montant){
            compte.retrait(montant);
            compteRepository.save(compte);
        }
        else throw  new RuntimeException("Le compte n'a pas suffisament d'argent");
    }

    public Transaction saveTransfert(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction saveTransfert(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(Math.toIntExact(id)).get();
    }

    public Iterable<Transaction> getTransaction(){
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Integer id){
        return  transactionRepository.findById(id);
    }

}

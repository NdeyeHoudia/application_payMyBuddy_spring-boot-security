package com.openclassrooms.mypaybuddy.controller;

import com.openclassrooms.mypaybuddy.model.Compte;
import com.openclassrooms.mypaybuddy.repository.CompteRepository;
import com.openclassrooms.mypaybuddy.service.TransfertDetailsImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/api/trans")
public class TransactionController {

    public  final TransfertDetailsImpl transfertDetails;
    public  final CompteRepository compteRepository;

    public TransactionController(TransfertDetailsImpl transfertDetails, CompteRepository compteRepository) {
        this.transfertDetails = transfertDetails;
        this.compteRepository = compteRepository;
    }

    @GetMapping("/transfert")
    public String transfert(
            @RequestParam  int idCompteEmetteur,
            @RequestParam int idCompteRecepteur,
            @RequestParam double montant) {
       Optional<Compte>  compteEmetteur =  compteRepository.findById(idCompteEmetteur);
       Optional<Compte> compteRecepteur = compteRepository.findById(idCompteRecepteur);

       if(compteRecepteur.isPresent() && compteEmetteur.isPresent()){
           transfertDetails.transfer(compteEmetteur.get(),compteRecepteur.get(),montant);
       }
       else throw  new RuntimeException("Un des compte n'a pas été trouvé");

     return "le transfert effectué";
    }

}

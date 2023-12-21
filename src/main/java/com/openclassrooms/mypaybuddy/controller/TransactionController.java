package com.openclassrooms.mypaybuddy.controller;

import com.openclassrooms.mypaybuddy.model.Compte;
import com.openclassrooms.mypaybuddy.model.Transaction;
import com.openclassrooms.mypaybuddy.model.User;
import com.openclassrooms.mypaybuddy.repository.CompteRepository;
import com.openclassrooms.mypaybuddy.repository.UserRepository;
import com.openclassrooms.mypaybuddy.service.TransfertDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/api/trans")
public class TransactionController {
   @Autowired
    private TransfertDetailsImpl transfertDetails;

   @Autowired
   public  CompteRepository compteRepository;

    @GetMapping("/depot/new")
    public String depot(@AuthenticationPrincipal User user, @RequestParam double montant, Model model){
      //  System.out.println("L'utilisateur email: {} est connectée à son compte"+ user.getEmail());
       model.addAttribute("transactions", user);
        transfertDetails.depot(montant);

        return "index";
    }

    @GetMapping("/retrait")
    public String retrait(@RequestParam double montant,@AuthenticationPrincipal User user,Model model){
        model.addAttribute("transactions", user);
        transfertDetails.depot(montant);
        return "le retrait est effectué";
    }
    @GetMapping("/transfert")
    public String transfert(
            @RequestParam  int idCompteEmetteur,
            @RequestParam int idCompteRecepteur,
            @RequestParam double montant,
            @RequestParam String description) {
       Optional<Compte>  compteEmetteur =  compteRepository.findById(idCompteEmetteur);
       Optional<Compte> compteRecepteur = compteRepository.findById(idCompteRecepteur);

       if(compteRecepteur.isPresent() && compteEmetteur.isPresent()){
           transfertDetails.transfer(compteEmetteur.get(),compteRecepteur.get(),montant,description);
       }
       else throw  new RuntimeException("Un des compte n'a pas été trouvé");
     return "le transfert est effectué";
    }
    @GetMapping("/AllTransaction")
    public Iterable<Transaction> getAllTransactionByUser(){
        Compte compte = new Compte();
        compte.getClient();
       return transfertDetails.getTransaction();
    }




  /*  @GetMapping("/transfert")
    public String sendMoney(
            @RequestParam  String  email,
            @RequestParam double montant,
            @RequestParam int idCompteRecepteur,
            @RequestParam String description){

        Boolean user = userRepository.existsByUsername(email);
        Optional<User> email1 = userRepository.findByEmail(email);

        //  Optional<User>  compteEmetteur =  compteRepository.findById(idCompteEmetteur);
          Optional<Compte> compteRecepteur = compteRepository.findById(idCompteRecepteur);

        if(email1.isPresent()){
           // transfertDetails.transfer(email1,compteRecepteur,montant,description);
        }
        else throw  new RuntimeException("Un des compte n'a pas été trouvé");

        return "le transfert effectué";
    }
*/
}

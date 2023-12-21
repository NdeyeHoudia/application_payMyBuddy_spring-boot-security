package com.openclassrooms.mypaybuddy;

import com.openclassrooms.mypaybuddy.model.Compte;
import com.openclassrooms.mypaybuddy.model.Transaction;
import com.openclassrooms.mypaybuddy.repository.CompteRepository;
import com.openclassrooms.mypaybuddy.service.TransfertDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class PayMyBuddyApplication implements CommandLineRunner {

	@Autowired
private  TransfertDetailsImpl transfertDetails;
	public static void main(String[] args) {
		SpringApplication.run(PayMyBuddyApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		/*Compte  compte = new Compte(300,"ABCDEFF",1);
		Compte  compte1 = new Compte(50,"ABBCDDE",2);

		transfertDetails.transfer(compte1, compte, 10,"Virement de loyer");*/
	}
}

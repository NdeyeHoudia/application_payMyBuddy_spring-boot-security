package com.openclassrooms.mypaybuddy.repository;

import com.openclassrooms.mypaybuddy.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {

   // Optional<Compte> findByNumberAccountBank(String numberAccountBank);
}

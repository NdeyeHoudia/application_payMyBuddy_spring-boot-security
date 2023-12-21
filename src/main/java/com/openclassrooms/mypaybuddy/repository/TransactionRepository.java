package com.openclassrooms.mypaybuddy.repository;

import com.openclassrooms.mypaybuddy.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}

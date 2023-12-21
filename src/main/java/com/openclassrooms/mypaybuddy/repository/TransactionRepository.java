package com.openclassrooms.mypaybuddy.repository;

import com.openclassrooms.mypaybuddy.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}

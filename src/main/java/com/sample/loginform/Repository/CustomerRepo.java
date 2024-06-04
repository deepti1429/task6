package com.sample.loginform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.loginform.Entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}

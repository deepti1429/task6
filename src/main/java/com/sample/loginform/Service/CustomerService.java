package com.sample.loginform.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.loginform.Entity.Customer;
import com.sample.loginform.Repository.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public Customer saveDetails(Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    public Optional<Customer> getCustomerById(int id) {
        return repo.findById(id);
    }

    public void deleteCustomerById(int id) {
        repo.deleteById(id);
    }

    public Customer updateCustomer(int id, Customer customerDetails) {
        return repo.findById(id)
                   .map(customer -> {
                       customer.setName(customerDetails.getName());
                       customer.setEmail(customerDetails.getEmail());
                       customer.setPhno(customerDetails.getPhno());
                       customer.setAddress(customerDetails.getAddress());
                       customer.setPlan(customerDetails.getPlan());

                       return repo.save(customer);
                   })
                   .orElseGet(() -> {
                       customerDetails.setId(id);
                       return repo.save(customerDetails);
                   });
    }
}

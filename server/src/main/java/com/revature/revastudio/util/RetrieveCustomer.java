package com.revature.revastudio.util;

import com.revature.revastudio.entity.Customer;
import com.revature.revastudio.entity.User;
import com.revature.revastudio.repositories.CustomerRepository;
import com.revature.revastudio.services.CustomerService;
import com.revature.revastudio.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RetrieveCustomer {

    private final CustomerRepository customerRepository;

    public RetrieveCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(){
        UUID userId = (UUID) SecurityContextHolder.getContext().getAuthentication().getDetails();
        Customer customer = customerRepository.findByUser_Id(userId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        return customer;

    }




}

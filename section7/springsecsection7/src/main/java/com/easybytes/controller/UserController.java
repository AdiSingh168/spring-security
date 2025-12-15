package com.easybytes.controller;

import com.easybytes.model.Customer;
import com.easybytes.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        try {
            String hashedPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPwd);

            Customer savedCustomer = customerRepository.save(customer);

            if (savedCustomer.getId() > 0) {
                return ResponseEntity.ok("Customer inserted successfully");
            } else {
                return ResponseEntity.badRequest().body("User registration failed");
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(String.format("An exception occurred: %s", ex.getMessage()));
        }
    }

}

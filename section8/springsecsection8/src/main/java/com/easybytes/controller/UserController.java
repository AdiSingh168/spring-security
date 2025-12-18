package com.easybytes.controller;

import com.easybytes.model.Customer;
import com.easybytes.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

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
            customer.setCreateDt(new Date(System.currentTimeMillis()));

            Customer savedCustomer = customerRepository.save(customer);

            if (savedCustomer.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Given user details are registered successfully");
            } else {
                return ResponseEntity.badRequest().body("User registration failed");
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(String.format("An exception occurred: %s", ex.getMessage()));
        }
    }

    @GetMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        Optional<Customer> customer = customerRepository.findByEmail(authentication.getName());
        return customer.orElse(null);
    }

}

package com.easybytes.controller;

import com.easybytes.model.Loans;
import com.easybytes.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoansRepository loansRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestParam long id) {
        return loansRepository.findByCustomerIdOrderByStartDtDesc(id);
    }

}

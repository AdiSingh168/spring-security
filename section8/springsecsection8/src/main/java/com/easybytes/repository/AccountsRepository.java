package com.easybytes.repository;

import com.easybytes.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Integer> {

    Accounts findByCustomerId(Long integer);
}

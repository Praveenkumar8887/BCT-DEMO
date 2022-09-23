package com.itss.bdctdemo.repository;

import org.springframework.stereotype.Repository;
import com.itss.bdctdemo.entitybeans.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}

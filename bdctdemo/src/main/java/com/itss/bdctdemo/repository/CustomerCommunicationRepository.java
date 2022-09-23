package com.itss.bdctdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.bdctdemo.entitybeans.CustomerCommunication;

@Repository
public interface CustomerCommunicationRepository extends JpaRepository<CustomerCommunication, String> {

}
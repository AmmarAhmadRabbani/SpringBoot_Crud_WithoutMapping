package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

}

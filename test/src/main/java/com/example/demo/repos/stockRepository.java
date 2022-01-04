package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Client;
import com.example.demo.entities.Stock;

public interface stockRepository extends JpaRepository<Stock, Long>{

}

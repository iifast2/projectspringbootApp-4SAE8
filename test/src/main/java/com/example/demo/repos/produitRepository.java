package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Client;
import com.example.demo.entities.Produit;

public interface produitRepository extends JpaRepository<Produit, Long>{

}

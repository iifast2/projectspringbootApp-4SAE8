package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Facture;
import com.example.demo.entities.Fournisseur;

public interface fournisseurRepository extends JpaRepository<Fournisseur, Long>{

}

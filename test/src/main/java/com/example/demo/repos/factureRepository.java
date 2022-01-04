package com.example.demo.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Client;
import com.example.demo.entities.Facture;

public interface factureRepository extends JpaRepository<Facture, Long>{
	@Query("SELECT f FROM Facture f WHERE f.dateFacture BETWEEN ?1 AND ?2") 
	List<Facture> retrievesFacturesBetweenDates(Date startDate,Date endDate); 
	
}

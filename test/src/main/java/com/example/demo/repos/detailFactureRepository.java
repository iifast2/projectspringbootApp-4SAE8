package com.example.demo.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Facture;
import com.example.demo.entities.Produit;
import com.example.demo.entities.detailFacture;

public interface detailFactureRepository extends JpaRepository<detailFacture, Long>{
	@Query("SELECT df FROM detailFacture df WHERE df.produit=?1 "
			+ "AND df.facture.dateFacture BETWEEN ?2 AND ?3 and df.facture.acitve=true") 
	List<detailFacture> retrieveDFbyProd(Produit prod,Date startDate,Date endDate);
}

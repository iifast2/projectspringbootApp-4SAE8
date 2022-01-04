package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;

@Component
public interface clientRepository  extends JpaRepository<Client, Long>{
	@Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN '1995/01/01' AND '1995/12/31'") 
	List<Client> retrieveClientsBetWeenDates(); 

	@Query("SELECT c FROM Client c WHERE c.categorieClient = ?1") 
	List<Client> retrieveClientsByCategory(CategorieClient categ); 
}

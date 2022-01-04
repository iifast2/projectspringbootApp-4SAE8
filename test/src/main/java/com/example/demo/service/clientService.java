package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;
import com.example.demo.entities.Facture;
import com.example.demo.entities.detailFacture;

public interface clientService {
	Client saveClient(Client p);
	Client updateClient(Client p);
	void deleteClient(Client p);
	void deleteClientById(Long id);
	Client getClient(Long id);
	List<Client> getClientByDates();
	float getChiffreAffaire();
	List<Facture> getAllFactures();
	float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) ;
	List<Facture> getFacturesByClient(Long id);
	List<Client> getAllClients();
	Facture addDtFact(Facture f, List<detailFacture> df);
	Facture addFacture(Facture f, Long idClient);
}

package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;
import com.example.demo.entities.Facture;
import com.example.demo.entities.Produit;
import com.example.demo.entities.Stock;
import com.example.demo.entities.detailFacture;
import com.example.demo.repos.clientRepository;
import com.example.demo.repos.detailFactureRepository;
import com.example.demo.repos.factureRepository;
import com.example.demo.repos.produitRepository;
import com.example.demo.repos.stockRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class clientServiceImpl implements clientService {
	private static final CategorieClient categ = null;
	@Autowired
	clientRepository cr;
	@Autowired
	produitRepository pr;
	@Autowired
	detailFactureRepository dfr;
	@Autowired
	factureRepository fr;
	@Autowired
	produitService ps;
	@Override
	public List<Client> getAllClients() {
		List<Client> cl =(List<Client>) cr.findAll();
		for(Client c:cl) {
			log.info("clients:"+c);
		}
		return cl;
	}

	@Override
	public Client saveClient(Client p) {
		return cr.save(p);
	}
	@Override
	public Client updateClient(Client p) {
		return cr.save(p);
	}
	@Override
	public void deleteClient(Client p) {
		cr.delete(p);
	}
	@Override
	public void deleteClientById(Long id) {
		cr.deleteById(id);
	}
	@Override
	public Client getClient(Long id) {
		return cr.findById(id).orElse(null);
	}

	@Override
	public List<Client> getClientByDates() {
		return cr.retrieveClientsByCategory(categ.Fidele);
	}
	@Override
	public List<Facture> getAllFactures() {
		return fr.findAll();
	}

	@Override
	public List<Facture> getFacturesByClient(Long id) {
		Client c = getClient(id);
		List<Facture> factures = c.getFactures();
		return factures;
	}


	@Override
	public Facture addFacture(Facture f, Long idClient) {

		Client c = getClient(idClient);
		f.setClient(c);
		f.setDateFacture(new Date());
		f.setAcitve(true);
		List<detailFacture> df = f.getDetfact();

		Facture facture = addDtFact(f, df);


		return fr.save(facture);
	}

	@Override
	public Facture addDtFact(Facture f, List<detailFacture> df) {
		float x = 0;
		float y = 0;
		long test = 1;
		for (detailFacture detail: df) {
			Produit produit = pr.findById(detail.getProduit().getIdProduit()).orElse(null);
			float prixTotalDetail = detail.getQte() * produit.getPrixUnitaire();
			float montantRemise = prixTotalDetail * detail.getPourcentageRemise()/100;
			float prixTotal = prixTotalDetail - montantRemise;	
			detail.setPrixTotal(prixTotal);
			detail.setMontantRemise(montantRemise);
			x += prixTotal;
			y+=montantRemise;
			detail.setProduit(produit);
			detail.setFacture(f);
			dfr.save(detail);
		}

		f.setMontantFacutre(x);
		f.setMontantRemise(y);
		log.info("Montant Facture : "+x);
		log.info("Montant Remise : "+y);

		return f;
	}

	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
		List<Client> clientCateg= cr.retrieveClientsByCategory(categorieClient);
		List<Facture> listFacture = fr.retrievesFacturesBetweenDates(startDate, endDate);
		float CA = 0;

		for (Facture fc : listFacture) {
			if(clientCateg.contains(fc.getClient()) && fc.isAcitve()==true) {
					CA+= fc.getMontantFacutre();
			}
		}
		
		return CA;
	}
	
	@Override
	@Transactional
	@Scheduled(cron = "* * * 1 1 ?")
	public float getChiffreAffaire() {
		List<Facture> listFacture= fr.findAll();
		float CA = 0;
		for (Facture fc : listFacture) {
					CA+= fc.getMontantFacutre();	
		}
		return CA;
	}

}

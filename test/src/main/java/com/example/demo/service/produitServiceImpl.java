package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;
import com.example.demo.entities.Fournisseur;
import com.example.demo.entities.Produit;
import com.example.demo.entities.Stock;
import com.example.demo.entities.detailFacture;
import com.example.demo.entities.detailProduit;
import com.example.demo.entities.rayon;
import com.example.demo.repos.detailFactureRepository;
import com.example.demo.repos.detailProduitRepository;
import com.example.demo.repos.fournisseurRepository;
import com.example.demo.repos.produitRepository;
import com.example.demo.repos.rayonRepository;
import com.example.demo.repos.stockRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class produitServiceImpl implements produitService {

	@Autowired
	produitRepository cr;
	@Autowired
	produitRepository pr;
	@Autowired
	detailFactureRepository dfr;
	@Autowired
	stockRepository sr;
	@Autowired
	fournisseurRepository fr;
	@Autowired
	rayonRepository rr;
	@Autowired
	detailProduitRepository dr;
	
	@Override
	public Produit saveProduct(Produit p) {
	
		// TODO Auto-generated method stub
		return cr.save(p);
	}

	@Override
	public Produit updateProduct(Produit p) {
		// TODO Auto-generated method stub
		return cr.save(p);
	}

	@Override
	public void deleteProduct(Produit p) {
		// TODO Auto-generated method stub
		cr.delete(p);
	}

	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}

	@Override
	public Produit getProduct(Long id) {
		// TODO Auto-generated method stub
		return cr.findById(id).get();
	}

	@Override
	public List<Produit> getAllProducts() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}
	@Override
	public List<detailProduit> getAlldetailsProduits() {
		// TODO Auto-generated method stub
		return dr.findAll();
	}
	
	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit p=pr.findById(idProduit).orElse(null);
		Stock s=sr.findById(idStock).orElse(null);
		p.setStock(s);
		pr.save(p);
	}
	
	@Override
	public void assignFournisseurToProduit(Long idFournisseur, Long idProduit) {
		Produit p=pr.findById(idProduit).orElse(null);
		Fournisseur s=fr.findById(idFournisseur).orElse(null);
		p.getFournisseur().add(s);
		pr.save(p);
	}
	@Override
	public Produit assignDetailProduitToProduit(Long idProduit, Long idDetailProduit) {
		Produit p=pr.findById(idProduit).orElse(null);
		detailProduit s=dr.findById(idDetailProduit).get();
		p.setProdDetails(s);
		pr.save(p);
		return p;
	}
	@Override
	public	detailProduit saveDetailProduit(Produit p) {
		if(p.getProdDetails().getDateCreation()==null) {
			p.getProdDetails().setDateCreation(new Date());
			p.getProdDetails().setDateDerniereModification(new Date());
		}else {
			p.getProdDetails().setDateDerniereModification(new Date());
		}
		detailProduit dp = dr.save(p.getProdDetails());
		return dp;
	}
	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		
		Stock stock=sr.findById(idStock).orElse(null);
		rayon rayon=rr.findById(idRayon).orElse(null);
		p.setStock(stock);
		p.setRay(rayon);
		detailProduit detP= saveDetailProduit(p);
		p.setProdDetails(detP);
		pr.save(p);
		log.info("produit added : "+p);
		
		
		return p;
	}
	 
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate){
		Produit p=pr.findById(idProduit).orElse(null);
		float sum=0;
		List<detailFacture> df= dfr.retrieveDFbyProd(p, startDate, endDate);
		for (detailFacture detail : df) {
			sum+=detail.getPrixTotal();
		}
		return sum;
	}
	
	

}

package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Client;
import com.example.demo.entities.Produit;
import com.example.demo.entities.detailProduit;

public interface produitService {
	Produit saveProduct(Produit p);
	Produit updateProduct(Produit p);
	void deleteProduct(Produit p);
	void deleteProductById(Long id);
	Produit getProduct(Long id);
	List<Produit> getAllProducts();
	List<detailProduit> getAlldetailsProduits();
	Produit assignDetailProduitToProduit(Long idProduit, Long idDetailProduit);
	void assignFournisseurToProduit(Long idFournisseur, Long idProduit) ;
	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
	void assignProduitToStock(Long idProduit, Long idStock);
	Produit addProduit(Produit p, Long idRayon, Long idStock);
	detailProduit saveDetailProduit(Produit p);
}

package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.entities.Facture;
import com.example.demo.entities.Fournisseur;
import com.example.demo.entities.Produit;
import com.example.demo.entities.Stock;
import com.example.demo.entities.detailFacture;
import com.example.demo.entities.detailProduit;
import com.example.demo.repos.detailFactureRepository;
import com.example.demo.service.clientService;
import com.example.demo.service.produitService;
import com.example.demo.service.stockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Produit management")
@RequestMapping("/produit")
public class produitRestController {
	@Autowired
	produitService ps;
	@Autowired
	stockService ss;
	@Autowired
	detailFactureRepository dr;
	@Autowired
	clientService cs;
	@ApiOperation(value = "Récupérer la liste des produits")
	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<Produit> getProducts() {
		List<Produit> listProduits = ps.getAllProducts();
		ss.getAllStocksbyStatus();
		return listProduits;
	}
	@ApiOperation(value = "Récupérer la liste des details produits")
	@GetMapping("/retrieve-all-dps")
	@ResponseBody
	public List<detailProduit> getDetailsProducts() {
		List<detailProduit> listProduits = ps.getAlldetailsProduits();
		return listProduits;
	}
	
	@GetMapping("/retrieve-all-Factures")
	@ResponseBody
	public List<Facture> getFactures() {
		List<Facture> listFacture = cs.getAllFactures();
		return listFacture;
	}
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<detailFacture> getStocks() {
		List<detailFacture> lisStock = dr.findAll();
		return lisStock;
	}
	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@PostMapping("/add-product/{Rayon-id}/{Stock-id}")
	@ResponseBody
	public Produit addProduct(@RequestBody Produit p,@PathVariable("Rayon-id") long idR,@PathVariable("Stock-id") long idS)
	{
		Produit produit = ps.addProduit(p, idR, idS);
		return produit;
	}
	@PostMapping("/add-facture/{Client-id}")
	@ApiOperation(value = "addFacture")
	@ResponseBody
	public Facture addFacture(@RequestBody Facture f,@PathVariable("Client-id") long idC)
	{
		Facture fact = cs.addFacture(f, idC);
		return fact;
	}
	
	@PutMapping("/add-fournisseur/{Fournisseur-id}/{Produit-id}")
	@ApiOperation(value = "assignFournisseurToProduit")
	@ResponseBody
	public void addFournisseur(@PathVariable("Fournisseur-id") long f,@PathVariable("Produit-id") long idC)
	{
		ps.assignFournisseurToProduit(f, idC);
	}
	

	

}

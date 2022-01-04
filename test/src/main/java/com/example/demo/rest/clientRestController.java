package com.example.demo.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;
import com.example.demo.entities.Facture;
import com.example.demo.service.clientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@Api(tags = "Client management")
@RequestMapping("/client")
public class clientRestController {
	
	@Autowired
	clientService cr;

	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@PostMapping("/add-client")
	@ResponseBody
	public Client addClient(@RequestBody Client c)
	{
	Client client = cr.saveClient(c);
	return client;
	}
	@ApiOperation(value = "Récupérer la liste des clients")
	@GetMapping("/retrieve-all-clients")
	@ResponseBody
	public List<Client> getClients() {
	List<Client> listClients = cr.getAllClients();
	return listClients;
	}
	@ApiOperation(value = "Récupérer CA")
	@GetMapping("/retrieveCA/{client-categ}/{client-day1}/{client-day2}")
	@ResponseBody
	public float getCA(@PathVariable("client-categ") CategorieClient cc,@PathVariable("client-day1") @DateTimeFormat(pattern="yyyy-MM-dd") Date day ,
			@PathVariable("client-day2") @DateTimeFormat(pattern="yyyy-MM-dd") Date daytest2) {
	float tt = cr.getChiffreAffaireParCategorieClient(cc,day,daytest2);
	return tt;
	}
	@DeleteMapping("/remove-client/{client-id}")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
	cr.deleteClientById(clientId);
	}

	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client) {
	return cr.updateClient(client);
	}
	@GetMapping("/retrieveFactureByClient")
	@ApiOperation(value = "Récupérer la liste des factures by client")
	@ResponseBody
	public List<Facture> retrieveFacturesByClient() {
	List<Facture> listfact = cr.getFacturesByClient(null);
	return listfact;
	}
}

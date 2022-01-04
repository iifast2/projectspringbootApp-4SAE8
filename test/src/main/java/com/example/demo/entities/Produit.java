package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit;
	private String code;
	private String labelle;
	private float prixUnitaire;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private rayon ray;
	@ManyToOne(cascade = {CascadeType.ALL})
	private detailFacture detFact;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Stock stock;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idProdDet")
	private detailProduit prodDetails;
	@ManyToMany
	private List<Fournisseur> fournisseur;
	
	
	
	
}

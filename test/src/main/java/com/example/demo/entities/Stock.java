package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Stock implements Serializable  {
	/**
	 * 
	 */
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private Long idStock;
	private int qte;
	private int qteMin;
	private String libelleStock;
	
	@JsonIgnore
	@OneToMany(mappedBy="stock")
	private List<Produit> produits;
	
	public Stock (int qte,int qteMin, String libelleStock) {
		this.qte=qte;
		this.qteMin=qteMin;
		this.libelleStock=libelleStock;
	}
}

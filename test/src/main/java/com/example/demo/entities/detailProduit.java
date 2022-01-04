package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class detailProduit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idDetailProduit")
private int idDetailProduit; // Clé primaire
private Date dateCreation;
private Date dateDerniereModification;
private String password;
@Enumerated(EnumType.STRING)
private CategorieProduit categProd;

@OneToOne(mappedBy="prodDetails")
private Produit prod;

public int getIdDetailProduit() {
	return idDetailProduit;
}
public void setIdDetailProduit(int idDetailProduit) {
	this.idDetailProduit = idDetailProduit;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public Date getDateDerniereModification() {
	return dateDerniereModification;
}
public void setDateDerniereModification(Date dateDerniereModification) {
	this.dateDerniereModification = dateDerniereModification;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public CategorieProduit getCategProd() {
	return categProd;
}
public void setCategProd(CategorieProduit categProd) {
	this.categProd = categProd;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}

}

package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idClient")
private Long idClient; // Clé primaire
private String nom;
private String prenom;
private String email;
private String password;
@Temporal(TemporalType.DATE)
private Date dateNaissance;
@JsonIgnore
@OneToMany(mappedBy="client")
private List<Facture> factures;


@Enumerated(EnumType.STRING)
private Profession profession;
@Enumerated(EnumType.STRING)
private CategorieClient categorieClient;
// Constructeur et accesseurs (getters) et mutateurs (setters)





public Client(String nom, String prenom, String email, Date dateNaissance) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.dateNaissance = dateNaissance;
}



@Override
public String toString() {
	return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
			+ password + ", dateNaissance=" + dateNaissance + ", profession=" + profession + ", categorieClient="
			+ categorieClient + "]\n";
}


}
package com.mia.banque.impl;

import java.util.List;
import java.util.ArrayList;

import com.mia.banque.model.ICompte;

import com.mia.banque.model.IClient;

public class Client implements IClient {

private String Nom;

private String Prenom;

private String Adresse;


	private List<ICompte> Comptes;



public String getNom() {
	return this.Nom;
}

public String getPrenom() {
	return this.Prenom;
}

public String getAdresse() {
	return this.Adresse;
}


public void setNom(String Nom) {
	this.Nom = Nom;
}

public void setPrenom(String Prenom) {
	this.Prenom = Prenom;
}

public void setAdresse(String Adresse) {
	this.Adresse = Adresse;
}


public List<ICompte> getComptes() {
		if (this.Comptes == null) {
			this.Comptes = new ArrayList<ICompte>();
		}
		return this.Comptes;
	}
	public void setComptes(List<ICompte> newValue) {
		this.Comptes = newValue;
	}



}
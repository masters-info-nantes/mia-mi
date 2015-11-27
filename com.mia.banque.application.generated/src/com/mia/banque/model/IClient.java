package com.mia.banque.model;

import java.util.List;

public interface IClient {

public String getNom();
public String getPrenom();
public String getAdresse();

public void setNom(String Nom);
public void setPrenom(String Prenom);
public void setAdresse(String Adresse);


public List<ICompte> getComptes();
	public void setComptes(List<ICompte> newValue);

}
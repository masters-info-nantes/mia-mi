package com.mia.banque.impl;

import java.util.List;
import java.util.ArrayList;



import com.mia.banque.model.IOperation;

public class Operation implements IOperation {

private String Numero;

private String Montant;




public String getNumero() {
	return this.Numero;
}

public String getMontant() {
	return this.Montant;
}


public void setNumero(String Numero) {
	this.Numero = Numero;
}

public void setMontant(String Montant) {
	this.Montant = Montant;
}







}
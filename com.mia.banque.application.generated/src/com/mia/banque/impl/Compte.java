package com.mia.banque.impl;

import java.util.List;
import java.util.ArrayList;

import com.mia.banque.model.IOperation;

import com.mia.banque.model.ICompte;

public class Compte implements ICompte {

private String Numero;


	private List<IOperation> Operations;



public String getNumero() {
	return this.Numero;
}


public void setNumero(String Numero) {
	this.Numero = Numero;
}


public List<IOperation> getOperations() {
		if (this.Operations == null) {
			this.Operations = new ArrayList<IOperation>();
		}
		return this.Operations;
	}
	public void setOperations(List<IOperation> newValue) {
		this.Operations = newValue;
	}



}
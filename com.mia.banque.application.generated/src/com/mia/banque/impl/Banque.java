package com.mia.banque.impl;

import java.util.List;
import java.util.ArrayList;

import com.mia.banque.model.IClient;

import com.mia.banque.model.IBanque;

public class Banque implements IBanque {


	private List<IClient> Clients;





public List<IClient> getClients() {
		if (this.Clients == null) {
			this.Clients = new ArrayList<IClient>();
		}
		return this.Clients;
	}
	public void setClients(List<IClient> newValue) {
		this.Clients = newValue;
	}



}
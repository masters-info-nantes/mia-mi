package com.mia.banque.ui.controller.swt;

import org.eclipse.swt.widgets.Display;

import com.mia.banque.ui.controller.IBanqueController;
import com.mia.banque.model.IBanque;
import com.mia.banque.ui.view.swt.BanqueView;

public class BanqueController implements IBanqueController {

	private BanqueView view;
	private IBanque model;

	public BanqueController(IBanque model) {
		this.model = model;
	}

	public void initView(){
		Display display = Display.getDefault();
		
		
		this.view = new BanqueView(display, this.model, this);
		this.view.open();
		this.view.layout();
		
		while (!this.view.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void afficherClient(){
		
		// Start of user code for afficherClient
		if (this.view.Clients.getSelection().length >0) {
			String clientSelection = this.view.Clients.getSelection()[0];
			for (final com.mia.banque.model.IClient aClient : this.model.getClients()) {
				if (aClient.toString().equals(clientSelection)) { // TODO gerer un champ id plutôt que utiliser toString()
					ClientController clientController = new ClientController(aClient);
					clientController.initView();
				}
			}
		}
		// End of user code for afficherClient
	}
	public void quitter(){
		Display.getCurrent().dispose();
		// Start of user code for quitter
		
		// End of user code for quitter
	}


}
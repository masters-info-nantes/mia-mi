package com.mia.banque.ui.controller.swt;

import org.eclipse.swt.widgets.Display;

import com.mia.banque.ui.controller.IClientController;
import com.mia.banque.model.IClient;
import com.mia.banque.ui.view.swt.ClientView;

public class ClientController implements IClientController {

	private ClientView view;
	private IClient model;

	public ClientController(IClient model) {
		this.model = model;
	}

	public void initView(){
		Display display = Display.getDefault();
		
		
		this.view = new ClientView(display, this.model, this);
		this.view.open();
		this.view.layout();
		
		while (!this.view.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void afficherCompte(){
		
		// Start of user code for afficherCompte
		if (this.view.Comptes.getSelection().length >0) {
			String compteSelection = this.view.Comptes.getSelection()[0];
			for (final com.mia.banque.model.ICompte aCompte : this.model.getComptes()) {
				if (aCompte.toString().equals(compteSelection)) { // TODO gerer un champ id plutôt que utiliser toString()
					CompteController compteControler = new CompteController(aCompte);
					compteControler.initView();
				}
			}
		}
		// End of user code for afficherCompte
	}
	public void quitter(){
		Display.getCurrent().dispose();
		// Start of user code for quitter

		// End of user code for quitter
	}


}
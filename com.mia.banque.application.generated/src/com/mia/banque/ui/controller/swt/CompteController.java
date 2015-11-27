package com.mia.banque.ui.controller.swt;

import org.eclipse.swt.widgets.Display;

import com.mia.banque.ui.controller.ICompteController;
import com.mia.banque.model.ICompte;
import com.mia.banque.ui.view.swt.CompteView;

public class CompteController implements ICompteController {

	private CompteView view;
	private ICompte model;

	public CompteController(ICompte model) {
		this.model = model;
	}

	public void initView(){
		Display display = Display.getDefault();
		
		
		this.view = new CompteView(display, this.model, this);
		this.view.open();
		this.view.layout();
		
		while (!this.view.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void afficherOperation(){
		
		// Start of user code for afficherOperation
		if (this.view.Operations.getSelection().length >0) {
			String compteSelection = this.view.Operations.getSelection()[0];
			for (final com.mia.banque.model.IOperation aOp : this.model.getOperations()) {
				if (aOp.toString().equals(compteSelection)) { // TODO gerer un champ id plutôt que utiliser toString()
					OperationController opeController = new OperationController(aOp);
					opeController.initView();
				}
			}
		}
		// End of user code for afficherOperation
	}
	public void quitter(){
		Display.getCurrent().dispose();
		// Start of user code for quitter

		// End of user code for quitter
	}


}
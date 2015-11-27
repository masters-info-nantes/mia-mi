package com.mia.banque.ui.view.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import com.mia.banque.ui.view.ICompteView;
import com.mia.banque.model.ICompte;
import com.mia.banque.ui.controller.ICompteController;
import com.mia.banque.model.IOperation;

public class CompteView extends Shell  implements ICompteView{

	private ICompteController controller;
	private ICompte model;
	
	public List Operations;
	
	private Button btnafficherOperation;
	private Button btnquitter;

		
	public CompteView(Display display, ICompte model,  ICompteController controller){
		super(display, SWT.SHELL_TRIM);
		
		this.model = model;
		this.controller = controller;
		
		this.createContents();
	};
		
	public void afficherOperation(){
		controller.afficherOperation();
	}

	public void quitter(){
		controller.quitter();
	}



	private void createContents(){
		setText("Vue CompteView");
		setSize(458, 308);
		setLayout(new GridLayout(2, false));

				Label lblNumero = new Label(this, SWT.NONE);
		lblNumero.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblNumero.setText("Numero");

		Text NumeroField = new Text(this, SWT.BORDER);
		NumeroField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		NumeroField.setText(this.model.getNumero());
		
		

		Group grpOperation = new Group(this, SWT.NONE);
		grpOperation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		grpOperation.setText("Liste des Operations");
		grpOperation.setLayout(new GridLayout());

		this.Operations = new List(grpOperation, SWT.BORDER | SWT.V_SCROLL | SWT.SINGLE);
		this.Operations.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		for (final IOperation elt : this.model.getOperations()) {
			this.Operations.add(elt.toString());
		}
	
		Group grpButtons = new Group(this, SWT.NONE);
		grpButtons.setLayout(new GridLayout(2, false));
		
				btnafficherOperation = new Button(grpButtons, SWT.NONE);
		btnafficherOperation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		btnafficherOperation.setText("afficherOperation");
		btnafficherOperation.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event)
			{
				afficherOperation();
			}
		 });		btnquitter = new Button(grpButtons, SWT.NONE);
		btnquitter.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		btnquitter.setText("quitter");
		btnquitter.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event)
			{
				quitter();
			}
		 });
	};
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
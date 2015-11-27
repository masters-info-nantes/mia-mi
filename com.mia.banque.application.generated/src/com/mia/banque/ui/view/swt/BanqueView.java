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

import com.mia.banque.ui.view.IBanqueView;
import com.mia.banque.model.IBanque;
import com.mia.banque.ui.controller.IBanqueController;
import com.mia.banque.model.IClient;

public class BanqueView extends Shell  implements IBanqueView{

	private IBanqueController controller;
	private IBanque model;
	
	public List Clients;
	
	private Button btnafficherClient;
	private Button btnquitter;

		
	public BanqueView(Display display, IBanque model,  IBanqueController controller){
		super(display, SWT.SHELL_TRIM);
		
		this.model = model;
		this.controller = controller;
		
		this.createContents();
	};
		
	public void afficherClient(){
		controller.afficherClient();
	}

	public void quitter(){
		controller.quitter();
	}



	private void createContents(){
		setText("Vue BanqueView");
		setSize(458, 308);
		setLayout(new GridLayout(2, false));

		

		Group grpClient = new Group(this, SWT.NONE);
		grpClient.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		grpClient.setText("Liste des Clients");
		grpClient.setLayout(new GridLayout());

		this.Clients = new List(grpClient, SWT.BORDER | SWT.V_SCROLL | SWT.SINGLE);
		this.Clients.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		for (final IClient elt : this.model.getClients()) {
			this.Clients.add(elt.toString());
		}
	
		Group grpButtons = new Group(this, SWT.NONE);
		grpButtons.setLayout(new GridLayout(2, false));
		
				btnafficherClient = new Button(grpButtons, SWT.NONE);
		btnafficherClient.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		btnafficherClient.setText("afficherClient");
		btnafficherClient.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event)
			{
				afficherClient();
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
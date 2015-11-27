package com.mia.formation.generation.ui;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public class CompteView extends Shell{
private Button btnafficherOperation;
private Button btnquitter;


/**
	 * Create the shell.
	 * @param display
	 */
	public CompteView(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Vue du compte");
		setSize(450, 300);

	}

public void afficherOperation()
{
// Start of user code for afficherOperation
// End of user code
}
public void quitter()
{
// Start of user code for quitter
// End of user code
}



}
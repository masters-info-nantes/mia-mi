package com.mia.banque.ui.controller.swt;

import org.eclipse.swt.widgets.Display;

import com.mia.banque.ui.controller.IOperationController;
import com.mia.banque.model.IOperation;
import com.mia.banque.ui.view.swt.OperationView;

public class OperationController implements IOperationController {

	private OperationView view;
	private IOperation model;

	public OperationController(IOperation model) {
		this.model = model;
	}

	public void initView(){
		Display display = Display.getDefault();
		
		
		this.view = new OperationView(display, this.model, this);
		this.view.open();
		this.view.layout();
		
		while (!this.view.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void quitter(){
		Display.getCurrent().dispose();
		// Start of user code for quitter

		// End of user code for quitter
	}


}
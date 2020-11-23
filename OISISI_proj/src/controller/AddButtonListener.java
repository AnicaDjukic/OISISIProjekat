package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;
import controller.*;

public class AddButtonListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		
		switch(tab) {
		case 0:
			//Add za studente
			AddOrEditDialog dialog = new AddOrEditDialog(AddOrEditDialog.add_mode);
			dialog.setVisible(true);
			break;
		case 1:
			//Add za profesore
			AddOrEditDialog aoed = new AddOrEditDialog(AddOrEditDialog.add_mode);
			aoed.setVisible(true);
			break;
		case 2:
			//Add za predmete
		}
		
	}

}

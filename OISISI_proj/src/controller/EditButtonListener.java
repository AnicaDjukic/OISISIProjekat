package controller;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;

public class EditButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		AddOrEditDialog aoed;
		
		int rowCheck;
		rowCheck = TabelaProfesora.inst.getSelectedRow();
		if(rowCheck == -1)
			return;
		
		switch(tab) {
		case 0:
			//Edit za studente
			break;
		case 1:
			//Edit za profesore
			aoed = new AddOrEditDialog(AddOrEditDialog.edit_mode);
			aoed.setVisible(true);
			break;
		case 2:
			//Edit za predmete
			break;
		}
		
	}

}

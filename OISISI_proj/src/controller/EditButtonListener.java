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
		
		int rowCheck, rowCheckPred;
		rowCheck = TabelaProfesora.inst.getSelectedRow();
		rowCheckPred = TabelaPredmeti.inst.getSelectedRow();
		if(rowCheck == -1 && rowCheckPred == -1)
			return;
		
		switch(tab) {
		case 0:
			//Edit za studente
			break;
		case 1:
			//Edit za profesore
			aoed = new AddOrEditDialog(AddOrEditDialog.editMode);
			aoed.setVisible(true);
			break;
		case 2:
			//Edit za predmete
			aoed = new AddOrEditDialog(AddOrEditDialog.editMode);
			aoed.pack();
			aoed.setVisible(true);
			break;
		}
		
	}

}

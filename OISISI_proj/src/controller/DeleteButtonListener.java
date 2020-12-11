package controller;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.*;
import model.GlobalConstants;

public class DeleteButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		
		
		switch(tab) {
		case 0 :
			//brisanje studenta
			break;
		case 1:
			//brisanje profesora
			break;
		case 2:
			//brisanje predmeta
			int selectedPred = TabelaPredmeti.inst.getSelectedRow();

			if(selectedPred != -1) {
				String [] options = {GlobalConstants.yesOpt, GlobalConstants.noOpt};
				int code = JOptionPane.showOptionDialog(GlavniProzor.getGlavniProzor(), GlobalConstants.upitBrisanjePred, GlobalConstants.upitBrisanjePredTitle, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
			
				if(code == JOptionPane.YES_OPTION) {
					String delSifPred = (String)TabelaPredmeti.inst.getValueAt(selectedPred, 0);
					GlavniProzor.getControllerPredmet().obrisiPredmet(delSifPred);
					TabelaPredmeti.azurirajTabelu();
					GlavniProzor.serialize();
				}
			}
			break;
		}
		
	}

}

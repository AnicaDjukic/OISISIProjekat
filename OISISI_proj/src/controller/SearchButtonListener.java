package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import view.*;
import controller.*;

public class SearchButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		
		switch(tab) {
		case 0:
			//Search za studente
			break;
		case 1:
			//Search za profesora
			prikaziProfesore();
			break;
		case 2:
			//search za predmete
			break;
		}
		
	}
	
	//Implementirane funkcije za prikaz :
	void prikaziProfesore() {
		String text = Toolbar.srchField.getText();
		text = text.trim();
		text = text.toLowerCase();
		String words[] = text.split(" ");
		ArrayList<String> foundP = new ArrayList<String>();
		if(words.length != 1 && words.length != 2) {
			TabelaProfesora.inst = new TabelaProfesora();
			return;
		}
			
		else {
			foundP = GlavniProzor.getControllerProfesor().pretraziProf(words);
		}
		
		TabelaProfesora.izlistajProfesore(foundP);
	}
}


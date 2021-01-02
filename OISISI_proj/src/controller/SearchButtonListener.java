package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import view.*;
import controller.*;

public class SearchButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Toolbar.srchField.setForeground(Color.black);
		
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
			prikaziPredmete();
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
			TabelaProfesora.azurirajTabelu();
			Toolbar.srchField.setForeground(Color.red);
			return;
		}
			
		else {
			foundP = GlavniProzor.getControllerProfesor().pretraziProf(words);
		}
		
		TabelaProfesora.izlistajProfesore(foundP);
	}
	
	void prikaziPredmete() {
		String text = Toolbar.srchField.getText();
		text = text.trim();
		text = text.toLowerCase();
		ArrayList<String> foundP = new ArrayList<String>();
		if(text.indexOf(" ") != -1) {
			TabelaPredmeti.azurirajTabelu();
			Toolbar.srchField.setForeground(Color.red);
			return;
		}
		else {
			foundP = GlavniProzor.getControllerPredmet().pretraziPred(text);
		}
		
		TabelaPredmeti.izlistajPredmete(foundP);
	}
}


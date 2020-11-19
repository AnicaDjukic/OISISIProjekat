package controller;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import view.*;

public class ProfesorFocusListeners implements FocusListener{

	String input;
	String name;
	boolean check;
	@Override
	public void focusGained(FocusEvent e) {
		JTextField tx = (JTextField) e.getComponent();
		if(tx.getForeground() == Color.RED) {
			tx.setForeground(Color.BLACK);
		}
		
		input = tx.getText();
		name = tx.getName();
		
		check = getValue(input);                               //Ocekuje da kad udje ce uslov sigurno biti netacan dok se ne ispravi
		if(!check)
			AddOrEditProfesor.brPraznihPolja++;
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		JTextField tx = (JTextField) e.getComponent();
		
		input = tx.getText();
		name = tx.getName();
		
		check = getValue(input);
		
		if(!check) {
			AddOrEditProfesor.brPraznihPolja--;
			tx.setForeground(Color.RED);
		}
		
		if(AddOrEditProfesor.brPraznihPolja == 0) 
			AddOrEditProfesor.ok.setEnabled(true);
		else
			AddOrEditProfesor.ok.setEnabled(false);
		
		if(input.equals(""))
			tx.setText("Obavezno polje!");
	}
	
	public boolean getValue(String input0) {
		boolean ret = false;
		if(name.equals("ime") || name.equals("prezime"))
			ret = Checker.isNameOrSurename(input);
		if(name.equals("drp"))
			ret = Checker.isValidDate(input);
		if(name.equals("adrKanc") || name.equals("adrStan"))
			ret = Checker.isValidAdrress(input);
		if(name.equals("kontel") || name.equals("brLicKart"))
			ret = Checker.isValidNumber(input);
		if(name.equals("email"))
			ret = Checker.isValidEmail(input);
		if(name.equals("titula") || name.equals("zvanje"))
			ret = Checker.isValidTitOrMaj(input);
		
		return ret;
	}

}

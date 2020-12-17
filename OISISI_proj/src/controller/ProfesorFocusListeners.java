package controller;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import model.GlobalConstants;
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
			tx.setText("");
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
			tx.setText(GlobalConstants.obvPolje);
		System.out.println(AddOrEditProfesor.brPraznihPolja);
	}
	
	public boolean getValue(String input0) {
		boolean ret = false;
		if(name.equals(GlobalConstants.imeLab) || name.equals(GlobalConstants.przLab))
			ret = Checker.isNameOrSurename(input);
		if(name.equals(GlobalConstants.drLab))
			ret = Checker.isValidDate(input);
		if(name.equals(GlobalConstants.adrKancLab) || name.equals(GlobalConstants.adrStanLab))
			ret = Checker.isValidAdrress(input);
		if(name.equals(GlobalConstants.konTelLab))
			ret = Checker.isValidNumber(input,0);
		if(name.equals(GlobalConstants.brLicKartLab))
			ret = Checker.isValidNumber(input,1);
		if(name.equals(GlobalConstants.emailLab))
			ret = Checker.isValidEmail(input);
		if(name.equals(GlobalConstants.titulaLab) || name.equals(GlobalConstants.zvanjeLab))
			ret = Checker.isValidTitOrMaj(input);
		
		return ret;
	}
}

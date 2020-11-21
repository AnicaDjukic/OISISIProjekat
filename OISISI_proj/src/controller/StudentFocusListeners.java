package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import model.GlobalConstants;

public class StudentFocusListeners implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		if(txt.getForeground() == Color.RED) {
			txt.setText("");
			txt.setForeground(Color.BLACK);
		}
		
		String name = txt.getName();
		String input = txt.getText();
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		
		String name = txt.getName();
		String input = txt.getText();
		
		if(!regularInput(name, input) || txt.getText().trim().equals("")) {
			txt.setForeground(Color.RED);
		}
			
		if(txt.getText().trim().equals("") || txt.getText().trim().equals(GlobalConstants.obvPolje))
			txt.setText(GlobalConstants.obvPolje);
	}
	
	public boolean regularInput(String name, String input) {

		if(name.equals(GlobalConstants.imeLab) || name.equals(GlobalConstants.przLab))
			return Checker.isNameOrSurename(input);
		if(name.equals(GlobalConstants.drLab))
			return Checker.isValidDate(input);
		if(name.equals(GlobalConstants.adrStanLab))
			return Checker.isValidAdrress(input);
		if(name.equals(GlobalConstants.konTelLab))
			return Checker.isValidNumber(input, 0);
		if(name.equals(GlobalConstants.emailLab))
			return Checker.isValidEmail(input);
		if(name.equals(GlobalConstants.indexLab) || name.equals(GlobalConstants.upisLab))
			return true;
		
		return false;
	}

}

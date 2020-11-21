package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import model.GlobalConstants;
import view.AddOrEditStudent;

public class StudentFocusListeners implements FocusListener {

	boolean smanjila;
	
	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
	
		if(txt.getForeground() == Color.RED)
			txt.setForeground(Color.BLACK);
		
		if(txt.getText().trim().equals(GlobalConstants.obvPolje)) {
			txt.setText("");
			txt.setForeground(Color.BLACK);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		
		String name = txt.getName();
		String input = txt.getText();
		
		if(!regularInput(name, input)) 
			txt.setForeground(Color.RED);
		
		enableOrDisableButton();
		
		if(txt.getText().trim().equals("") || txt.getText().trim().equals(GlobalConstants.obvPolje)) {
			txt.setText(GlobalConstants.obvPolje);
			txt.setForeground(Color.RED);
		}
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
	
	public void enableOrDisableButton() {
		boolean enableButton = true;
		if(AddOrEditStudent.tIme.getForeground() == Color.RED || AddOrEditStudent.tIme.getText().trim().equals(""))
			enableButton = false;
		
		if(AddOrEditStudent.tPrezime.getForeground() == Color.RED || AddOrEditStudent.tPrezime.getText().trim().equals(""))
			enableButton = false;
		
		if(AddOrEditStudent.tDatRodj.getForeground() == Color.RED || AddOrEditStudent.tDatRodj.getText().trim().equals(""))
			enableButton = false;
		
		if(AddOrEditStudent.tAdrStan.getForeground() == Color.RED || AddOrEditStudent.tAdrStan.getText().trim().equals(""))
			enableButton = false;
		
		if(AddOrEditStudent.tBrTel.getForeground() == Color.RED || AddOrEditStudent.tBrTel.getText().trim().equals(""))
			enableButton = false;
			
		if(AddOrEditStudent.tEmail.getForeground() == Color.RED || AddOrEditStudent.tEmail.getText().trim().equals(""))
			enableButton = false;
		
		if(AddOrEditStudent.tBrIndexa.getForeground() == Color.RED || AddOrEditStudent.tBrIndexa.getText().trim().equals(""))
			enableButton = false;
		
		if(AddOrEditStudent.tGodUpisa.getForeground() == Color.RED || AddOrEditStudent.tGodUpisa.getText().trim().equals(""))
			enableButton = false;
		
		
		AddOrEditStudent.potvrdi.setEnabled(enableButton);
	}
	

}

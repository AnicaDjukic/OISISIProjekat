package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.GlobalConstants;
import view.AddOrEditStudent;

public class StudentFocusListeners implements FocusListener {
	
	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
	
		txt.setForeground(Color.BLACK);
		txt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		
		String name = txt.getName();
		String input = txt.getText();
		
		if(!regularInput(name, input)) {
			txt.setBorder(BorderFactory.createLineBorder(Color.RED));
			txt.setForeground(Color.RED);
		}
		
		enableOrDisableButton();
		
		if(txt.getText().trim().equals("")) 
			txt.setBorder(BorderFactory.createLineBorder(Color.RED));
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
		if(name.equals(GlobalConstants.indexLab)) {
			if(!AddOrEditStudent.tGodUpisa.getText().equals("")) {
				return (Checker.isValidIndex(input) && input.substring(input.length()-4).equals(AddOrEditStudent.tGodUpisa.getText()));
			} else {
				return Checker.isValidIndex(input);
			} 
		}
		if(name.equals(GlobalConstants.upisLab)) {
			if(!AddOrEditStudent.tBrIndexa.getText().equals("")) {
				return (Checker.isValidYear(input) && AddOrEditStudent.tBrIndexa.getText().substring(AddOrEditStudent.tBrIndexa.getText().length()-4).equals(input));
			}
			else {
				System.out.println(input);
				return Checker.isValidYear(input);
			}
		}
		
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

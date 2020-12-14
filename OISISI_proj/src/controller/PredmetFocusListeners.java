package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import model.GlobalConstants;
import view.AddOrEditPredmet;

public class PredmetFocusListeners implements FocusListener {

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

	private boolean regularInput(String name, String input) {

		if(name.equals(GlobalConstants.sifraLab))
			return true;
		if(name.equals(GlobalConstants.nazivLab))
			return Checker.isValidNamePred(input);
		
		if(name.equals(GlobalConstants.espbLab))
			return Checker.isValidEspb(input);
		
		return false;
	}
	
	
	private void enableOrDisableButton() {
		boolean enableButton = true;
		
		if(AddOrEditPredmet.tSifra.getForeground() == Color.red || AddOrEditPredmet.tSifra.getText().trim().equals(""))
			enableButton = false;
		
		if(AddOrEditPredmet.tNaziv.getForeground() == Color.red || AddOrEditPredmet.tNaziv.getText().trim().equals(""))
			enableButton = false;
		
		if(AddOrEditPredmet.tEspb.getForeground() == Color.red || AddOrEditPredmet.tEspb.getText().trim().equals(""))
			enableButton = false;
		
		AddOrEditPredmet.potvrdi.setEnabled(enableButton);
	}
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.AdvSearDialog;


public class AdvSearchAl implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		AdvSearDialog adv = new AdvSearDialog();
		adv.setVisible(true);

	}

}

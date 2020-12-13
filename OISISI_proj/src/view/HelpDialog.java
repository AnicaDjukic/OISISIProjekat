package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.GlobalConstants;

public class HelpDialog extends JDialog {
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9,
				   label10, label11, label12, label13, label14, label15, label16, label17,
				   label18, label19, label20, label21;
	private JPanel panel;
	private JPanel buttom;
	
	public HelpDialog() {
		super();
		
		label1 = new JLabel("\t Aplikacija \"Studentska služba\" se sastoji od Menu bara, Tool bara i Status bara.\n");
    	label2 = new JLabel("\t Menu bar se sastoji od sledećih stavki:\n");
    	label3 = new JLabel(new ImageIcon(GlobalConstants.menuBarImg));
    	label4 = new JLabel("\t 1. File (Alt + F)\n");
    	label5 = new JLabel("\t New (Ctrl + N) - Dodavanje novog entiteta u sistem (studenta, profesora ili predmeta).\n", new ImageIcon(GlobalConstants.addImg), SwingConstants.LEFT);
    	label6 = new JLabel("\t Close (Ctrl + C) - Zatvaranje aplikacije.\n", new ImageIcon(GlobalConstants.closeImg), SwingConstants.LEADING);
    	label7 = new JLabel("\t 2. Edit (Alt + E)\n");
    	label8 = new JLabel("\t Edit (Ctrl + E) - Izmena postojećeg entiteta (studenta, profesora ili predmeta).\n", new ImageIcon(GlobalConstants.editImg), SwingConstants.LEFT);
    	label9 = new JLabel("\t Delete (Ctrl + D) - Brisanje postojećeg entiteta (studenta, profesora ili predmeta).\n", new ImageIcon(GlobalConstants.delImg), SwingConstants.LEFT);
    	label10 = new JLabel("\t 3. Help (Alt + H)\n");
    	label11 = new JLabel("\t Help (Ctrl + H) -  Prikaz informacija neophodnih za korišćenje aplikacije.\n", new ImageIcon(GlobalConstants.helpImg), SwingConstants.LEFT);
    	label12 = new JLabel("\t About (Ctrl + A) -  Prikaz verzije aplikacije, kao i kratak opis iste. Nakon toga sledi sažeta biografija autora.\n", new ImageIcon(GlobalConstants.aboutImg), SwingConstants.LEFT);
    	label13 = new JLabel("\t Svaka stavka menija ima svoju ikonicu koja se nalazi odmah pored njenog naziva.\n ");
    	label14 = new JLabel("\t Neke od tih ikonica se nalaze i u Tool baru:\n");
    	label15 = new JLabel(new ImageIcon(GlobalConstants.toolBarImg));
    	label16 = new JLabel("\t 1. New (Ctrl + N) \n", new ImageIcon(GlobalConstants.addImg), SwingConstants.LEFT);
    	label17 = new JLabel("\t 2. Edit (Ctrl + E) \n", new ImageIcon(GlobalConstants.editImg), SwingConstants.LEFT);
    	label18 = new JLabel("\t 3. Delete (Ctrl + D)\n", new ImageIcon(GlobalConstants.delImg), SwingConstants.LEFT);
    	label19 = new JLabel("\t Njihovim izborom se ostvaruju iste funkcionalnosti kao i izborom stavki menu bara sa istim imenom.");
    	label20 = new JLabel("\t Status bar se nalazi na dnu glavnog prozora i sastoji od imena aplikacije i prikaza trenutnog vremena i datuma.");
    	label21 = new JLabel("\t Kako se aplikacija bude dalje razvijala tako će ovaj Help dijalog biti naknadno proširen.");
		JLabel[] arr = {label1, label2, label3, label4, label5, label6, label7,
						label8, label9, label10, label11, label12, label13, label14,
						label15, label16, label17, label18, label19, label20, label21};
		
		Font font = new Font("Arial", Font.PLAIN, 16);
	
		for(JLabel l : arr) {
			l.setFont(font);
		}
		
		panel = new JPanel();
	    	panel.setLayout(new GridLayout(0,1));
		for (JLabel l : arr) {
	      	panel.add(l);
	    	}
		
		buttom = new JPanel();
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttom.add(ok);
		
	    setModal(true);
	    add(panel, BorderLayout.NORTH);
	    add(buttom, BorderLayout.SOUTH);
	    setTitle("Help");
	}
}

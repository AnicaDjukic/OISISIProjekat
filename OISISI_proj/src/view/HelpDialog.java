package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.GlobalConstants;

public class HelpDialog extends JDialog {
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9,
				   label10, label11, label12, label13, label14, label15, label16, label17,
				   label18, label19, label20, label21, label22, label23, label24, label25,
				   label26, label27, label28, label29, label30, label31;
	private JPanel panel;
	private JPanel buttom;
	
	public HelpDialog() {
		super();
		
		label1 = new JLabel("\t Aplikacija \"Studentska služba\" se sastoji od Menu bara, Tool bara i Status bara.\n");
    	label2 = new JLabel("\t Menu bar se sastoji od sledećih stavki:\n");
    	label3 = new JLabel(new ImageIcon(GlobalConstants.menuBarImg));
    	label4 = new JLabel("\t 1. File (Alt + F)\n");
    	label5 = new JLabel("\t New (Alt + N, Ctrl + N) - Dodavanje novog entiteta u sistem (studenta, profesora ili predmeta).\n", new ImageIcon(GlobalConstants.addImg), SwingConstants.LEFT);
    	label6 = new JLabel("\t Close (Alt + C, Ctrl + C) - Zatvaranje aplikacije.\n", new ImageIcon(GlobalConstants.closeImg), SwingConstants.LEADING);
    	label7 = new JLabel("\t 2. Edit (Alt + E)\n");
    	label8 = new JLabel("\t Edit (Alt + E, Ctrl + E) - Izmena postojećeg entiteta (studenta, profesora ili predmeta).\n", new ImageIcon(GlobalConstants.editImg), SwingConstants.LEFT);
    	label9 = new JLabel("\t Delete (Alt + D, Ctrl + D) - Brisanje postojećeg entiteta (studenta, profesora ili predmeta).\n", new ImageIcon(GlobalConstants.delImg), SwingConstants.LEFT);
    	label10 = new JLabel("\t 3. Help (Alt + H)\n");
    	label11 = new JLabel("\t Help (Alt + H, Ctrl + H) -  Prikaz informacija neophodnih za korišćenje aplikacije.\n", new ImageIcon(GlobalConstants.helpImg), SwingConstants.LEFT);
    	label12 = new JLabel("\t About (Alt + A, Ctrl + A) -  Prikaz verzije aplikacije, kao i kratak opis iste. Nakon toga sledi sažeta biografija autora.\n", new ImageIcon(GlobalConstants.aboutImg), SwingConstants.LEFT);
    	label13 = new JLabel("\t 4. Advanced (Alt + A) - Napredne opcije");
    	label14 = new JLabel("\t Language (Alt + L) - Omogućava izbor jednog od jezika (Srpski, Engleski)",  new ImageIcon(GlobalConstants.languageImg), SwingConstants.LEFT);
    	label15 = new JLabel("\t Search (Alt + S, Ctrl + S) - Omogućava naprednu pretragu entiteta preko uslovnih iskaza", new ImageIcon(GlobalConstants.advSearImg), SwingConstants.LEFT);
    	label16 = new JLabel("\t Svaka stavka menija ima svoju ikonicu koja se nalazi odmah pored njenog naziva.\n ");
    	label17 = new JLabel("\t Neke od tih ikonica se nalaze i u Tool baru:\n");
    	label18 = new JLabel(new ImageIcon(GlobalConstants.toolBarImg));
    	label19 = new JLabel("\t 1. New (Ctrl + N) \n", new ImageIcon(GlobalConstants.addImg), SwingConstants.LEFT);
    	label20 = new JLabel("\t 2. Edit (Ctrl + E) \n", new ImageIcon(GlobalConstants.editImg), SwingConstants.LEFT);
    	label21 = new JLabel("\t 3. Delete (Ctrl + D)\n", new ImageIcon(GlobalConstants.delImg), SwingConstants.LEFT);
    	label22 = new JLabel("\t 4. Search (Ctrl + S)\n", new ImageIcon(GlobalConstants.advSearImg), SwingConstants.LEFT);
    	label23 = new JLabel("\t Njihovim izborom se ostvaruju iste funkcionalnosti kao i izborom stavki menu bara sa istim imenom.");
    	label24 = new JLabel("\t U Tool baru se takođe nalazi polje za pretragu entiteta:");
    	label25 = new JLabel(new ImageIcon(GlobalConstants.searchFieldImg));
    	label26 = new JLabel("\t Pozicioniranjem na odgovarajući tab (Studenti, Profesori, Predmeti) omogućena je pretraga:");
    	label27 = new JLabel("<html> \t- Studenata: Unošenjem jedne ili dve ili tri reči, gde je prva obavezna i odnosi se na deo prezimena studenta, "
    						+ "<br> druga, odnosno treća reč su opcione i odnose se na deo imena, odnosno broja indeksa studenta.</hmtl>");
    	label28 = new JLabel("<html> \t - Profesora: Unošenjem jedne ili dve reči, gde je prva obavezna i odnosi se na deo prezimena profesora,"
    						+ "<br> druga reč je opciona i odnosi se na deo imena profesora.</hmtl>");
    	label29 = new JLabel("- Predmeta: Unošenjem jedne reči koja se odnosi na deo naziva predmeta.");
    	label30 = new JLabel("\t Status bar se nalazi na dnu glavnog prozora i sastoji od imena aplikacije i prikaza trenutnog vremena i datuma.");
    	label31 = new JLabel("\t Kako se aplikacija bude dalje razvijala tako će ovaj Help dijalog biti naknadno proširen.");
		JLabel[] arr = {label1, label2, label3, label4, label5, label6, label7,
						label8, label9, label10, label11, label12, label13, label14,
						label15, label16, label17, label18, label19, label20, label21, label22, label23, label24, label25,
						label26, label27, label28, label29, label30, label31};
		
		Font font = new Font("Arial", Font.PLAIN, 15);
	
		for(JLabel l : arr) {
			l.setFont(font);
		}
		
		panel = new JPanel();
	    panel.setLayout(new GridLayout(0,1));
		
	   for (JLabel l : arr) {
		   panel.add(l);
	    }
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setViewportView(panel);
	    getContentPane().add(scrollPane, BorderLayout.CENTER);
	    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
	    
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
	    setPreferredSize(new Dimension(800, 600));
	    setResizable(false);
	    setTitle("Help");
	}
}

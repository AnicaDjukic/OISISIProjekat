package view;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import controller.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;

public class MyMenuBar extends JMenuBar {
	
	ControllerProfesor cProf;
	ControllerPredmet cPred;
	ControllerStudent cStud;
	
	public MyMenuBar() {
		
		JMenu mFile = new JMenu("File");
		JMenuItem miNew = new JMenuItem("Dodaj novog", new ImageIcon("images/add_button.png"));
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miNew.addActionListener(new AddButtonListener());
		JMenuItem miClose = new JMenuItem("Zatvori", new ImageIcon("images/close_button.png"));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		mFile.setMnemonic(KeyEvent.VK_F);
		mFile.add(miNew);
		mFile.addSeparator();
		mFile.add(miClose);
		
		JMenu mEdit = new JMenu("Izmeni");
		JMenuItem miEdit = new JMenuItem("Izmeni", new ImageIcon("images/edit_button.png"));
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miEdit.addActionListener(new EditButtonListener());
		JMenuItem miDelete = new JMenuItem("Obriši", new ImageIcon("images/bin_button.png"));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miDelete.addActionListener(new DeleteButtonListener());
		
		mEdit.setMnemonic(KeyEvent.VK_E);
		mEdit.add(miEdit);
		mEdit.addSeparator();
		mEdit.add(miDelete);
		
		JMenu mHelp = new JMenu("Pomoæ");
		JMenuItem miHelp = new JMenuItem("Pomoæ", new ImageIcon("images/help_button.png"));
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		miHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel label1 = new JLabel("Aplikacija 'Studentska služba' se sastoji od Menu bara, Tool bara i Status bara.\n");
		    	JLabel label2 = new JLabel("Menu bar se sastoji od sledeæih stavki:\n");
		    	JLabel label3 = new JLabel(new ImageIcon("images/Menu_Bar.png"));
		    	JLabel label4 = new JLabel("\t 1. File (Alt + F)\n");
		    	JLabel label5 = new JLabel(" Dodaj novog (Ctrl + N) - Dodavanje novog entiteta u sistem (studenta, profesora ili predmeta).\n", new ImageIcon("images/add_button.png"), SwingConstants.LEFT);
		    	JLabel label6 = new JLabel(" Zatvori (Ctrl + C) - Zatvaranje aplikacije.\n", new ImageIcon("images/close_button.png"), SwingConstants.LEFT);
		    	JLabel label7 = new JLabel("\t 2. Izmeni (Alt + E)\n");
		    	JLabel label8 = new JLabel(" Izmeni (Ctrl + E) - Izmena postojeæeg entiteta (studenta, profesora ili predmeta).\n", new ImageIcon("images/edit_button.png"), SwingConstants.LEFT);
		    	JLabel label9 = new JLabel(" Obriši (Ctrl + D) - Brisanje postojeæeg entiteta (studenta, profesora ili predmeta).\n", new ImageIcon("images/bin_button.png"), SwingConstants.LEFT);
		    	JLabel label10 = new JLabel("\t 3. Pomoæ (Alt + P)\n");
		    	JLabel label11 = new JLabel(" Pomoæ (Ctrl + P) - Prikaz informacije neophodne za korišæenje aplikacije.\n", new ImageIcon("images/help_button.png"), SwingConstants.LEFT);
		    	JLabel label12 = new JLabel(" O aplikaciji (Ctrl + A) -  Prikaz verzije aplikacije, kao i kratak opis iste. Nakon toga sledi sažeta biografija svakog autora.\n", new ImageIcon("images/about_button.png"), SwingConstants.LEFT);
		    	JLabel label13 = new JLabel("Svaka stavka menija ima svoju ikonicu koja se nalazi odmah pored njenog naziva.\n ");
		    	JLabel label14 = new JLabel("Neke od tih ikonica se nalaze i u Tool baru:\n");
		    	JLabel label15 = new JLabel(new ImageIcon("images/Tool_Bar.png"));
		    	JLabel label16 = new JLabel("\t 1. Dodaj novog (Ctrl + N) \n", new ImageIcon("images/add_button.png"), SwingConstants.LEFT);
		    	JLabel label17 = new JLabel("\t 2. Izmeni (Ctrl + E) \n", new ImageIcon("images/edit_button.png"), SwingConstants.LEFT);
		    	JLabel label18 = new JLabel("\t 3. Obriši (Ctrl + D)\n", new ImageIcon("images/bin_button.png"), SwingConstants.LEFT);
		    	JLabel label19 = new JLabel("Njihovim izborom se ostvaruju iste funkcionalnosti kao i izborom stavki menu bara sa istim imenom.");
		    	JLabel label20 = new JLabel("Status bar se nalazi na dnu glavnog prozora i sastoji od imena aplikacije i prikaza trenutnog vremena i datuma.");
		    	JLabel label21 = new JLabel("Kako se aplikacija bude dalje razvijala tako æe ovaj Help dijalog biti naknadno proširen.");
		    	
		    	JLabel[] arr = {label1, label2, label3, label4, label5, label6, label7,
		    					label8, label9, label10, label11, label12, label13, label14,
		    			        label15, label16, label17, label18, label19, label20, label21};
		    	Font font = new Font("Arial", Font.PLAIN, 16);
		    	
		    	for(JLabel l : arr) {
		    		l.setFont(font);
		    	}
		    	    	
		    	JOptionPane.showMessageDialog(null, arr, "Help", JOptionPane.PLAIN_MESSAGE);
				
			}
			
		});
		
		JMenuItem miAbout = new JMenuItem("O aplikaciji", new ImageIcon("images/about_button.png"));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		mHelp.setMnemonic(KeyEvent.VK_P);
		mHelp.add(miHelp);
		mHelp.addSeparator();
		mHelp.add(miAbout);
		
		
		add(mFile);
		add(mEdit);
		add(mHelp);
	}
}

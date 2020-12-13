package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerPredmet;
import model.GlobalConstants;
import model.Predmet;

public class AddOrEditPredmet extends JPanel {

	private Predmet predmet;
	private ControllerPredmet controller;
	
	private JLabel lSifra, lNaziv, lSemestar, lGodIzv, lProf, lEspb;
	public static JTextField tSifra, tNaziv, tProf, tEspb;
	private JComboBox<String> tSemestar, tGodIzv;
	public static JButton potvrdi, odustani;
	
	public AddOrEditPredmet(int mode, AddOrEditDialog dialog) {
		
		setLayout(new BorderLayout());
		
		JPanel glavni = new JPanel();
		glavni.setLayout(new BoxLayout(glavni, BoxLayout.Y_AXIS));
		
		lSifra = new JLabel(GlobalConstants.sifraLab);
		tSifra = new JTextField();
		tSifra.setName(GlobalConstants.sifraLab);
		
		lNaziv = new JLabel(GlobalConstants.nazivLab);
		tNaziv = new JTextField();
		tNaziv.setName(GlobalConstants.nazivLab);
		
		lSemestar = new JLabel(GlobalConstants.semestarLab);
		String[] semestar = {"Letnji", "Zimski"};
		tSemestar = new JComboBox<String>(semestar);
		
		
		lGodIzv = new JLabel(GlobalConstants.godIzvLab);
		String[] godIzv = {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
		tGodIzv = new JComboBox<String>(godIzv);
		
		
		lProf = new JLabel(GlobalConstants.profLab);
		tProf = new JTextField();
		tProf.setName(GlobalConstants.profLab);
		
		lEspb = new JLabel(GlobalConstants.espbLab);
		tEspb = new JTextField();
		tEspb.setName(GlobalConstants.espbLab);
		
		glavni.add(createPanel(lSifra, tSifra));
		glavni.add(createPanel(lNaziv, tNaziv));
		glavni.add(createListPanel(lSemestar, tSemestar));
		glavni.add(createListPanel(lGodIzv, tGodIzv));
		glavni.add(createPanel(lProf, tProf));
		glavni.add(createPanel(lEspb, tEspb));
		
		add(glavni, BorderLayout.NORTH);
		
        JPanel dugmad = new JPanel();
		
		potvrdi = new JButton(GlobalConstants.btnOkName);
		potvrdi.setEnabled(false);
		dugmad.add(potvrdi);
		
		odustani = new JButton(GlobalConstants.btnCncName);
		dugmad.add(odustani);
		
		add(dugmad,BorderLayout.SOUTH);
		
	}
	
	public JPanel createPanel(JLabel label, JTextField text) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(150, 25));
		panel.add(label);
		
		text.setPreferredSize(new Dimension(200, 25));
		panel.add(text);
		
		return panel;
	}
	
	public JPanel createListPanel(JLabel label, JComboBox<String> text) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(150, 25));
		panel.add(label);
		
		text.setPreferredSize(new Dimension(200, 25));
		panel.add(text);
		
		return panel;
	}
}

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControllerPredmet;
import model.GlobalConstants;
import model.Predmet;
import model.Predmet.GodIzv;
import model.Predmet.Semestar;
import model.Profesor;
import model.Student;

public class AddOrEditPredmet extends JPanel {

	private Predmet predmet;
	private ControllerPredmet controller;
	
	private JLabel lSifra, lNaziv, lGodIzv, lSemestar, lEspb, lProf;
	public static JTextField tSifra, tNaziv, tEspb, tProf;
	private JComboBox<String> tGodIzv, tSemestar;
	public static JButton plus, minus, potvrdi, odustani;
	private ErrorDialog err;
	
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
		
		lGodIzv = new JLabel(GlobalConstants.godIzvLab);
		String[] godIzv = {"1", "2", "3", "4"};
		tGodIzv = new JComboBox<String>(godIzv);
		
		lSemestar = new JLabel(GlobalConstants.semestarLab);
		String[] semestar = {"zimski", "letnji"};
		tSemestar = new JComboBox<String>(semestar);
		
		lEspb = new JLabel(GlobalConstants.espbLab);
		tEspb = new JTextField();
		tEspb.setName(GlobalConstants.espbLab);
		
		lProf = new JLabel(GlobalConstants.profLab);
		tProf = new JTextField();
		tProf.setName(GlobalConstants.profLab);
		
		plus = new JButton("+");
		minus = new JButton("-");
		
		JLabel lab = new JLabel();
		lab.setPreferredSize(new Dimension(150, 25));
		
		glavni.add(createPanel(lSifra, tSifra));
		glavni.add(createPanel(lNaziv, tNaziv));
		glavni.add(createListPanel(lGodIzv, tGodIzv));
		glavni.add(createListPanel(lSemestar, tSemestar));
		glavni.add(createPanel(lEspb, tEspb));
		glavni.add(createButtonPanel(lProf, tProf, plus, minus));
		glavni.add(lab);
		
		
		add(glavni, BorderLayout.NORTH);
		
        JPanel dugmad = new JPanel();
		
		potvrdi = new JButton(GlobalConstants.btnOkName);
		dugmad.add(potvrdi);
		
		odustani = new JButton(GlobalConstants.btnCncName);
		dugmad.add(odustani);
		
		add(dugmad,BorderLayout.SOUTH);
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
			
		});
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				predmet = new Predmet();
				predmet.setSifPred(tSifra.getText());
				predmet.setNaziv(tNaziv.getText().substring(0,1).toUpperCase() + tNaziv.getText().substring(1));
				
				switch((String) tGodIzv.getSelectedItem()) {
					case "1" : predmet.setGodIzv(GodIzv.PRVA); break;
					case "2" : predmet.setGodIzv(GodIzv.DRUGA); break;
					case "3" : predmet.setGodIzv(GodIzv.TRECA); break;
					case "4" : predmet.setGodIzv(GodIzv.CETVRTA); break;
				}
				
				switch((String) tSemestar.getSelectedItem()) {
					case "zimski" : predmet.setSemestar(Semestar.ZIMSKI); break;
					case "letnji" : predmet.setSemestar(Semestar.LETNJI); break;
				}
				
				predmet.setEspbBod(Integer.parseInt(tEspb.getText()));
				
				/*predmet.setProf(new Profesor("Mikic","Mika","1.1.1990",
					      "Micurinova 25","Micurinova 22","0655026516",
					      "blabla@gmail.com","00756612","Doktor","Stalni profesor"));*/
				
				dialog.setVisible(false);
				
				if(!controller.dodajPredmet(predmet))
					err = new ErrorDialog(GlobalConstants.errAddPred);
				else 
					TabelaPredmeti.azurirajTabelu();
			}
		});
		
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
	
	public JPanel createButtonPanel(JLabel label, JTextField text, JButton p, JButton m) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(150, 25));
		panel.add(label);
		
		text.setPreferredSize(new Dimension(100, 25));
		panel.add(text);
		
		p.setPreferredSize(new Dimension(45,25));
		m.setPreferredSize(new Dimension(45,25));
		panel.add(p);
		panel.add(m);
		
		return panel;
	}
}

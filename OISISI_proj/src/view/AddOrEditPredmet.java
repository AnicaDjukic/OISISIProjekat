package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Checker;
import controller.ControllerPredmet;
import controller.PredmetFocusListeners;
import model.GlobalConstants;
import model.Predmet;
import model.Predmet.GodIzv;
import model.Predmet.Semestar;
import model.Profesor;

public class AddOrEditPredmet extends JPanel {

	private Predmet predmet;
	private ControllerPredmet controller;
	
	private JLabel lSifra, lNaziv, lGodIzv, lSemestar, lEspb, lProf;
	public static JTextField tSifra, tNaziv, tEspb, tProf;
	private JComboBox<String> tGodIzv, tSemestar;
	public static JButton plus, minus, potvrdi, odustani;
	private ErrorDialog err;
	private AddProfToPredDialog addProf;
	
	public static AddOrEditPredmet inst;
	
	public AddOrEditPredmet(int mode, AddOrEditDialog dialog) {
		controller = GlavniProzor.getControllerPredmet();
		setLayout(new BorderLayout());
		
		JPanel glavni = new JPanel();
		glavni.setLayout(new BoxLayout(glavni, BoxLayout.Y_AXIS));
		
		lSifra = new JLabel(GlobalConstants.sifraLab);
		tSifra = new JTextField();
		tSifra.setName(GlobalConstants.sifraLab);
		
		lNaziv = new JLabel(GlobalConstants.nazivLab);
		tNaziv = new JTextField();
		tNaziv.setName(GlobalConstants.nazivLab);
		tNaziv.setToolTipText(GlobalConstants.nazivPredToolTip);
		
		lGodIzv = new JLabel(GlobalConstants.godIzvLab);
		String[] godIzv = {"1", "2", "3", "4"};
		tGodIzv = new JComboBox<String>(godIzv);
		
		lSemestar = new JLabel(GlobalConstants.semestarLab);
		String[] semestar = {"zimski", "letnji"};
		tSemestar = new JComboBox<String>(semestar);
		
		lEspb = new JLabel(GlobalConstants.espbLab);
		tEspb = new JTextField();
		tEspb.setName(GlobalConstants.espbLab);
		tEspb.setToolTipText(GlobalConstants.espbToolTip);
		
		lProf = new JLabel(GlobalConstants.profLab);
		tProf = new JTextField();
		tProf.setName(GlobalConstants.profLab);
		tProf.setToolTipText(GlobalConstants.profToolTip);
		tProf.setEditable(false);
		
		plus = new JButton("+");
		minus = new JButton("-");
		minus.setEnabled(false);
		
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
		
		// Focus listeners
		tSifra.addFocusListener(new PredmetFocusListeners());
		tNaziv.addFocusListener(new PredmetFocusListeners());
		tEspb.addFocusListener(new PredmetFocusListeners());
		tProf.addFocusListener(new PredmetFocusListeners());
		
        JPanel dugmad = new JPanel();
		
		potvrdi = new JButton(GlobalConstants.btnOkName);
		potvrdi.setEnabled(false);
		dugmad.add(potvrdi);
		
		odustani = new JButton(GlobalConstants.btnCncName);
		dugmad.add(odustani);
		
		add(dugmad,BorderLayout.SOUTH);
		
		
		if(mode == AddOrEditDialog.editMode) {
			
			int selectedRow = TabelaPredmeti.inst.getSelectedRow();
			if(selectedRow != -1) {
				String sifraSelectedPred = (String) TabelaPredmeti.inst.getValueAt(selectedRow, 0);
;
				Predmet pred = controller.nadjiPredmet(sifraSelectedPred);
				tSifra.setText(pred.getSifPred());
				tNaziv.setText(pred.getNaziv());
				
				tGodIzv.setSelectedItem(pred.getGodIzv());
				tSemestar.setSelectedItem(pred.getSemestar());
				
				String espb = String.valueOf(pred.getEspbBod());
				tEspb.setText(espb);
				
				Profesor prof = pred.getProf();
				tProf.setText(prof.getIme() + " " + prof.getPrezime());
				if(prof.getIme() != "") {
					plus.setEnabled(false);
					minus.setEnabled(true);
				}

			}
		}
		
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
				
				GlavniProzor.getControllerProfesor().dodajProfesoraNaPredmet(AddProfToPredDialog.prof, predmet);
				
				dialog.setVisible(false);
				
				if(!controller.dodajPredmet(predmet))
					err = new ErrorDialog(GlobalConstants.errAddPred);
				else 
					TabelaPredmeti.azurirajTabelu();
				
				GlavniProzor.serialize();
			}
		});
		
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				addProf = new AddProfToPredDialog();
				addProf.setVisible(true);
			}
		});
		
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				tProf.setText("");
				plus.setEnabled(true);
				minus.setEnabled(false);
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

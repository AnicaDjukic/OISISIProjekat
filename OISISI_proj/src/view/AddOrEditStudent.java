package view;


import model.*;
import model.Student.StatusStudenta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import controller.ControllerStudent;
import controller.StudentFocusListeners;

public class AddOrEditStudent extends JPanel {
	
	private Student student;
	private ControllerStudent controller;
	
	public static JTextField tIme, tPrezime, tDatRodj, tAdrStan, tBrTel, tEmail, tBrIndexa, tGodUpisa;
	private JLabel lIme, lPrezime, lDatRodj, lAdrStan, lBrTel, lEmail, lBrIndexa, lGodUpisa, lTrenutnaGod, lFinans;
	private JComboBox<String>  tTrenutnaGod, tFinans;
	public static JButton potvrdi, odustani;
	private ErrorDialog err;
	
	
	public AddOrEditStudent(int mode, AddOrEditDialog dialog) {
		controller = GlavniProzor.getControllerStudent();
		setLayout(new BorderLayout());
				
		JPanel glavni = new JPanel();
		glavni.setLayout(new BoxLayout(glavni, BoxLayout.Y_AXIS));
		
		lIme = new JLabel(GlobalConstants.imeLab);
		tIme = new JTextField();
		tIme.setName(GlobalConstants.imeLab);
		tIme.setToolTipText(GlobalConstants.przImeToolTip);
		
		lPrezime = new JLabel(GlobalConstants.przLab);
		tPrezime = new JTextField();
		tPrezime.setName(GlobalConstants.przLab);
		tPrezime.setToolTipText(GlobalConstants.przImeToolTip);
		
		lDatRodj = new JLabel(GlobalConstants.drLab);
		tDatRodj = new JTextField();
		tDatRodj.setName(GlobalConstants.drLab);
		tDatRodj.setToolTipText(GlobalConstants.drpToolTip);
		
		lAdrStan = new JLabel(GlobalConstants.adrStanLab);
		tAdrStan = new JTextField();
		tAdrStan.setName(GlobalConstants.adrStanLab);
		tAdrStan.setToolTipText(GlobalConstants.adrToolTip);
		
		lBrTel = new JLabel(GlobalConstants.konTelLab);
		tBrTel = new JTextField();
		tBrTel.setName(GlobalConstants.konTelLab);
		tBrTel.setToolTipText(GlobalConstants.konTelToolTip);
		
		lEmail = new JLabel(GlobalConstants.emailLab);
		tEmail = new JTextField();
		tEmail.setName(GlobalConstants.emailLab);
		tEmail.setToolTipText(GlobalConstants.emailToolTip);
		
		lBrIndexa = new JLabel(GlobalConstants.indexLab);
		tBrIndexa = new JTextField();
		tBrIndexa.setName(GlobalConstants.indexLab);
		tBrIndexa.setToolTipText(GlobalConstants.brIndexaToolTip);
		
		lGodUpisa = new JLabel(GlobalConstants.upisLab);
		tGodUpisa = new JTextField();
		tGodUpisa.setName(GlobalConstants.upisLab);
		tGodUpisa.setToolTipText(GlobalConstants.godUpisaToolTip);
		
		lTrenutnaGod = new JLabel(GlobalConstants.trenutnaLab);
		String[] godStud = {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
		tTrenutnaGod = new JComboBox<String>(godStud);
		
		lFinans = new JLabel(GlobalConstants.finansLab);
		String[] data = {"Budžet", "Samofinansiranje"};
		tFinans = new JComboBox<String>(data);
		
		JLabel lab = new JLabel();
		lab.setPreferredSize(new Dimension(150, 25));
		
		glavni.add(createPanel(lIme, tIme));
		glavni.add(createPanel(lPrezime, tPrezime));
		glavni.add(createPanel(lDatRodj, tDatRodj));
		glavni.add(createPanel(lAdrStan, tAdrStan));
		glavni.add(createPanel(lBrTel, tBrTel));
		glavni.add(createPanel(lEmail, tEmail));
		glavni.add(createPanel(lBrIndexa, tBrIndexa));
		glavni.add(createPanel(lGodUpisa, tGodUpisa));
		glavni.add(createListPanel(lTrenutnaGod, tTrenutnaGod));
		glavni.add(createListPanel(lFinans, tFinans));
		glavni.add(lab);
		
		
		// Focus listeners
		tIme.addFocusListener(new StudentFocusListeners());
		tPrezime.addFocusListener(new StudentFocusListeners());
		tDatRodj.addFocusListener(new StudentFocusListeners());
		tAdrStan.addFocusListener(new StudentFocusListeners());
		tBrTel.addFocusListener(new StudentFocusListeners());
		tEmail.addFocusListener(new StudentFocusListeners());
		tBrIndexa.addFocusListener(new StudentFocusListeners());
		tGodUpisa.addFocusListener(new StudentFocusListeners());
		
		JPanel dugmad = new JPanel();
		
		potvrdi = new JButton(GlobalConstants.btnOkName);
		potvrdi.setEnabled(false);
		dugmad.add(potvrdi);
		
		odustani = new JButton(GlobalConstants.btnCncName);
		dugmad.add(odustani);
		
		if(mode == AddOrEditDialog.addMode) {
			add(glavni, BorderLayout.NORTH);
			add(dugmad,BorderLayout.SOUTH);
		}
		
		
		if(mode == AddOrEditDialog.editMode) {
			
			if(TabelaStudenti.table.getSelectedRow() != -1) {
				
				int selectedStudent = TabelaStudenti.table.getSelectedRow();
				String indexStudenta = (String) TabelaStudenti.table.getValueAt(selectedStudent, 0);
				
				Student student = controller.nadjiStudenta(indexStudenta);
				
				tIme.setText(student.getIme());
				tPrezime.setText(student.getPrezime());
				tDatRodj.setText(student.getDatumRodj());
				tAdrStan.setText(student.getAdresaStan());
				tBrTel.setText(student.getKonTel());
				tEmail.setText(student.getEmail());
				tBrIndexa.setText(student.getBrIndexa().split("/")[0]);
				tGodUpisa.setText(student.getGodUpisa());
				tTrenutnaGod.setSelectedIndex(student.getTrenutnaGodStud() - 1);
				if(student.getStatus().equals("B"))
					tFinans.setSelectedItem("Budžet");
				else
					tFinans.setSelectedItem("Samofinansiranje");
				
				tBrIndexa.setEditable(false);
				tGodUpisa.setEditable(false);
				
				JPanel inf = new JPanel();
				inf.setLayout(new BorderLayout());
				inf.add(glavni,BorderLayout.NORTH);
				inf.add(dugmad, BorderLayout.SOUTH);
				
				JPanel polozeni = new JPanel();
				JPanel nepolozeni = new JPanel();
				
				JTabbedPane tabs = new JTabbedPane();
				tabs.addTab("Informacije", inf);
				tabs.addTab("Položeni", polozeni);
				tabs.addTab("Nepoloženi", nepolozeni);
				add(tabs);
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
				String ime = tIme.getText().substring(0,1).toUpperCase() + tIme.getText().substring(1).toLowerCase();
				String prezime = tPrezime.getText().substring(0,1).toUpperCase() + tPrezime.getText().substring(1).toLowerCase();
				String datRodj = tDatRodj.getText();
				String adresa = tAdrStan.getText().substring(0,1).toUpperCase() + tAdrStan.getText().substring(1);
				String konTel = tBrTel.getText();
				String email = tEmail.getText();
				String smer = tBrIndexa.getText().substring(0,2);
				String broj = tBrIndexa.getText().substring(2);
				int brNula = 0;
				for(int i = 0; i < broj.length(); i++) {
					if(broj.charAt(i) == '0')
						brNula++;
					else
						break;
				}
				
				broj = broj.substring(brNula);
				String index = smer + broj + "/" + tGodUpisa.getText();
				String godUpisa = tGodUpisa.getText();
				int trenutnaGod;
				switch((String) tTrenutnaGod.getSelectedItem()) {
					case "I (prva)" : trenutnaGod = 1; break;
					case "II (druga)" : trenutnaGod = 2; break;
					case "III (treća)" : trenutnaGod = 3; break;
					default : trenutnaGod = 4;
				}
				
				String finans = (String)(tFinans.getSelectedItem());
				
				// za sada
				double prosek = 0.0;
				
				dialog.setVisible(false);
				
				if(mode == AddOrEditDialog.addMode) {
					student = new Student(prezime, ime, datRodj, adresa, konTel, email, index, godUpisa, trenutnaGod, finans, prosek);
					if(!controller.dodajStudenta(student))
						err = new ErrorDialog(GlobalConstants.errAddStud);
				}
				
				if(mode == AddOrEditDialog.editMode) {
					student = controller.nadjiStudenta(index);
					student.setIme(ime);
					student.setPrezime(prezime);
					student.setDatumRodj(datRodj);
					student.setAdresaStan(adresa);
					student.setKonTel(konTel);
					student.setEmail(email);
					student.setBrIndexa(index);
					student.setGodUpisa(godUpisa);
					student.setTrenutnaGodStud(trenutnaGod);
					student.setStatus(finans);
					student.setPosecnaOcena(prosek);
				}
				
				TabelaStudenti.updateTable();
				
				GlavniProzor.serialize();
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
	
}

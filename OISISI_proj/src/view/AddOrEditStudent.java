package view;


import model.*;

import java.awt.BorderLayout;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

import controller.ControllerStudent;
import controller.StudentFocusListeners;

public class AddOrEditStudent extends JPanel {
	
	public static JTextField tIme, tPrezime, tDatRodj, tAdrStan, tBrTel, tEmail, tBrIndexa, tGodUpisa;
	private JLabel lIme, lPrezime, lDatRodj, lAdrStan, lBrTel, lEmail, lBrIndexa, lGodUpisa, lTrenutnaGod, lFinans;
	private JComboBox<String>  tTrenutnaGod, tFinans;
	private Student student;
	public static JButton potvrdi, odustani;
	private ControllerStudent control;
	private ErrorDialog err;
	
	
	public AddOrEditStudent(int mode, AddOrEditDialog d) {
		control = GlavniProzor.getControllerStudent();
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
		String[] godStud = {"I (prva)", "II (druga)", "III (tre�a)", "IV (�etvrta)"};
		tTrenutnaGod = new JComboBox<String>(godStud);
		
		lFinans = new JLabel(GlobalConstants.finansLab);
		String[] data = {"Bud�et", "Samofinansiranje"};
		tFinans = new JComboBox<String>(data);
		
		glavni.add(control.createPanel(lIme, tIme));
		glavni.add(control.createPanel(lPrezime, tPrezime));
		glavni.add(control.createPanel(lDatRodj, tDatRodj));
		glavni.add(control.createPanel(lAdrStan, tAdrStan));
		glavni.add(control.createPanel(lBrTel, tBrTel));
		glavni.add(control.createPanel(lEmail, tEmail));
		glavni.add(control.createPanel(lBrIndexa, tBrIndexa));
		glavni.add(control.createPanel(lGodUpisa, tGodUpisa));
		glavni.add(control.createListPanel(lTrenutnaGod, tTrenutnaGod));
		glavni.add(control.createListPanel(lFinans, tFinans));
		
		add(glavni, BorderLayout.NORTH);
		
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
		dugmad.add(potvrdi);
		
		odustani = new JButton(GlobalConstants.btnCncName);
		dugmad.add(odustani);
		
		add(dugmad,BorderLayout.SOUTH);
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				student = new Student();
				student.setIme(tIme.getText().substring(0,1).toUpperCase() + tIme.getText().substring(1));
				student.setPrezime(tPrezime.getText().substring(0,1).toUpperCase() + tPrezime.getText().substring(1));
				student.setDatumRodj(tDatRodj.getText());
				student.setAdresaStan(tAdrStan.getText().substring(0,1).toUpperCase() + tAdrStan.getText().substring(1));
				student.setKonTel(tBrTel.getText());
				student.setEmail(tEmail.getText());
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
				student.setBrIndexa(smer + broj + "/" + tGodUpisa.getText());
				student.setGodUpisa(tGodUpisa.getText());
				
				switch((String) tTrenutnaGod.getSelectedItem()) {
					case "I (prva)" : student.setTrenutnaGodStud(1); break;
					case "II (druga)" : student.setTrenutnaGodStud(2); break;
					case "III (tre�a)" : student.setTrenutnaGodStud(3); break;
					case "IV (�etvrta)" : student.setTrenutnaGodStud(4); break;
				}
				String finans = (String)(tFinans.getSelectedItem());
				student.setStatus(finans);
				// dodato za testiranje: ne znamo ocene pa ne mozemo da odredimo prosecnu ocenu
				student.setPosecnaOcena(9.5);
				
				d.setVisible(false);
				
				if(!TabelaStudenti.dodajStudentaUTabelu(student,control))
					err = new ErrorDialog(GlobalConstants.errAddStud);
				
				GlavniProzor.serialize();
				
			}
		});
		
	}
	
}

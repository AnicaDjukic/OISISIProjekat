package view;


import model.*;

import java.awt.BorderLayout;
import java.awt.event.*;


import javax.swing.*;

import controller.ControllerStudent;

public class AddOrEditStudent extends JPanel {
	
	private JTextField tIme, tPrezime, tDatRodj, tAdrStan, tBrTel, tEmail, tBrIndexa, tGodUpisa;
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
		
		lPrezime = new JLabel(GlobalConstants.przLab);
		tPrezime = new JTextField();
		
		lDatRodj = new JLabel(GlobalConstants.drLab);
		tDatRodj = new JTextField();
		
		lAdrStan = new JLabel(GlobalConstants.adrStanLab);
		tAdrStan = new JTextField();
		
		lBrTel = new JLabel(GlobalConstants.konTelLab);
		tBrTel = new JTextField();
		
		lEmail = new JLabel(GlobalConstants.emailLab);
		tEmail = new JTextField();
		
		lBrIndexa = new JLabel(GlobalConstants.indexLab);
		tBrIndexa = new JTextField();
		
		lGodUpisa = new JLabel(GlobalConstants.upisLab);
		tGodUpisa = new JTextField();
		
		lTrenutnaGod = new JLabel(GlobalConstants.trenutnaLab);
		String[] godStud = {"1", "2", "3", "4"};
		tTrenutnaGod = new JComboBox<String>(godStud);
		
		lFinans = new JLabel(GlobalConstants.finansLab);
		String[] data = {"Budžet", "Samofinansiranje"};
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
				student.setIme(tIme.getText());
				student.setPrezime(tPrezime.getText());
				student.setDatumRodj(tDatRodj.getText());
				student.setAdresaStan(tAdrStan.getText());
				student.setKonTel(tBrTel.getText());
				student.setEmail(tEmail.getText());
				student.setBrIndexa(tBrIndexa.getText());
				student.setGodUpisa(tGodUpisa.getText());
				String godStud = (String) tTrenutnaGod.getSelectedItem();
				student.setTrenutnaGodStud(Integer.parseInt(godStud));
				String finans = (String)(tFinans.getSelectedItem());
				System.out.println(finans);
				student.setStatus(finans);
				// dodato za testiranje: ne znamo ocene pa ne mozemo da odredimo prosecnu ocenu
				student.setPosecnaOcena(9.5);
				
				ControllerStudent cs = new ControllerStudent();
				if(!TabelaStudenti.dodajStudenta(student, cs))
					err = new ErrorDialog(GlobalConstants.errAddStud);
				//TabelaStudenti.azurirajTabelu();
				
				d.setVisible(false);
				
			}
		});
		
	}
	
}

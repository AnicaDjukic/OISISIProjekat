package view;

import model.GlobalConstants;
import model.Student;

import java.awt.BorderLayout;
import java.lang.invoke.ConstantCallSite;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerStudent;

public class AddOrEditStudent extends JPanel {
	
	private JTextField tIme, tPrezime, tDatRodj, tAdrStan, tBrTel, tEmail, tBrIndexa, tGodUpisa, tTrenutnaGod, tFinans;
	private JLabel lIme, lPrezime, lDatRodj, lAdrStan, lBrTel, lEmail, lBrIndexa, lGodUpisa, lTrenutnaGod, lFinans;
	private Student student;
	public static JButton potvrdi, odustani;
	private ControllerStudent control;
	private AddOrEditDialog dialog;
	private String ime, prezime, datRodj, adrStan, brTel, email, brIndexa, godUpisa, trenutnaGod, finansiranje;
	private ErrorDialog err;
	
	public AddOrEditStudent(int mode, AddOrEditDialog d) {
		control = GlavniProzor.getControllerStudent();
		dialog = d;
		setLayout(new BorderLayout());
		setSize(GlobalConstants.aoedw,GlobalConstants.aoedh);
		
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
		
		lBrIndexa = new JLabel(GlobalConstants.indexLab);
		tBrIndexa = new JTextField();
		
		lGodUpisa = new JLabel(GlobalConstants.upisLab);
		tGodUpisa = new JTextField();
		
		lTrenutnaGod = new JLabel(GlobalConstants.trenutnaLab);
		tTrenutnaGod = new JTextField();
		
		lFinans = new JLabel(GlobalConstants.finansLab);
		tFinans = new JTextField();
		
		glavni.add(control.createPanel(lIme, tIme));
		glavni.add(control.createPanel(lPrezime, tPrezime));
		glavni.add(control.createPanel(lDatRodj, tDatRodj));
		glavni.add(control.createPanel(lAdrStan, tAdrStan));
		glavni.add(control.createPanel(lBrIndexa, tBrIndexa));
		glavni.add(control.createPanel(lGodUpisa, tGodUpisa));
		glavni.add(control.createPanel(lTrenutnaGod, tTrenutnaGod));
		glavni.add(control.createPanel(lFinans, tFinans));
		
		add(glavni, BorderLayout.NORTH);
		
		
		JPanel dugmad = new JPanel();
		
		potvrdi = new JButton(GlobalConstants.btnOkName);
		dugmad.add(potvrdi);
		
		odustani = new JButton(GlobalConstants.btnCncName);
		dugmad.add(odustani);
		
		add(dugmad,BorderLayout.SOUTH);
		
	}
	
}

package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

import model.GlobalConstants;
import model.Profesor;
import controller.*;

public class AddOrEditProfesor extends JPanel{
	
	private JTextField txtPrezime,txtIme,txtDrp,txtAdrStan,txtKonTel,txtEmail,txtAdrKanc,txtBrLicKart,txtTitula,txtZvanje;
	private JLabel labPrezime,labIme,labDrp,labAdrStan,labKonTel,labEmail,labAdrKanc,labBrLicKart,labTitula,labZvanje;
	private Profesor p;
	public static JButton ok,cancel;
	private ControllerProfesor cp;
	private AddOrEditDialog d;
	private String ime,prz,drp,adrStan,konTel,email,adrKanc,brLic,tit,zva;
	private ErrorDialog er;
	
	public static int brPraznihPolja = -10;
	
	public AddOrEditProfesor(int mode, AddOrEditDialog d) {
		cp = GlavniProzor.getControllerProfesor();
	    this.d = d;
		setLayout(new BorderLayout());
		setSize(400,500);
		
		JPanel gornji = new JPanel();
		gornji.setLayout(new BoxLayout(gornji, BoxLayout.Y_AXIS));
		
		txtPrezime = new JTextField();
		txtPrezime.setName(GlobalConstants.przLab);
		txtPrezime.setToolTipText(GlobalConstants.przImeToolTip);
		
		txtIme = new JTextField();
		txtIme.setName(GlobalConstants.imeLab);
		txtIme.setToolTipText(GlobalConstants.przImeToolTip);
		
		txtDrp = new JTextField();
		txtDrp.setName(GlobalConstants.drLab);
		txtDrp.setToolTipText(GlobalConstants.drpToolTip);
		
		txtAdrKanc = new JTextField();
		txtAdrKanc.setName(GlobalConstants.adrKancLab);
		txtAdrKanc.setToolTipText(GlobalConstants.adrToolTip);
		
		txtKonTel = new JTextField();
		txtKonTel.setName(GlobalConstants.konTelLab);
		txtKonTel.setToolTipText(GlobalConstants.konTelToolTip);  
		
		txtEmail = new JTextField();
		txtEmail.setName(GlobalConstants.emailLab);
		txtEmail.setToolTipText(GlobalConstants.emailToolTip);
		
		txtAdrStan = new JTextField();
		txtAdrStan.setName(GlobalConstants.adrStanLab);
		txtAdrStan.setToolTipText(GlobalConstants.adrToolTip);
		
		txtBrLicKart = new JTextField();
		txtBrLicKart.setName(GlobalConstants.brLicKartLab);
		txtBrLicKart.setToolTipText(GlobalConstants.brLicKartToolTip);
		
		txtTitula = new JTextField();
		txtTitula.setName(GlobalConstants.titulaLab);
		txtTitula.setToolTipText(GlobalConstants.titZvToolTip);
		
		txtZvanje = new JTextField();
		txtZvanje.setName(GlobalConstants.zvanjeLab);
		txtZvanje.setToolTipText(GlobalConstants.titZvToolTip);
		
		gornji.add(cp.createPanel(labPrezime, this.txtPrezime, GlobalConstants.przLab));
		gornji.add(cp.createPanel(labIme, this.txtIme, GlobalConstants.imeLab));
		gornji.add(cp.createPanel(labDrp, this.txtDrp, GlobalConstants.drLab));
		gornji.add(cp.createPanel(labAdrKanc, this.txtAdrKanc, GlobalConstants.adrKancLab));
		gornji.add(cp.createPanel(labKonTel, this.txtKonTel, GlobalConstants.konTelLab));
		gornji.add(cp.createPanel(labEmail, this.txtEmail, GlobalConstants.emailLab));
		gornji.add(cp.createPanel(labAdrStan, this.txtAdrStan, GlobalConstants.adrStanLab));
		gornji.add(cp.createPanel(labBrLicKart, this.txtBrLicKart, GlobalConstants.brLicKartLab));
		gornji.add(cp.createPanel(labTitula, this.txtTitula, GlobalConstants.titulaLab));
		gornji.add(cp.createPanel(labZvanje, this.txtZvanje, GlobalConstants.zvanjeLab));
		
		JPanel donji = new JPanel();
		ok = new JButton(GlobalConstants.btnOkName);
		ok.setEnabled(false);
		donji.add(ok);
		cancel = new JButton(GlobalConstants.btnCncName);
		donji.add(cancel);	
		
		add(gornji,BorderLayout.NORTH);
		add(donji,BorderLayout.SOUTH);
		
		
		//Textfield listeneri :
		txtPrezime.addFocusListener(new ProfesorFocusListeners());
		txtIme.addFocusListener(new ProfesorFocusListeners());
		txtDrp.addFocusListener(new ProfesorFocusListeners());
		txtAdrKanc.addFocusListener(new ProfesorFocusListeners());
		txtAdrStan.addFocusListener(new ProfesorFocusListeners());
		txtKonTel.addFocusListener(new ProfesorFocusListeners());
		txtEmail.addFocusListener(new ProfesorFocusListeners());
		txtBrLicKart.addFocusListener(new ProfesorFocusListeners());
		txtTitula.addFocusListener(new ProfesorFocusListeners());
		txtZvanje.addFocusListener(new ProfesorFocusListeners());
		
		
		//Button listeneri : 
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
				brPraznihPolja = -10;
			}
		});
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ime = txtIme.getText();
				prz = txtPrezime.getText();
				drp = txtDrp.getText();
				adrStan = txtAdrStan.getText();
				konTel = txtKonTel.getText();
				email = txtEmail.getText();
				adrKanc = txtAdrKanc.getText();
				brLic = txtBrLicKart.getText();
				tit = txtTitula.getText();
				zva = txtZvanje.getText();
				
				d.setVisible(false);
				
				p = new Profesor(prz,ime,drp,adrStan, adrKanc, konTel, email, brLic, tit, zva);
				if(!cp.dodajProfesora(p)) 
					er = new ErrorDialog(GlobalConstants.errAddProf);
				
				TabelaProfesora.azurirajTabelu();
				
				brPraznihPolja = -10;
			}
		});
	}
}

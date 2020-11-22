package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;

import model.GlobalConstants;
import model.Predmet;
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
	public static int rowNumEdited;
	public static int currMode;
	
	public AddOrEditProfesor(int mode, AddOrEditDialog d) {
		currMode = mode;
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
		
		
		if(mode == AddOrEditDialog.add_mode) {
			add(gornji,BorderLayout.NORTH);
			add(donji,BorderLayout.SOUTH);
		}
		
		
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
		
		if(currMode == AddOrEditDialog.edit_mode) {
			
			rowNumEdited = TabelaProfesora.inst.getSelectedRow();
			String editProfBrLic = (String)TabelaProfesora.inst.getValueAt(rowNumEdited, 0); 
			
			Profesor p = cp.nadjiProfesora(editProfBrLic);
			//Setting the text to selected prof:
			txtPrezime.setText(p.getPrezime());
			txtIme.setText(p.getIme());
			txtDrp.setText(p.getDrp());
			txtAdrKanc.setText(p.getAdrKanc());
			txtAdrStan.setText(p.getAdrStan());
			txtKonTel.setText(p.getKonTel());
			txtEmail.setText(p.getEmail());
			txtBrLicKart.setText(p.getBrLicKart());
			txtTitula.setText(p.getTitula());
			txtZvanje.setText(p.getZvanje());
			
			//Provera tacnosti polja : 
			numCorrectFields();
			if(brPraznihPolja == 0)
				ok.setEnabled(true);
			
			JTabbedPane tabovi = new JTabbedPane();
			add(tabovi);
			
			JPanel tabOsn = new JPanel();
			tabOsn.setLayout(new BorderLayout());
			tabOsn.add(gornji,BorderLayout.NORTH);
			tabOsn.add(donji,BorderLayout.SOUTH);
			tabovi.addTab(GlobalConstants.profEditTabOsnInf, tabOsn);
			
			ArrayList<Predmet> profPred = p.getSpisPred();
			
			
			//Tab predmeti :
			JPanel tabPrd = new JPanel();
			
			JButton dodajPred = new JButton(GlobalConstants.btnDodPred);
			JButton uklPred = new JButton(GlobalConstants.btnUklPred);
			JPanel southPom = new JPanel();
			southPom.add(dodajPred);
			southPom.add(uklPred);
			
			JPanel pom = new JPanel();
			pom.setLayout(new BorderLayout());
			pom.add(southPom, BorderLayout.SOUTH);
			
			ScrollPane listPane = new ScrollPane();
			listPane.setPreferredSize(new Dimension(350,350));
			
			DefaultListModel modelListe = new DefaultListModel();
			for(Predmet pr : profPred) {
				modelListe.addElement(pr.getSif_pred() + ", " + pr.getNaziv());
			}
			JList<Predmet> lista = new JList(modelListe);
			lista.setLayoutOrientation(JList.VERTICAL);
			lista.setSize(listPane.getSize());
			listPane.add(lista);
			pom.add(listPane,BorderLayout.NORTH);
			
			tabPrd.add(pom);
			
			tabovi.add(GlobalConstants.profEditTabPrd, tabPrd);
		}
		
		
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
				
				if(AddOrEditDialog.add_mode == currMode) {
					p = new Profesor(prz,ime,drp,adrStan, adrKanc, konTel, email, brLic, tit, zva);
					if(!cp.dodajProfesora(p)) 
						er = new ErrorDialog(GlobalConstants.errAddProf);
				}else {
					String editProfBrLic = (String)TabelaProfesora.inst.getValueAt(rowNumEdited, 0);
					Profesor ptemp = cp.nadjiProfesora(editProfBrLic);
					cp.ukloniProfesora(editProfBrLic);
					p = new Profesor(prz,ime,drp,adrStan, adrKanc, konTel, email, brLic, tit, zva);
					if(!cp.dodajProfesora(p)) {
						cp.dodajProfesora(ptemp);
						er = new ErrorDialog(GlobalConstants.errEditProf);
					}
				}
				
				TabelaProfesora.azurirajTabelu();
				
				brPraznihPolja = -10;
			}
		});
	}
	
	public void numCorrectFields() {
		if(Checker.isNameOrSurename(txtIme.getText()))
			brPraznihPolja++;
		if(Checker.isNameOrSurename(txtPrezime.getText()))
			brPraznihPolja++;
		if(Checker.isValidDate(txtDrp.getText()))
			brPraznihPolja++;
		if(Checker.isValidAdrress(txtAdrStan.getText()))
			brPraznihPolja++;
		if(Checker.isValidAdrress(txtAdrKanc.getText()))
			brPraznihPolja++;
		if(Checker.isValidEmail(txtEmail.getText()))
			brPraznihPolja++;
		if(Checker.isValidNumber(txtBrLicKart.getText(), 1))
			brPraznihPolja++;
		if(Checker.isValidNumber(txtKonTel.getText(), 0))
			brPraznihPolja++;
		if(Checker.isValidTitOrMaj(txtTitula.getText()))
			brPraznihPolja++;
		if(Checker.isValidTitOrMaj(txtZvanje.getText()))
			brPraznihPolja++;		
		
		System.out.println(brPraznihPolja);
	}
}

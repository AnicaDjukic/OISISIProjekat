package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

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
		txtPrezime.setName("prezime");
		txtPrezime.setToolTipText("Samo slova su dozvoljena");
		
		txtIme = new JTextField();
		txtIme.setName("ime");
		txtIme.setToolTipText("Samo slova su dozvoljena");
		
		txtDrp = new JTextField();
		txtDrp.setName("drp");
		txtDrp.setToolTipText("dd.MM.yyyy format");
		
		txtAdrKanc = new JTextField();
		txtAdrKanc.setName("adrKanc");
		txtAdrKanc.setToolTipText("Adresa se sastoji iz imena ulice i broja zgrade");
		
		txtKonTel = new JTextField();
		txtKonTel.setName("kontel");
		txtKonTel.setToolTipText("Samo brojevi su dozvoljeni");
		
		txtEmail = new JTextField();
		txtEmail.setName("email");
		txtEmail.setToolTipText("Standardni email format : ...@...");
		
		txtAdrStan = new JTextField();
		txtAdrStan.setName("adrStan");
		txtAdrStan.setToolTipText("Adresa se sastoji iz imena ulice i broja zgrade");
		
		txtBrLicKart = new JTextField();
		txtBrLicKart.setName("brLicKart");
		txtBrLicKart.setToolTipText("Samo brojevi su dozvoljni");
		
		txtTitula = new JTextField();
		txtTitula.setName("titula");
		txtTitula.setToolTipText("Dozvoljeno je jedna ili vise reci");
		
		txtZvanje = new JTextField();
		txtZvanje.setName("zvanje");
		txtZvanje.setToolTipText("Dozvoljeno je jedna ili vise reci");
		
		gornji.add(cp.createPanel(labPrezime, this.txtPrezime, "Prezime : "));
		gornji.add(cp.createPanel(labIme, this.txtIme, "Ime : "));
		gornji.add(cp.createPanel(labDrp, this.txtDrp, "Datum rodjenja : "));
		gornji.add(cp.createPanel(labAdrKanc, this.txtAdrKanc, "Adresa kancelarije : "));
		gornji.add(cp.createPanel(labKonTel, this.txtKonTel, "Kontakt telefon : "));
		gornji.add(cp.createPanel(labEmail, this.txtEmail, "Email : "));
		gornji.add(cp.createPanel(labAdrStan, this.txtAdrStan, "Adresa stanovanja : "));
		gornji.add(cp.createPanel(labBrLicKart, this.txtBrLicKart, "Broj licne karte"));
		gornji.add(cp.createPanel(labTitula, this.txtTitula, "Titula : "));
		gornji.add(cp.createPanel(labZvanje, this.txtZvanje, "Zvanje : "));
		
		JPanel donji = new JPanel();
		ok = new JButton("Potvrdi");
		ok.setEnabled(false);
		donji.add(ok);
		cancel = new JButton("Odustani");
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
					er = new ErrorDialog("Neuspesno dodat profesor!");
				
				TabelaProfesora.azurirajTabelu();
				
				brPraznihPolja = -10;
			}
		});
	}
}

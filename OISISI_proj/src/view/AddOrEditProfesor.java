package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Profesor;
import controller.ControllerProfesor;

public class AddOrEditProfesor extends JPanel{
	
	private JTextField txtPrezime,txtIme,txtDrp,txtAdrStan,txtKonTel,txtEmail,txtAdrKanc,txtBrLicKart,txtTitula,txtZvanje;
	private JLabel labPrezime,labIme,labDrp,labAdrStan,labKonTel,labEmail,labAdrKanc,labBrLicKart,labTitula,labZvanje;
	private Profesor profesor;
	private JButton ok,cancel;
	private ControllerProfesor controllerProfesor;
	private AddOrEditDialog d;
	
	public AddOrEditProfesor(ControllerProfesor cp, int mode, AddOrEditDialog d) {
		controllerProfesor = cp;
	    this.d = d;
		setLayout(new BorderLayout());
		setSize(400,500);
		
		JPanel gornji = new JPanel();
		gornji.setLayout(new BoxLayout(gornji, BoxLayout.Y_AXIS));
		
		txtPrezime = new JTextField();
		txtIme = new JTextField();
		txtDrp = new JTextField();
		txtAdrKanc = new JTextField();
		txtKonTel = new JTextField();
		txtEmail = new JTextField();
		txtAdrStan = new JTextField();
		txtBrLicKart = new JTextField();
		txtTitula = new JTextField();
		txtZvanje = new JTextField();
		
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
		ok = new JButton("Ok");
		donji.add(ok);
		cancel = new JButton("Cancel");
		donji.add(cancel);	
		
		add(gornji,BorderLayout.NORTH);
		add(donji,BorderLayout.SOUTH);
		
		//Button listeneri : 
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});
		
		ok.addActionListener(new ActionListener() {
			
			//Treba doimplementirati
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});
	}
}

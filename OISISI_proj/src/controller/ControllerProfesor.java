package controller;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

import model.*;
import view.GlavniProzor;

public class ControllerProfesor {
	
	private ArrayList<Profesor> listaProfesora;
 	
	public ControllerProfesor() {
		listaProfesora = new ArrayList<Profesor>();
		
		Initialize();
	}
	
	public ArrayList<Profesor> getListaProfesora(){
		return this.listaProfesora;
	}
	
	//Doimplementirati kada se bude imao data sample
	public void Initialize() {
		for(int i = 0; i < 10; i++) {
			Profesor temp = new Profesor();
			temp.setIme(""+i+"-prof");
			temp.setPrezime(""+i+"-profPrez");
			temp.setDrp(""+i+"-profDrp");
			temp.setAdrKanc(""+i+"profAdrS");
			temp.setBrLicKart(""+i+"00000000");
			temp.setZvanje(""+i+"-profZva");
			temp.setTitula(""+i+"-profTit");
			dodajProfPred(temp, GlavniProzor.getControllerPredmet().nadjiPredmet(""+i));
			dodajProfPred(temp, GlavniProzor.getControllerPredmet().nadjiPredmet(""+4));
			dodajProfesora(temp);
		}
	}
	
	public boolean dodajProfesora(Profesor p) {
		if(listaProfesora.isEmpty()) {
			listaProfesora.add(p);
			return true;
		}
		for(Profesor temp : listaProfesora)
			if(temp.getBrLicKart().equals(p.getBrLicKart()))
				return false;
		listaProfesora.add(p);		
		return true;
	}
	
	public void ukloniProfesora(String brLicKart) {
		for(Profesor temp : listaProfesora)
			if(temp.getBrLicKart().equals(brLicKart)) {
				listaProfesora.remove(temp);
				break;
			}
	}
	
	public Profesor nadjiProfesora(String brLicKarte) {
		Profesor ret = null;
		for(Profesor s : listaProfesora)
			if(s.getBrLicKart().equals(brLicKarte))
				ret = s;
		return ret;
	}
	
	public void dodajProfPred(Profesor p, Predmet pr) {
		for(Predmet temp : p.getSpisPred())
			if(temp.getSif_pred().equals(pr.getSif_pred()))
				return;
		p.getSpisPred().add(pr);
	}
	
	public void obrisiPredmetKodSvihProf(String spr) {
		for(Profesor p : listaProfesora) 
			for(Predmet pr : p.getSpisPred())
				if(pr.getSif_pred().equals(spr)) {
					p.getSpisPred().remove(pr);
					break;
				}
	}
	
	public ArrayList<String> pretraziProf(String words[]) {
		ArrayList<String> foundBrLicKart = new ArrayList<String>();
		if(words.length == 1) {
			for(Profesor p : listaProfesora) {
				if(p.getPrezime().toLowerCase().indexOf(words[0]) != -1)
					foundBrLicKart.add(p.getBrLicKart());
			}
		}
		if(words.length == 2) {
			for(Profesor p : listaProfesora)
				if(p.getPrezime().toLowerCase().indexOf(words[0]) != -1)
					if(p.getIme().toLowerCase().indexOf(words[1]) != -1)
						foundBrLicKart.add(p.getBrLicKart());
		}
		
		return foundBrLicKart;
	}
	public void dodajVisePredmetaProf(String brLic, ArrayList<String> pids) {
		ArrayList<Predmet> prds = new ArrayList<Predmet>();
		for(String id : pids) {
			for(Predmet pr : GlavniProzor.getControllerPredmet().getListaPredmeta())
				if(pr.getSif_pred().equals(id))
					prds.add(pr);
		}
		System.out.println(prds.size());
		for(Profesor p : listaProfesora)
			if(p.getBrLicKart().equals(brLic))
				for(Predmet pr : prds)
					p.getSpisPred().add(pr);
	}
	
	//AddOrEditProfesor panel create : 
	public JPanel createPanel(JLabel lab, JTextField txt, String ime) {
		JPanel ret = new JPanel();
		Dimension lbl_dims = new Dimension(150,25);
		lab = new JLabel(ime);
		lab.setPreferredSize(lbl_dims);
		ret.add(lab);
		
		Dimension txt_dims = new Dimension(200,25);
		txt.setPreferredSize(txt_dims);
		ret.add(txt);
		
		return ret;
	}
}


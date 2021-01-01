package controller;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import model.GlobalConstants;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.AddOrEditPredmet;
import view.GlavniProzor;

public class ControllerPredmet {
	
	private ArrayList<Predmet> listaPredmeta;
	
	public ControllerPredmet() {
		listaPredmeta = new ArrayList<Predmet>();
		
		Initialize();		
	}
	
	public ArrayList<Predmet> getListaPredmeta(){
		return this.listaPredmeta;
	}
	
	//Doimplementirati kada se bude imao data sample
	public void Initialize() {
		for (int i = 0; i < 20; i++) {
			Predmet p = new Predmet();
			p.setNaziv(""+i);
			p.setSifPred(""+i);
			p.setEspbBod(i);
			dodajPredmet(p);
		}
	}
	
	public boolean dodajPredmet(Predmet p) {
		if(!listaPredmeta.contains(p))
			for(Predmet pr : listaPredmeta)
				if(pr.getSifPred().equals(p.getSifPred()))
					return false;
		listaPredmeta.add(p);
		return true;
	}
	
	public Predmet nadjiPredmet(String sp) {
		Predmet ret = null;
		for(Predmet p : listaPredmeta)
			if(p.getSifPred().equals(sp))
				ret = p;
		return ret;
	}
	
	public void obrisiPredmet(String sp) {
		//Obrise se kod svih profesora prvo:
		GlavniProzor.getControllerProfesor().obrisiPredmetKodSvihProf(sp);		
		
		//Potom kod svih studenata :
		GlavniProzor.getControllerStudent().obrisiPredmetKodSvihStud(sp);
		
		//Potom iz konacne liste : 
		for(Predmet p : listaPredmeta) {
			if(p.getSifPred().equals(sp)) {
				listaPredmeta.remove(p);
				break;
			}
		}
	}

	public ArrayList<String> pretraziPred(String text) {
		ArrayList<String> foundSifPred = new ArrayList<String>();
		for(Predmet p : listaPredmeta)
			if(p.getSifPred().toLowerCase().indexOf(text) != -1)
				foundSifPred.add(p.getSifPred());
		return foundSifPred;
	}
	
	
	public void obrisiStudentaIzSvihListaPolozenih(String index) {
		for(Predmet p: listaPredmeta) 
			for(Student s: p.getListaPolozenih())
				if(s.getBrIndexa().equals(index)) { 
					p.getListaPolozenih().remove(s);
					break;
				}
	}
	
	public void obrisiStudentaIzSvihListaNepolozenih(String index) {
		for(Predmet p: listaPredmeta) 
			for(Student s: p.getListaNepolozenih())
				if(s.getBrIndexa().equals(index)) {
					p.getListaNepolozenih().remove(s);
					break;
				}
	}
	
	public void obrisiProfSaSvihPredmeta(String brLicKart) {
		for(Predmet p : listaPredmeta)
			if(p.getProf().getBrLicKart().equals(brLicKart))
				p.setProf(GlobalConstants.dummy);
	}
	
	public void serialize() throws FileNotFoundException, IOException {
		File profesori = new File("resources" + File.separator + "Predmeti.txt");
		profesori.delete();
		profesori.createNewFile();
		try(FileOutputStream fos = new FileOutputStream(profesori);
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(fos));){
			for(Predmet p : listaPredmeta)
				dos.writeBytes(p.toString() + "\n");
		}
	}
	
}

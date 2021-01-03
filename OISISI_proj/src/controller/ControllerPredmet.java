package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.GlobalConstants;
import model.Predmet;
import model.Student;
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
		/*for (int i = 0; i < 20; i++) {
			Predmet p = new Predmet();
			p.setNaziv(""+i);
			p.setSifPred(""+i);
			p.setEspbBod(i);
			dodajPredmet(p);
		}*/
		
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		File predmeti = new File("resources" + File.separator + "Predmeti.txt");
		predmeti.delete();
		predmeti.createNewFile();
		try(FileOutputStream fos = new FileOutputStream(predmeti);
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));){
			
			oos.writeObject(listaPredmeta);
			
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked"})
	public void deserialize() throws FileNotFoundException, IOException {
		File predmeti = new File("resources" + File.separator + "Predmeti.txt");
		try(FileInputStream fis = new FileInputStream(predmeti);
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));) {
			
			listaPredmeta = (ArrayList<Predmet>) ois.readObject();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

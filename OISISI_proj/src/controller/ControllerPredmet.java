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
import java.util.*;
import java.util.regex.Pattern;
import model.GlobalConstants;
import model.Predmet;
import model.Student;
import view.GlavniProzor;

public class ControllerPredmet {
	
	private ArrayList<Predmet> listaPredmeta;
	ArrayList<Predmet> loadedPredmet;
	
	public ControllerPredmet() {
		listaPredmeta = new ArrayList<Predmet>();
		loadedPredmet = new ArrayList<Predmet>();
		
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
			e.printStackTrace();
		} catch (IOException e) {
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
			if(p.getNaziv().toLowerCase().indexOf(text) != -1)
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
			
			loadedPredmet = (ArrayList<Predmet>) ois.readObject();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Napredna pretraga :
	public boolean advSrcTxt(String crit, ArrayList<Predmet> ret){
		int critType;
		String[] parts = crit.split(" ");
		if(parts[2].startsWith("/")) {
			if(!parts[2].endsWith("/"))
				return false;
			critType = 1;
			parts[2] = parts[2].substring(1,parts[2].length()-1);
			try {
				Pattern.compile(parts[2]);
			} catch (Exception e) {
				return false;
			}
		}
		else if(parts[2].startsWith("\"")) {
			if(!parts[2].endsWith("\""))
				return false;
			critType = 2;
			parts[2] = parts[2].substring(1,parts[2].length()-1);
		}
		else {
			return false;
		}
		
		if(parts[0].equalsIgnoreCase("sifra") || parts[0].equalsIgnoreCase("šifra")){
			if(critType == 1) {
				//sifra po regexu
				
				if(parts[1].equals("==")) {
					for(Predmet p : listaPredmeta)
						if(p.getSifPred().toLowerCase().matches(parts[2]))
							ret.add(p);
				}
				else if(parts[1].equals("!=")) {
					for(Predmet p : listaPredmeta)
						if(!p.getSifPred().toLowerCase().matches(parts[2]))
							ret.add(p);
				}
			}else {
				//sifra po imenu
				
				if(parts[1].equals("==")) {
					for(Predmet p : listaPredmeta)
						if(p.getSifPred().equalsIgnoreCase(parts[2]))
							ret.add(p);
				} 
				else if(parts[1].equals("!=")) {
					for(Predmet p : listaPredmeta)
						if(!p.getSifPred().equalsIgnoreCase(parts[2]))
							ret.add(p);
				}
			}
		}
		else if(parts[0].equalsIgnoreCase("naziv")) {
			if(critType == 1) {
				//Naziv po regexu
				
				if(parts[1].equals("==")) {
					for(Predmet p : listaPredmeta)
						if(p.getNaziv().toLowerCase().matches(parts[2]))
							ret.add(p);
				}
				else if(parts[1].equals("!=")) {
					for(Predmet p : listaPredmeta)
						if(!p.getNaziv().toLowerCase().matches(parts[2]))
							ret.add(p);
				}
			}
			else {
				//Naziv po jednakosti
				
				if(parts[1].equals("==")) {
					for(Predmet p : listaPredmeta)
						if(p.getNaziv().equalsIgnoreCase(parts[2]))
							ret.add(p);
				}
				else if(parts[1].equals("!=")) {
					for(Predmet p : listaPredmeta)
						if(!p.getNaziv().equalsIgnoreCase(parts[2]))
							ret.add(p);
				}
			}
		}
		
		return true;
	}
	
	public boolean advSrcNum(String crit, ArrayList<Predmet> ret) {
		int num;
		
		String[] parts = crit.split(" ");
		
		try {
			num = Integer.parseInt(parts[2]);
		} catch(Exception e) {
			return false;
		}
		
		//Popunjavanje liste
		if(parts[0].equalsIgnoreCase("godina")) {
			if(parts[1].equals("==")) {
				for(Predmet p : listaPredmeta)
					if(p.getNumGodina() == num)
						ret.add(p);
			}
			else if(parts[1].equals("!=")) {
				for(Predmet p : listaPredmeta)
					if(p.getNumGodina() != num)
						ret.add(p);
			}
			else if(parts[1].equals(">")) {
				for(Predmet p : listaPredmeta)
					if(p.getNumGodina() > num)
						ret.add(p);
			}
			else if(parts[1].equals(">=")) {
				for(Predmet p : listaPredmeta)
					if(p.getNumGodina() >= num)
						ret.add(p);
			}
			else if(parts[1].equals("<")) {
				for(Predmet p : listaPredmeta)
					if(p.getNumGodina() < num)
						ret.add(p);
			}
			else if(parts[1].equals("<=")) {
				for(Predmet p : listaPredmeta)
					if(p.getNumGodina() <= num)
						ret.add(p);
			}
		}
		else if(parts[0].equalsIgnoreCase("espb")) {
			if(parts[1].equals("==")) {
				for(Predmet p : listaPredmeta)
					if(p.getNumGodina() == num)
						ret.add(p);
			}
			else if(parts[1].equals("!=")) {
				for(Predmet p : listaPredmeta)
					if(p.getEspbBod() != num)
						ret.add(p);
			}
			else if(parts[1].equals(">")) {
				for(Predmet p : listaPredmeta)
					if(p.getEspbBod() > num)
						ret.add(p);
			}
			else if(parts[1].equals(">=")) {
				for(Predmet p : listaPredmeta)
					if(p.getEspbBod() >= num)
						ret.add(p);
			}
			else if(parts[1].equals("<")) {
				for(Predmet p : listaPredmeta)
					if(p.getEspbBod() < num)
						ret.add(p);
			}
			else if(parts[1].equals("<=")) {
				for(Predmet p : listaPredmeta)
					if(p.getEspbBod() <= num)
						ret.add(p);
			}
		}		
		return true;
	}
	
	public boolean advSrcSem(String crit, ArrayList<Predmet> ret) {
		String[] parts = crit.split(" ");
		
		if(parts[2].equalsIgnoreCase("letnji") || parts[2].equalsIgnoreCase("\"letnji\"")) {
			if(parts[1].equals("==")) {
				for(Predmet p : listaPredmeta)
					if(p.getSemestar() == Predmet.Semestar.LETNJI)
						ret.add(p);
			}
			else if(parts[1].equals("!=")) {
				for(Predmet p : listaPredmeta)
					if(p.getSemestar() != Predmet.Semestar.LETNJI)
						ret.add(p);
			}
		}
		else if(parts[2].equalsIgnoreCase("zimski") || parts[2].equalsIgnoreCase("\"zimski\"")) {
			if(parts[1].equals("==")) {
				for(Predmet p : listaPredmeta)
					if(p.getSemestar() == Predmet.Semestar.ZIMSKI)
						ret.add(p);
			}
			else if(parts[1].equals("!=")) {
				for(Predmet p : listaPredmeta)
					if(p.getSemestar() != Predmet.Semestar.ZIMSKI)
						ret.add(p);
			}
		}
		
		return true;
	}
	//Unija i presek kriterijuma :
	public ArrayList<Predmet> union(ArrayList<ArrayList<Predmet>> listU){
		Set<Predmet> set = new HashSet<Predmet>();
		
		for(ArrayList<Predmet> p : listU)
			set.addAll(p);
		
		return new ArrayList<Predmet>(set);
	}
	
	public ArrayList<Predmet> intersect(ArrayList<ArrayList<Predmet>> listU){
		Set<Predmet> set = new HashSet<Predmet>();
		set.addAll(listU.get(0));
		
		for(int i = 1; i < listU.size(); i++) {
			Set<Predmet> temp = new HashSet<Predmet>();
			temp.addAll(listU.get(i));
			
			set.retainAll(temp);
		}
		
		return new ArrayList<Predmet>(set);
	}
	
	public void sync() {		
		for(Predmet pr : loadedPredmet) {
			//Osnovna polja :
			Predmet tempPred = new Predmet();
			
			tempPred.setEspbBod(pr.getEspbBod());
			tempPred.setGodIzv(pr.getGodIzv());
			tempPred.setNaziv(pr.getNaziv());
			tempPred.setSemestar(pr.getSemestar());
			tempPred.setSifPred(pr.getSifPred());
			
			//Postavljanje korektnog profesora :
			if(pr.getProf().getIme().equals(""))
				tempPred.setProf(GlobalConstants.dummy);
			else
				tempPred.setProf(GlavniProzor.getControllerProfesor().nadjiProfesora(pr.getProf().getBrLicKart()));
			
			//Lista studenata koji su polozili :
			for(Student s : pr.getListaPolozenih())
				tempPred.getListaPolozenih().add(GlavniProzor.getControllerStudent().nadjiStudenta(s.getBrIndexa()));
			
			//Lista studenata koji nisu polozili :
			for(Student s : pr.getListaNepolozenih())
				tempPred.getListaNepolozenih().add(GlavniProzor.getControllerStudent().nadjiStudenta(s.getBrIndexa()));
				
			listaPredmeta.add(tempPred);
		}
		
	}
}

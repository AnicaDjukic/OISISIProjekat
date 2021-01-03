package controller;

import java.awt.Dimension;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.GlobalConstants;
import model.Predmet;
import model.Profesor;
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
			temp.setDrp(LocalDate.MIN);
			temp.setAdrKanc(""+i+"profAdrS");
			temp.setBrLicKart(""+i+"00000000");
			temp.setZvanje(""+i+"-profZva");
			temp.setTitula(""+i+"-profTit");
			temp.setEmail(i + "@gmail.com");
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
			if(temp.getBrLicKart().equals(p.getBrLicKart()) || temp.getEmail().equals(p.getEmail()))
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
			if(temp.getSifPred().equals(pr.getSifPred()))
				return;
		p.getSpisPred().add(pr);
	}
	
	public void obrisiPredmetKodSvihProf(String spr) {
		for(Profesor p : listaProfesora) 
			for(Predmet pr : p.getSpisPred())
				if(pr.getSifPred().equals(spr)) {
					p.getSpisPred().remove(pr);
					break;
				}
	}
	
	public void obrisiPredmetKodProf(Profesor p, Predmet pr) {
		for(Predmet pred : p.getSpisPred())
			if(pred.equals(pr)) {
				p.getSpisPred().remove(pred);
				return;
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
				if(pr.getSifPred().equals(id))
					prds.add(pr);
		}/*
		for(Profesor p : listaProfesora)
			if(p.getBrLicKart().equals(brLic))
				for(Predmet pr : prds) {
					p.getSpisPred().add(pr);
					//pr.setProf(p);
				}
		*/
		Profesor pr = nadjiProfesora(brLic);
		for(Predmet p : prds) {
			obrisiPredmetKodSvihProf(p.getSifPred());
			pr.getSpisPred().add(p);
			p.setProf(pr);
		}
	}
	
	//AddOrEditProfesor panel create : 
	public JPanel createPanel(JLabel lab, JTextField txt, String ime) {
		JPanel ret = new JPanel();
		Dimension lblDims = new Dimension(150,25);
		lab = new JLabel(ime);
		lab.setPreferredSize(lblDims);
		ret.add(lab);
		
		Dimension txtDims = new Dimension(200,25);
		txt.setPreferredSize(txtDims);
		ret.add(txt);
		
		return ret;
	}
	
	public JPanel createComboBox(JLabel lab, JComboBox<String> txt, String ime) {
		JPanel ret = new JPanel();
		Dimension lblDims = new Dimension(150,25);
		lab = new JLabel(ime);
		lab.setPreferredSize(lblDims);
		ret.add(lab);
		
		Dimension txtDims = new Dimension(200,25);
		txt.setPreferredSize(txtDims);
		ret.add(txt);
		
		return ret;
	}
	
	public void serialize() throws FileNotFoundException, IOException {
		File profesori = new File("resources" + File.separator + "Profesori.txt");
		profesori.delete();
		profesori.createNewFile();
		try(FileOutputStream fos = new FileOutputStream(profesori);
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(fos));){
			for(Profesor p : listaProfesora)
				dos.writeBytes(p.toString() + "\n");
		}
	}
	
	//Napredna pretraga :
	public boolean advSrcTxt(String crit, ArrayList<Profesor> ret){
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
			if(parts[0].equalsIgnoreCase("titula") || parts[0].equalsIgnoreCase("zvanje")) {
				int i = 2;
				do {
					if(parts[i].matches(".*\"$"))
						break;
					parts[2] += " " + parts[++i];
				}while(i < parts.length);
			}
			if(!parts[2].endsWith("\""))
				return false;
			critType = 2;
			parts[2] = parts[2].substring(1,parts[2].length()-1);
		}
		else {
			return false;
		}
		
		if(parts[0].equalsIgnoreCase("ime")){
			if(critType == 1) {
				//sifra po regexu
				
				if(parts[1].equals("==")) {
					for(Profesor p : listaProfesora)
						if(p.getIme().toLowerCase().matches(parts[2]))
							ret.add(p);
				}
				else if(parts[1].equals("!=")) {
					for(Profesor p : listaProfesora)
						if(!p.getIme().toLowerCase().matches(parts[2]))
							ret.add(p);
				}
			}else {
				//sifra po imenu
				
				if(parts[1].equals("==")) {
					for(Profesor p : listaProfesora)
						if(p.getIme().equalsIgnoreCase(parts[2]))
							ret.add(p);
				} 
				else if(parts[1].equals("!=")) {
					for(Profesor p : listaProfesora)
						if(!p.getIme().equalsIgnoreCase(parts[2]))
							ret.add(p);
				}
			}
		}
		else if(parts[0].equalsIgnoreCase("prezime")) {
			if(critType == 1) {
				//Naziv po regexu
				
				if(parts[1].equals("==")) {
					for(Profesor p : listaProfesora)
						if(p.getPrezime().toLowerCase().matches(parts[2]))
							ret.add(p);
				}
				else if(parts[1].equals("!=")) {
					for(Profesor p : listaProfesora)
						if(!p.getPrezime().toLowerCase().matches(parts[2]))
							ret.add(p);
				}
			}
			else {
				//Naziv po jednakosti
				
				if(parts[1].equals("==")) {
					for(Profesor p : listaProfesora)
						if(p.getPrezime().equalsIgnoreCase(parts[2]))
							ret.add(p);
				}
				else if(parts[1].equals("!=")) {
					for(Profesor p : listaProfesora)
						if(!p.getPrezime().equalsIgnoreCase(parts[2]))
							ret.add(p);
				}
			}
		}
		else if(parts[0].equalsIgnoreCase("titula")) {
			String tempTit = "";
			for(String s : GlobalConstants.titule)
				if(s.equalsIgnoreCase(parts[2])) {
					tempTit = s;
					break;
				}
			
			if(tempTit.isEmpty())
				return false;
			
			if(critType == 1) {
				return false;
			}
			else {
				//Pretraga po jednakosti :
				if(parts[1].equals("==")) {
					for(Profesor p : listaProfesora)
						if(p.getTitula().equals(tempTit))
							ret.add(p);
				}
				else if(parts[1].equals("!=")) {
					for(Profesor p : listaProfesora)
						if(!p.getTitula().equals(tempTit))
							ret.add(p);
				}		
			}	
		}
		else if(parts[0].equalsIgnoreCase("zvanje")) {
			String tempTit = "";
			for(String s : GlobalConstants.zvanja)
				if(s.equalsIgnoreCase(parts[2])) {
					tempTit = s;
					break;
				}
			
			if(tempTit.isEmpty())
				return false;
			if(critType == 1) {
				return false;
			}
			else {
				//Pretraga po jednakosti :
				if(parts[1].equals("==")) {
					for(Profesor p : listaProfesora)
						if(p.getZvanje().equals(tempTit))
							ret.add(p);
				}
				else if(parts[1].equals("!=")) {
					for(Profesor p : listaProfesora)
						if(!p.getZvanje().equals(tempTit))
							ret.add(p);
				}		
			}
			
		}
		
		return true;
	}
	
	//Unija i presek :
	public ArrayList<Profesor> union(ArrayList<ArrayList<Profesor>> listU){
		Set<Profesor> set = new HashSet<Profesor>();
		
		for(ArrayList<Profesor> p : listU)
			set.addAll(p);
		
		return new ArrayList<Profesor>(set);
	}
	
	public ArrayList<Profesor> intersect(ArrayList<ArrayList<Profesor>> listU){
		Set<Profesor> set = new HashSet<Profesor>();
		set.addAll(listU.get(0));
		
		for(int i = 1; i < listU.size(); i++) {
			Set<Profesor> temp = new HashSet<Profesor>();
			temp.addAll(listU.get(i));
			
			set.retainAll(temp);
		}
		
		return new ArrayList<Profesor>(set);
	}
}


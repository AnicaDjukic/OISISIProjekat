package controller;

import java.awt.Dimension;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		/*for(int i = 0; i < 10; i++) {
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
			GlavniProzor.getControllerPredmet().nadjiPredmet(""+i).setProf(temp);
			dodajProfPred(temp, GlavniProzor.getControllerPredmet().nadjiPredmet(""+4));
			dodajProfesora(temp);
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
	
	public void obrisiPredmeteKodProf(Profesor p, ArrayList<String> sifre) {
		for(String str : sifre)
			for(Predmet pred : p.getSpisPred())
				if(pred.getSifPred().equals(str)) {
					p.getSpisPred().remove(pred);
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
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));){
			
			oos.writeObject(listaProfesora);
			
			oos.close();
			fos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked"})
	public void deserialize() throws FileNotFoundException, IOException {
		File profesori = new File("resources" + File.separator + "Profesori.txt");
		try(FileInputStream fis = new FileInputStream(profesori);
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));) {
			
			listaProfesora = (ArrayList<Profesor>) ois.readObject();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


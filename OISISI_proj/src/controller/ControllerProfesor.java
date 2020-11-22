package controller;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

import model.Profesor;

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
	
	public void ukloniProfesora(Profesor p) {
		if(listaProfesora.contains(p))
			listaProfesora.remove(p);
	}
	
	public Profesor nadjiProfesora(String brLicKarte) {
		Profesor ret = null;
		for(Profesor s : listaProfesora)
			if(s.getBrLicKart().equals(brLicKarte))
				ret = s;
		return ret;
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


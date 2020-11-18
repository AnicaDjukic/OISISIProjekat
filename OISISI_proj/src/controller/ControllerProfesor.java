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
			Profesor p = new Profesor();
			p.setIme("" + i);
			dodajProfesora(p);
		}
	}
	
	public void dodajProfesora(Profesor p) {
		if(!listaProfesora.contains(p))
			listaProfesora.add(p);
	}
	
	public void ukloniProfesora(Profesor p) {
		if(listaProfesora.contains(p))
			listaProfesora.remove(p);
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
	
	//Validator da je profesor ispravno napravljen :
	public boolean Validate(Profesor p) {
		String regEx = "[A-Z][a-z]*";
		
		if(!p.getIme().matches(regEx))
			return false;
		
		if(!p.getPrezime().matches(regEx))
			return false;
		
		regEx = "([A-Z][a-z]*[ ]){1,5}[1-9][0-9]?";
		if(!p.getAdr_stan().matches(regEx))
			return false;
		
		if(!p.getAdr_kanc().matches(regEx))
			return false;
		
		if(!isValidDate(p.getDrp()))
			return false;
		
		
		return true;
	}
	
	boolean isValidDate(String input) {
		SimpleDateFormat dateValidaterCol = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateValidaterDot = new SimpleDateFormat("dd.MM.yyyy");
		boolean suc = false;
		try {
	    	 dateValidaterCol.parse(input);
	         suc = true;
	     }
	     catch(ParseException e){
	          suc = false;
	     }
		
		try {
			dateValidaterDot.parse(input);
	         suc = true;
	     }
	     catch(ParseException e){
	          suc = false;
	     }
		
		return suc;
	}
}


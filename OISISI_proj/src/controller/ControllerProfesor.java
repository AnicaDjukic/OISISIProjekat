package controller;

import java.awt.*;
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
}

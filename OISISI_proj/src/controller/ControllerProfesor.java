package controller;

import java.util.*;

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
}

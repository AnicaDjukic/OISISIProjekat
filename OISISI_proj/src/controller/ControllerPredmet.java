package controller;

import java.util.*;
import model.Predmet;

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
			dodajPredmet(p);
		}
	}
	
	public void dodajPredmet(Predmet p) {
		if(!listaPredmeta.contains(p))
			listaPredmeta.add(p);
	}
	
}

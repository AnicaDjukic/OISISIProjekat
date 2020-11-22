package controller;

import java.util.*;
import model.Predmet;
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
			p.setSif_pred(""+i);
			dodajPredmet(p);
		}
	}
	
	public boolean dodajPredmet(Predmet p) {
		if(!listaPredmeta.contains(p))
			for(Predmet pr : listaPredmeta)
				if(pr.getSif_pred().equals(p.getSif_pred()))
					return false;
		listaPredmeta.add(p);
		return true;
	}
	
	public Predmet nadjiPredmet(String sp) {
		Predmet ret = null;
		for(Predmet p : listaPredmeta)
			if(p.getSif_pred().equals(sp))
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
			if(p.getSif_pred().equals(sp)) {
				listaPredmeta.remove(p);
				break;
			}
		}
	}
	
}

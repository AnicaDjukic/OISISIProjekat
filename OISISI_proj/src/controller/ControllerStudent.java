package controller;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;

public class ControllerStudent {
	
	//Sluzi za upravljanjem globalne liste studenata
	
	ArrayList<Student> listaStudenti;
	
	public ControllerStudent() {
		listaStudenti = new ArrayList<Student>();
		
		Initialize();
	}
	
	public void Initialize() {
		for(int i = 0; i < 10; i++) {
			Student p = new Student();
			p.setIme("" + i);
			listaStudenti.add(p);
		}
	}
	
	public void obrisiPredmetKodSvihStud(String spr) {
		for(Student s : listaStudenti) {
			for(Ocena o : s.getPolozeniIspiti()) 
				if(o.getPredmet().getSif_pred().equals(spr)) {
					s.getPolozeniIspiti().remove(o);
					break;
				}
			for(Predmet p : s.getNepolozeniIspiti())
				if(p.getSif_pred().equals(spr)) {
					s.getNepolozeniIspiti().remove(p);
					break;
				}
		}
	}
}

package controller;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import model.Ocena;
import model.Predmet;
import model.Student;

public class ControllerStudent {
	
	//Sluzi za upravljanjem globalne liste studenata
	
	ArrayList<Student> listaStudenti;
	
	public ControllerStudent() {
		listaStudenti = new ArrayList<Student>();
		
		//Initialize();
	}
	
	public ArrayList<Student> getListaStudenta() {
		return this.listaStudenti;
	}
	
	public void Initialize() {
		/*for(int i = 0; i < 10; i++) {
			Student p = new Student();
			p.setIme("" + i);
			listaStudenti.add(p);
		}*/
	}
	
	public boolean dodajStudenta(Student s) {
		if(listaStudenti.isEmpty()) {
			listaStudenti.add(s);
			return true;
		}
		
		for(Student student: listaStudenti) {
			if(student.getBrIndexa().equals(s.getBrIndexa())) {
				return false;
			}
				
		}

		listaStudenti.add(s);
		return true;
	}
	
	public JPanel createPanel(JLabel label, JTextField text) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(150, 25));
		panel.add(label);
		
		text.setPreferredSize(new Dimension(200, 25));
		panel.add(text);
		
		return panel;
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
	
	public JPanel createListPanel(JLabel label, JComboBox<String> text) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(150, 25));
		panel.add(label);
		
		text.setPreferredSize(new Dimension(200, 25));
		panel.add(text);
		
		return panel;
	}
}

package controller;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import model.Student;

public class ControllerStudent {
	
	//Sluzi za upravljanjem globalne liste studenata
	
	ArrayList<Student> listaStudenti;
	
	public ControllerStudent() {
		listaStudenti = new ArrayList<Student>();
		
		Initialize();
	}
	
	public ArrayList<Student> getListaStudenta() {
		return this.listaStudenti;
	}
	
	public void Initialize() {
		for(int i = 0; i < 10; i++) {
			Student p = new Student();
			p.setIme("" + i);
			listaStudenti.add(p);
		}
	}
	
	public boolean dodajStudentaUListu(Student s) {
		if(listaStudenti.isEmpty()) {
			listaStudenti.add(s);
			return true;
		}
		for(Student student: listaStudenti)
			if(student.getBrIndexa().equals(s.getBrIndexa()))
				return false;
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
	
	public JPanel createListPanel(JLabel label, JComboBox text) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(150, 25));
		panel.add(label);
		
		text.setPreferredSize(new Dimension(200, 25));
		panel.add(text);
		
		return panel;
	}
	
}

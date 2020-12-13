package controller;

import java.util.*;

import model.Student;

public class ControllerStudent {
	
	//Sluzi za upravljanje listom studenata
	
	ArrayList<Student> listaStudenti;
	
	public ControllerStudent() {
		listaStudenti = new ArrayList<Student>();
		
		//Initialize();
	}
	
	public ArrayList<Student> getListaStudenata() {
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
	
}

package controller;

import java.awt.Dimension;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.GlavniProzor;
import model.Predmet.GodIzv;

public class ControllerStudent {
	
	//Sluzi za upravljanje listom studenata
	
	ArrayList<Student> listaStudenti;
		
	public ControllerStudent() {
		listaStudenti = new ArrayList<Student>();
			
		Initialize();
	}
		
	public ArrayList<Student> getListaStudenata() {
		return this.listaStudenti;
	}
		
	public void Initialize() {
		for(int i = 0; i < 10; i++) {
			Student s = new Student();
			s.setIme("ime ");
			s.setPrezime("prz ");
			s.setBrIndexa("ra-" + i + "-2018");
			s.setGodUpisa("2019");
			s.setTrenutnaGodStud(3);
			s.setDatumRodj(LocalDate.parse("1999-01-01"));
			s.setAdresaStan("gshasg 12");
			s.setKonTel("12463278");
			s.setEmail("gg@gmail.com");
			s.setStatus("B");
			s.setProsecnaOcena(0.0);
			dodajStudenta(s);
		}
	}
	//Testiranje za prikaz nepolozenih ispita : 
	public void testAddNepo() {
		for(Student s : listaStudenti) {
			s.getNepolozeniIspiti().add(GlavniProzor.getControllerPredmet().nadjiPredmet("1"));
		}
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
	
	public Student nadjiStudenta(String index) {
		Student ret = null;
		for(Student s : listaStudenti)
			if(s.getBrIndexa().equals(index))
				ret = s;
		return ret;
	}
	
	public void obrisiPredmetKodSvihStud(String spr) {
		for(Student s : listaStudenti) {
			for(Ocena o : s.getPolozeniIspiti()) 
				if(o.getPredmet().getSifPred().equals(spr)) {
					s.getPolozeniIspiti().remove(o);
					break;
				}
			for(Predmet p : s.getNepolozeniIspiti())
				if(p.getSifPred().equals(spr)) {
					s.getNepolozeniIspiti().remove(p);
					break;
				}
		}
	}
	
	public int izracunajUkupnoEspb(String index) {
		Student student = nadjiStudenta(index);
		int espb = 0;
		for(Ocena o : student.getPolozeniIspiti()) {
			espb += o.getPredmet().getEspbBod();
		}
		return espb;
	}
	
	public JPanel createListPanel(JLabel label, JComboBox<String> text) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(150, 25));
		panel.add(label);
		
		text.setPreferredSize(new Dimension(200, 25));
		panel.add(text);
		
		return panel;
	}
	
	public void obrisiStudenta(String index) {
		for(Student s : listaStudenti)
			if(s.getBrIndexa().equals(index)) {
				listaStudenti.remove(s);
				break;
			}
	}
	
	public boolean proveriPred(Student s, Predmet p) {
        for(Ocena o : s.getPolozeniIspiti())
            if(o.getPredmet().equals(p))
                return true;

        for(Predmet pred : s.getNepolozeniIspiti())
            if(pred.equals(p))
                return true;
        
        switch(p.getGodIzv()) {
        case PRVA: break;
        case DRUGA: if(s.getTrenutnaGodStud() < 2) 
        				return true; 
        			break;
        case TRECA: if(s.getTrenutnaGodStud() < 3) 
						return true; 
					break;
		default: if(s.getTrenutnaGodStud() < 4) 
						return true; 
					break;
        }
        
        return false;
    }
	
	public void dodajNepolozenePredmete(ArrayList<String> newPreds, Student stud) {
        for(String s : newPreds) {
            stud.getNepolozeniIspiti().add(GlavniProzor.getControllerPredmet().nadjiPredmet(s));
            GlavniProzor.getControllerPredmet().nadjiPredmet(s).getListaNepolozenih().add(stud);
        }
    }
	
	public void obrisiPredmet(String predIds, Student s) {
		for(Predmet p : s.getNepolozeniIspiti()) {
			if(p.getSifPred().equals(predIds)) {
				s.getNepolozeniIspiti().remove(p);
                p.getListaNepolozenih().remove(s);
                break;
             }
        }
    }
	
	public void serialize() throws FileNotFoundException, IOException {
		File profesori = new File("resources" + File.separator + "Studenti.txt");
		profesori.delete();
		profesori.createNewFile();
		try(FileOutputStream fos = new FileOutputStream(profesori);
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(fos));){
			for(Student p : listaStudenti)
				dos.writeBytes(p.toString() + "\n");
		}
	}
	
	public void sracunajProsecnuOcenu(Student s) {
		double sum = 0;
		int counter = 0;
		for(Ocena o : s.getPolozeniIspiti()) {
			counter++;
			sum += o.getBrVrednost();
		}
		double d = sum/counter;
		s.setProsecnaOcena(d);
	}

	public void upisiOcenuStudentu(Student s, Ocena o) {
		Predmet p = o.getPredmet();
		s.getNepolozeniIspiti().remove(p);
		o.getPredmet().getListaNepolozenih().remove(s);
		s.getPolozeniIspiti().add(o);
		o.getPredmet().getListaPolozenih().add(s);

		sracunajProsecnuOcenu(s);
	}
}

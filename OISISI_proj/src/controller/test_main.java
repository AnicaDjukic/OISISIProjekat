package controller;

//importi :
import model.*;
import view.*;

import java.awt.*;

public class test_main {

	public static void main(String[] args) {
		// Postoji samo za testiranje klasa za pocetak
		// Komentarisati linije ispisa koje nisu bitne
		// Viselinijski komentar se brise kada se testiraju stvari, a stoji cisto kako se ne bi ispisivalo nista suvišno za DOMACI-I
		
		
		//Glavni prozor :
		
		GlavniProzor glavniProzor = new GlavniProzor();
		glavniProzor.setVisible(true);
		
		/* TEST:
		Profesor p1 = new Profesor();
		//System.out.println(p1.toString());
		
		Profesor p2 = new Profesor("Mikic","Mika","1.1.1990",
				      "Micurinova 25","Micurinova 22","0655026516",
				      "blabla@gmail.com","00756612","Doktor","Stalni profesor");
		//System.out.println(p2.toString());
		
		Predmet a1 = new Predmet();
		
		Predmet a2 = new Predmet("OISISI", "Osnove informacionih sistema...",
				     "lEtNJi", 3,p2,8);
		if(p2.dodajPredmet(a1))
			System.out.println("Uspesno dodan predmet!");
		if(p2.dodajPredmet(a2))
			System.out.println("Uspesno dodan predmet!");
		
		//System.out.println(p2.toString());
		
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		if(a2.dodajStudenta(s1))
			System.out.println("Uspesno dodan student!");
		if(a2.dodajStudenta(s3))
			System.out.println("Uspesno dodan student!");
		
		if(a2.dodajUListPolo(s1))
			System.out.println("Uspesno dodan student u list polozenih");
		else
			System.out.println("Nije uslesno dodan u listu polozenih!");
		if(a2.dodajUListPolo(s3))
			System.out.println("Uspesno dodan student u list polozenih");
		else
			System.out.println("Nije uslesno dodan u listu polozenih!");
		
		if(a2.obrisiStudentaSaPredmeta(s2))
			System.out.println("Obrisan s2 sa a2");
		else
			System.out.println("Nije obrisan s2 sa a2");
		
		if(a2.obrisiStudentaSaPredmeta(s1))
			System.out.println("Obrisan s1 sa a2");
		else
			System.out.println("Nije obrisan s1 sa a2");
		
		//System.out.println(a2.toString());
		
		*/
		
		// Testiranje klase Student
		/*Student s1 = new Student();
		//System.out.println(s1);
				
		Student s2 = new Student("Pera", "Peric", "26.6.1998", "Puskinova 6", "o218887656",
								"pp@gmail.com", "RA15/2017", "2017", 4, "b", 9.56);
				
		Profesor p = new Profesor("Mikic","Mika","1.1.1990",
					             "Micurinova 25","Micurinova 22","0655026516",
					             "blabla@gmail.com","00756612","Doktor","Stalni profesor");
				
		Predmet p3 = new Predmet("MATA", "Analiza1",
						     "lEtNJi", 3,p,8);
				
		s2.dodajNepolozeniIspit(p3);
		System.out.println(s2);
		s2.obrisiNepolozeniIspit(p3);
		System.out.println(s2);
		s2.dodajNepolozeniIspit(p3);
		System.out.println(s2);
		Ocena o3 = new Ocena(s2,p3,9,"19.01.2018.");
		s2.dodajPolozenIspit(o3);
		System.out.println(s2);
		s2.obrisiPolozeniIspit(o3);
		System.out.println(s2); */ 
				
	}

}

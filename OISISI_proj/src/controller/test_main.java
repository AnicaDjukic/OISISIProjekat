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
		
		//Glavni prozor :
		
		GlavniProzor glavniProzor = new GlavniProzor();
		glavniProzor.setVisible(true);
		
		
		//Toolbar :
		
		Toolbar toolbar = new Toolbar();
		glavniProzor.add(toolbar,BorderLayout.NORTH);
		
	}

}

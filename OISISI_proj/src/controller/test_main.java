package controller;

//importi :
import model.*;
import view.*;

import java.awt.*;

public class test_main {

	public static void main(String[] args) {
		// Postoji samo za testiranje klasa za pocetak
		// Komentarisati linije ispisa koje nisu bitne
		
		Profesor p1 = new Profesor();
		//System.out.println(p1.toString());
		
		Profesor p2 = new Profesor("Mikic","Mika","1.1.1990",
				      "Micurinova 25","Micurinova 22","0655026516",
				      "blabla@gmail.com","00756612","Doktor","Stalni profesor");
		System.out.println(p2.toString());
		//p2.setIme("Promena Imena");
		//System.out.println(p2.toString());
		
		Predmet a1 = new Predmet();
		//System.out.println(a1.toString());
		
		Predmet a2 = new Predmet("OISISI", "Osnove informacionih sistema...",
				     "lEtNJi", 3,p2,8);
		System.out.println(a2.toString());
		
		//Glavni prozor :
		
		GlavniProzor glavniProzor = new GlavniProzor();
		glavniProzor.setVisible(true);
		
		
		//Toolbar :
		
		Toolbar toolbar = new Toolbar();
		glavniProzor.add(toolbar,BorderLayout.NORTH);
		
	}

}

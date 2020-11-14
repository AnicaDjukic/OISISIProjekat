package model;

//importi :
import java.util.ArrayList;

//enum :

public class Predmet {
	public enum Semestar {LETNJI,ZIMSKI};
	public enum GodIzv {PRVA,DRUGA,TRECA,CETVRTA};
	
	private String sifPred; //sifra predmeta
	private String naziv;    //naziv predmeta
	private Semestar semestar; 
	private GodIzv godIzv;   //godina izvodjenja
	private Profesor prof;   //predmetni profesor
	private int espbBod;    //espb bodovi
	
	//private ArrayList<Student> lista_p //lista studenata koji su polozili
	//private ArrayList<Student> lista_np //lista studenata koji nisu polozili
	
	//auto generisani geteri i seteri za polja :
	
	public String getSif_pred() {
		return sifPred;
	}
	public void setSif_pred(String sif_pred) {
		this.sifPred = sif_pred;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Semestar getSemestar() {
		return semestar;
	}
	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}
	public GodIzv getGodIzv() {
		return godIzv;
	}
	public void setGodIzv(GodIzv godIzv) {
		this.godIzv = godIzv;
	}
	public Profesor getProf() {
		return prof;
	}
	public void setProf(Profesor prof) {
		this.prof = prof;
	}
	public int getEspb_bod() {
		return espbBod;
	}
	public void setEspb_bod(int espb_bod) {
		this.espbBod = espb_bod;
	}
	
	//konstruktori :
	
	public Predmet() {
		this.sifPred = "";
		this.naziv = "";
		this.semestar = Semestar.LETNJI;
		this.godIzv = GodIzv.PRVA;
		this.prof = new Profesor();
		this.espbBod = 0;
	}
	public Predmet(String s_p, String n, String sem,
				   int gi,Profesor p,int eb) {
		this.sifPred = s_p;
		this.naziv = n;
		if(sem.toLowerCase().equals("letnji"))
			this.semestar = Semestar.LETNJI;
		else if(sem.toLowerCase().equals("zimski"))
			this.semestar = Semestar.ZIMSKI;
		else
			System.out.println("Nepostojeci semestar! [letnji,zimski]");
		gi -= 1;
		if(gi >= 0 && gi <= 3) {
			//kastovanje ako je u opsegu postojecih godina
			//GodIzv.values() vraca niz a [gi] je indeksiranje niza
			this.godIzv = GodIzv.values()[gi]; 
		}
		this.prof = p;
		this.espbBod = eb;
	}
	
	
	//Dodatne metode :
	
	private String outGodIzv(GodIzv g) {
		String out = "";
		
		switch(g) {
		case PRVA : out = "PRVA"; break;
		case DRUGA : out = "DRUGA"; break;
		case TRECA : out = "TRECA"; break;
		case CETVRTA : out = "CETVRTA"; break;
		}
		
		return out;
	}
	
	public String toString() {
		String out = "Naziv : " + this.naziv + "\n";
		out += "Sifra predmeta : " + this.sifPred + "\n";
		out += "Semestar : ";
		if(this.semestar.equals(Semestar.LETNJI))
			out += "Letnji" + "\n";
		else
			out += "Zimski" + "\n";
		out += "Godina izvodjenja : " + this.outGodIzv(this.godIzv) + "\n";
		out += "Profesor : " + this.prof.getIme() + " " + prof.getPrezime() + "\n";
		out += "Espb : " + this.espbBod;
		
		return out;
	}
	
}

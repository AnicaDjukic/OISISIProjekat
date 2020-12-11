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
	
	private ArrayList<Student> listaPolozenih; //lista studenata koji su polozili
	private ArrayList<Student> listaNepolozenih; //lista studenata koji nisu polozili
	
	//auto generisani geteri i seteri za polja :
	
	public String getSifPred() {
		return sifPred;
	}
	public void setSifPred(String sif_pred) {
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
	public int getEspbBod() {
		return espbBod;
	}
	public void setEspbBod(int espbBod) {
		this.espbBod = espbBod;
	}
	
	public ArrayList<Student> getListaPolozenih() {
		return listaPolozenih;
	}
	public ArrayList<Student> getListaNepolozenih() {
		return listaNepolozenih;
	}
	
	//konstruktori :
	
	public Predmet() {
		this.sifPred = "";
		this.naziv = "";
		this.semestar = Semestar.LETNJI;
		this.godIzv = GodIzv.PRVA;
		this.prof = new Profesor();
		this.espbBod = 0;
		this.listaNepolozenih = new ArrayList<Student>();
		this.listaPolozenih = new ArrayList<Student>();
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
		this.listaNepolozenih = new ArrayList<Student>();
		this.listaPolozenih = new ArrayList<Student>();
	}
	
	
	//Dodatne metode :
	
	public boolean dodajUListPolo(Student s) {
		if(!listaPolozenih.contains(s))                           //ako se vec ne nalazi u polozenim, onda se tek dodaje
			if(listaPolozenih.add(s)) {                           //u listu polozenih i, paralelno, ako se nalazio u listi
				if(listaNepolozenih.contains(s))                  //onih koji nisu polozili onda se iz te brise
					listaNepolozenih.remove(s);
				return true;
			}
		return false;
	}
	
	public boolean dodajUListNepolo(Student s) {
		if(!listaNepolozenih.contains(s))                         //Isto kao i gore, redosled akcija je isti samo su liste
			if(listaNepolozenih.add(s)) {                         //zamenjene
				if(listaPolozenih.contains(s))
					listaPolozenih.remove(s);
				return true;
			}
		return false;
	}
	
	public boolean dodajStudenta(Student s) {
		if(listaPolozenih.contains(s) || listaNepolozenih.contains(s))      //Ako nije ni u jednoj listi dodaje se inicijalno
			return false;			                                        //u listu nepolozenih
		return dodajUListNepolo(s);
	}
	
	public boolean obrisiStudentaSaPredmeta(Student s) {
		if(listaNepolozenih.remove(s) || listaPolozenih.remove(s))
			return true;
		return false;
	}

	
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
		String out = "";
		
		out = this.getSifPred() + "|" + this.getNaziv() + "|";
		if(this.getSemestar() == Semestar.LETNJI)
			out += "LETNJI";
		else
			out += "ZIMSKI";
		
		out += "|";
		out += this.outGodIzv(this.getGodIzv()) + "|" + this.getProf().getBrLicKart() + "|" + this.getEspbBod() + "|";
		for(Student s : this.getListaPolozenih())
			out += s.getBrIndexa() + ",";
		
		out += "|";
		
		for(Student s : this.getListaNepolozenih())
			out += s.getBrIndexa() + ",";
		
		out += ";";
		
		return out;
	}
	
}

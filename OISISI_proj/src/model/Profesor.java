package model;

//importi : 
import java.util.ArrayList;

public class Profesor {
	private String prezime;
	private String ime;
	private String drp;                    //datum rodjenja prof
	private String adrStan;               //adresa stanovanja
	private String konTel;                //kontakt telefon
	private String email;
	private String adrKanc;               //adresa kancelarije
	private String brLicKart;            //broj licne karte
	private String titula;
	private String zvanje;
	private ArrayList<Predmet> spisPred; //spisak predmeta
	
	//auto generisani geteri i seteri za polja :
	
	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getDrp() {
		return drp;
	}

	public void setDrp(String drp) {
		this.drp = drp;
	}

	public String getAdrStan() {
		return adrStan;
	}

	public void setAdrStan(String adrStan) {
		this.adrStan = adrStan;
	}

	public String getKonTel() {
		return konTel;
	}

	public void setKonTel(String konTel) {
		this.konTel = konTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdrKanc() {
		return adrKanc;
	}

	public void setAdrKanc(String adrKanc) {
		this.adrKanc = adrKanc;
	}

	public String getBrLicKart() {
		return brLicKart;
	}

	public void setBrLicKart(String brLicKart) {
		this.brLicKart = brLicKart;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<Predmet> getSpisPred() {
		return spisPred;
	}

	public void setSpisPred(ArrayList<Predmet> spisPred) {
		this.spisPred = spisPred;
	}
	
	//konstruktori :
	public Profesor() {
		this.prezime = "";
		this.ime = "";
		this.drp = "";
		this.adrStan = "";
		this.adrKanc = "";
		this.konTel = "";
		this.email = "";
		this.brLicKart = "";
		this.titula = "";
		this.zvanje = "";
		this.spisPred = new ArrayList<Predmet>();
	}
	
	public Profesor(String pr, String im, String dr, String ads,
			String adk, String kt, String em, String blk, String tit, String zv) {
		String temp;
		String[] parts;
		
		//Sredjivanje izgleda karaktera :
		pr = pr.toLowerCase();
		temp = pr.substring(0,1);
		temp = temp.toUpperCase();
		pr = temp + pr.substring(1);
		
		im = im.toLowerCase();
		temp = im.substring(0,1);
		temp = temp.toUpperCase();
		im = temp + im.substring(1);
		
		parts = ads.split(" ");
		ads = "";
		for(String s : parts) {
			s = s.toLowerCase();
			temp = s.substring(0,1);
			temp = temp.toUpperCase();
			s = temp + s.substring(1);
			ads += s + " ";
		}
		ads = ads.substring(0, ads.length() - 1);
		
		parts = adk.split(" ");
		adk = "";
		for(String s : parts) {
			s = s.toLowerCase();
			temp = s.substring(0,1);
			temp = temp.toUpperCase();
			s = temp + s.substring(1);
			adk += s + " ";
		}
		adk = adk.substring(0, adk.length() - 1);
		
		parts = tit.split(" ");
		tit = "";
		for(String s : parts) {
			s = s.toLowerCase();
			temp = s.substring(0,1);
			temp = temp.toUpperCase();
			s = temp + s.substring(1);
			tit += s + " ";
		}
		tit = tit.substring(0, tit.length() - 1);
		
		parts = zv.split(" ");
		zv = "";
		for(String s : parts) {
			s = s.toLowerCase();
			temp = s.substring(0,1);
			temp = temp.toUpperCase();
			s = temp + s.substring(1);
			zv += s + " ";
		}
		zv = zv.substring(0, zv.length() - 1);
		
		this.prezime = pr;
		this.ime = im;
		this.drp = dr;
		this.adrStan = ads;
		this.adrKanc = adk;
		this.konTel = kt;
		this.email = em;
		this.brLicKart = blk;
		this.titula = tit;
		this.zvanje = zv;
		this.spisPred = new ArrayList<Predmet>();
	}
	
	//Dodatne metode :
	
	public boolean dodajPredmet(Predmet p) {
		if(spisPred.contains(p) == false)
			if(spisPred.add(p))
				return true;
		return false;
	}
	public boolean ukloniPredmet(Predmet p) {
		if(spisPred.contains(p) == true)
			if(spisPred.remove(p))
			return true;
		return false;
	}
	
	public String toString() {
		String out = "Ime : " + this.ime + "\n";
		out += "Prezime : " + this.prezime + "\n";
		out += "Datum rodjenja : " + this.drp + "\n";
		out += "Adresa stanovanja : " + this.adrStan + "\n";
		out += "Kontakt telefon : " + this.konTel + "\n";
		out += "Email : " + this.email + "\n";
		out += "Adresa kancelarije : " + this.adrKanc + "\n";
		out += "Broj licne karte : " + this.brLicKart + "\n";
		out += "Titula : " + this.titula + "\n";
		out += "Zvanje : " + this.zvanje + "\n";
		out += "Predmeti na kojima predaje : ";
		if(!spisPred.isEmpty()) {
			for(Predmet p : spisPred) {
				out += p.getNaziv() + ", ";
			}
			out = out.substring(0,out.length() - 2);  //uklanjanje poslednjeg zareza
			out += "\n";
		} else {
			out += "Ne predaje ni na jednom predmetu\n"; 
		}
		return out;
	}	
}

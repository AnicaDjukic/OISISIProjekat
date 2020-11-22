package model;

import java.util.ArrayList;

enum StatusStudenta {B, S}

public class Student {
	private String prezime;
	private String ime;
	private String datumRodj;			// datum rodjenja
	private String adresaStan;			// adresa stanovanja
	private String konTel;				// kontakt telefon
	private String email;
	private String brIndexa;			// broj indeksa
	private String godUpisa;			// godina upisa
	private int trenutnaGodStud;		// trenutna godina studija
	private StatusStudenta status;
	private double posecnaOcena;
	private ArrayList<Ocena> polozeniIspiti;		// spisak polozenih ispita (spisak ocena)
	private ArrayList<Predmet> nepolozeniIspiti;	// spisak nepolozenih ispita
	
	// get i set metode
	
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
	public String getDatumRodj() {
		return datumRodj;
	}
	public void setDatumRodj(String datumRodj) {
		this.datumRodj = datumRodj;
	}
	public String getAdresaStan() {
		return adresaStan;
	}
	public void setAdresaStan(String adresaStan) {
		this.adresaStan = adresaStan;
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
	public String getBrIndexa() {
		return brIndexa;
	}
	public void setBrIndexa(String brIndexa) {
		this.brIndexa = brIndexa;
	}
	public String getGodUpisa() {
		return godUpisa;
	}
	public void setGodUpisa(String godUpisa) {
		this.godUpisa = godUpisa;
	}
	public int getTrenutnaGodStud() {
		return trenutnaGodStud;
	}
	public void setTrenutnaGodStud(int trenutnaGodStud) {
		this.trenutnaGodStud = trenutnaGodStud;
	}
	public String getStatus() {
		if(status.equals(StatusStudenta.B))
			return "B";
		return "S";
		
	}
	public void setStatus(String status) {
		if(status.toUpperCase().equals("B") || status.equals("Budžet"))
			this.status = StatusStudenta.B;
		else
			this.status = StatusStudenta.S;
	}
	public double getPosecnaOcena() {
		return posecnaOcena;
	}
	public void setPosecnaOcena(double posecnaOcena) {
		this.posecnaOcena = posecnaOcena;
	}
	public ArrayList<Ocena> getPolozeniIspiti() {
		return polozeniIspiti;
	}
	public ArrayList<Predmet> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}	
	
	
	// konstruktori
	
	public Student() {
		super();
		this.prezime = "";
		this.ime = "";
		this.datumRodj = "";
		this.adresaStan = "";
		this.konTel = "";
		this.email = "";
		this.brIndexa = "";
		this.godUpisa = "";
		this.trenutnaGodStud = 1;
		this.status = StatusStudenta.B;
		this.posecnaOcena = 0.0;
		this.polozeniIspiti = new ArrayList<Ocena>();
		this.nepolozeniIspiti = new ArrayList<Predmet>();
	}
	public Student(String prezime, String ime, String datumRodj, String adresaStan, String konTel, String email,
			String brIndexa, String godUpisa, int trenutnaGodStud, String status, double posecnaOcena) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodj = datumRodj;
		this.adresaStan = adresaStan;
		this.konTel = konTel;
		this.email = email;
		this.brIndexa = brIndexa;
		this.godUpisa = godUpisa;
		this.trenutnaGodStud = trenutnaGodStud;
		if(status.toUpperCase().equals("B") || status.toUpperCase().equals("Budzet"))
			this.status = StatusStudenta.B;
		else
			this.status = StatusStudenta.S;
		this.posecnaOcena = posecnaOcena;
		this.polozeniIspiti = new ArrayList<Ocena>();
		this.nepolozeniIspiti = new ArrayList<Predmet>();
	}
	
	// metode za dodavanje polozenih i nepolozenih ispita
	public boolean dodajPolozenIspit(Ocena o) {				// kada ga doda u listu polozenih
		if(!polozeniIspiti.contains(o))						// brise ga iz liste nepolozenih ispita
			if(polozeniIspiti.add(o))
				if(nepolozeniIspiti.contains(o.getPredmet()))
					if(nepolozeniIspiti.remove(o.getPredmet()))
						return true;
		return false;
	}
	
	public boolean dodajNepolozeniIspit(Predmet p) {		// dodaje u listu nepolozenih ispita
		if(!nepolozeniIspiti.contains(p))
			if(nepolozeniIspiti.add(p))
				return true;
		return false;
	}
	
	// metode za brisanje polozenih i nepolozenih ispita
	public boolean obrisiNepolozeniIspit(Predmet p) {		// brise iz liste nepolozenih ispita
		if(nepolozeniIspiti.contains(p))                
			if(nepolozeniIspiti.remove(p))
				return true;
		return false;
	}
	
	public boolean obrisiPolozeniIspit(Ocena o) {			// brise ga iz liste polozenih ispita
		if(polozeniIspiti.contains(o))
			if(polozeniIspiti.remove(o))
				return true;
		return false;
	}
	
	@Override
	public String toString() {
		String out =  "Student Ime: " + ime + "\n";
		out += "Prezime: " + prezime + "\n"; 
		out += "Datum rodjenja: " + datumRodj + "\n";
		out += "Adresa stanovanja: " + adresaStan + "\n";
		out += "Kontakt telefon: " + konTel + "\n";
		out += "E-mail adresa: " +  email + "\n";
		out += "Broj indeksa: " + brIndexa + "\n";
		out += "Godina upisa: " + godUpisa + "\n";
		out += "Trenutna godina studija: " + trenutnaGodStud + "\n";
		out += "Status: " + status + "\n";
		out += "Prosecna ocena: " + posecnaOcena + "\n";
		if(!polozeniIspiti.isEmpty()) {
			out += "Spisak polozenih ispita: \n";
			for(Ocena o: polozeniIspiti) {
				out += o.getPredmet().getNaziv() + "\n";
			}
		} else {
			out += "Nema polozenih ispita.\n"; 
		}
		if(!nepolozeniIspiti.isEmpty()) {
			out += "Spisak nepolozenih ispita: \n";
			for(Predmet p: nepolozeniIspiti) {
				out += p.getNaziv() + "\n";
			}
		} else {
			out += "Nema nepolozenih ispita.\n"; 
		}
		return out;
	}
}

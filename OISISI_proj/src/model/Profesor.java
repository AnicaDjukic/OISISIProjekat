package model;

//importi : 
import java.util.ArrayList;

public class Profesor {
	private String prezime;
	private String ime;
	private String drp;                    //datum rodjenja prof
	private String adr_stan;               //adresa stanovanja
	private String kon_tel;                //kontakt telefon
	private String email;
	private String adr_kanc;               //adresa kancelarije
	private String br_lic_kart;            //broj licne karte
	private String titula;
	private String zvanje;
	//private ArrayList<Predmet> spis_pred //spisak predmeta
	
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
	public String getAdr_stan() {
		return adr_stan;
	}
	public void setAdr_stan(String adr_stan) {
		this.adr_stan = adr_stan;
	}
	public String getKon_tel() {
		return kon_tel;
	}
	public void setKon_tel(String kon_tel) {
		this.kon_tel = kon_tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdr_kanc() {
		return adr_kanc;
	}
	public void setAdr_kanc(String adr_kanc) {
		this.adr_kanc = adr_kanc;
	}
	public String getBr_lic_kart() {
		return br_lic_kart;
	}
	public void setBr_lic_kart(String br_lic_kart) {
		this.br_lic_kart = br_lic_kart;
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
	
	//konstruktori :
	public Profesor() {
		this.prezime = "";
		this.ime = "";
		this.drp = "";
		this.adr_stan = "";
		this.adr_kanc = "";
		this.kon_tel = "";
		this.email = "";
		this.br_lic_kart = "";
		this.titula = "";
		this.zvanje = "";
	}
	
	public Profesor(String pr, String im, String dr, String ads,
			String adk, String kt, String em, String blk, String tit, String zv) {
		this.prezime = pr;
		this.ime = im;
		this.drp = dr;
		this.adr_stan = ads;
		this.adr_kanc = adk;
		this.kon_tel = kt;
		this.email = em;
		this.br_lic_kart = blk;
		this.titula = tit;
		this.zvanje = zv;
	}
	
	//Dodatne metode :
	
	public String toString() {
		String out = "Ime : " + this.ime + "\n";
		out += "Prezime : " + this.prezime + "\n";
		out += "Datum rodjenja : " + this.drp + "\n";
		out += "Adresa stanovanja : " + this.adr_stan + "\n";
		out += "Kontakt telefon : " + this.kon_tel + "\n";
		out += "Email : " + this.email + "\n";
		out += "Adresa kancelarije : " + this.adr_kanc + "\n";
		out += "Broj licne karte : " + this.br_lic_kart + "\n";
		out += "Titula : " + this.titula + "\n";
		out += "Zvanje : " + this.zvanje + "\n";
		return out;
	}
	
}

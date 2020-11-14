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
		return adrStan;
	}
	public void setAdr_stan(String adr_stan) {
		this.adrStan = adr_stan;
	}
	public String getKon_tel() {
		return konTel;
	}
	public void setKon_tel(String kon_tel) {
		this.konTel = kon_tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdr_kanc() {
		return adrKanc;
	}
	public void setAdr_kanc(String adr_kanc) {
		this.adrKanc = adr_kanc;
	}
	public String getBr_lic_kart() {
		return brLicKart;
	}
	public void setBr_lic_kart(String br_lic_kart) {
		this.brLicKart = br_lic_kart;
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
		this.adrStan = "";
		this.adrKanc = "";
		this.konTel = "";
		this.email = "";
		this.brLicKart = "";
		this.titula = "";
		this.zvanje = "";
	}
	
	public Profesor(String pr, String im, String dr, String ads,
			String adk, String kt, String em, String blk, String tit, String zv) {
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
	}
	
	//Dodatne metode :
	
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
		return out;
	}
	
}

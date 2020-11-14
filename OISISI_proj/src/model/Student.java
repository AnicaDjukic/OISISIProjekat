package model;

enum StatusStudenta {B, S}

public class Student {
	private String prezime;
	private String ime;
	private String datumRodj;
	private String adresaStan;
	private String konTel;
	private String email;
	private String brIndexa;
	private String godUpisa;
	private String trenutnaGodStud;
	private StatusStudenta status;
	private double posecnaOcena;
	// nedostaje spisak ocena 
	// nedostaje spisak nepolozenih ispita
	
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
	public String getTrenutnaGodStud() {
		return trenutnaGodStud;
	}
	public void setTrenutnaGodStud(String trenutnaGodStud) {
		this.trenutnaGodStud = trenutnaGodStud;
	}
	public StatusStudenta getStatus() {
		return status;
	}
	public void setStatus(StatusStudenta status) {
		this.status = status;
	}
	public double getPosecnaOcena() {
		return posecnaOcena;
	}
	public void setPosecnaOcena(double posecnaOcena) {
		this.posecnaOcena = posecnaOcena;
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
		this.trenutnaGodStud = "";
		this.status = StatusStudenta.B;
		this.posecnaOcena = 0.0;
		
		
	}
	public Student(String prezime, String ime, String datumRodj, String adresaStan, String konTel, String email,
			String brIndexa, String godUpisa, String trenutnaGodStud, StatusStudenta status, int posecnaOcena) {
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
		this.status = status;
		this.posecnaOcena = posecnaOcena;
	}
	
	@Override
	public String toString() {
		return "Student [prezime=" + prezime + ", ime=" + ime + ", datumRodj=" + datumRodj + ", adresaStan="
				+ adresaStan + ", konTel=" + konTel + ", email=" + email + ", brIndexa=" + brIndexa + ", godUpisa="
				+ godUpisa + ", trenutnaGodStud=" + trenutnaGodStud + ", status=" + status + ", posecnaOcena="
				+ posecnaOcena + "]";
	}
	
	
	
}

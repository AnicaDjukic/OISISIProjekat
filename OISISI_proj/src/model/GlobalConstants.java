package model;

public class GlobalConstants {
	//Some default sizes :
	public static int aoedw = 400;  //addOrEditWidth
	public static int aoedh = 500;  //addOrEditHeight
	
	//Label names :
	public static String imeLab = "Ime : ";
	public static String przLab = "Prezime : ";
	public static String drLab = "Datum rođenja : "; 
	public static String adrKancLab = "Adresa kancelarije : ";
	public static String adrStanLab = "Adresa stana : ";
	public static String konTelLab = "Kontakt telefon : ";
	public static String brLicKartLab = "Broj lične karte : ";
	public static String emailLab = "Email : ";
	public static String titulaLab = "Titula : ";
	public static String zvanjeLab = "Zvanje : ";
	
	public static String indexLab = "Broj indeksa: ";
	public static String upisLab = "Godina upisa: ";
	public static String trenutnaLab = "Trenutna godina studija: ";
	public static String finansLab = "Na�in finansiranja: ";
	
	public static String dodajStud = "Dodaj studenta";
	public static String editStud = "Izmeni studenta";
	
	//Label tooltips :
	public static String przImeToolTip = "Samo slova su dozvoljena";
	public static String drpToolTip = "dd.MM.yyyy format";
	public static String adrToolTip = "Adresa se sastoji iz imena ulice i broja zgrade";
	public static String konTelToolTip = "<html>Samo brojevi su dozvoljeni <br> izmedju 6 i 10 cifara</html>";
	public static String emailToolTip = "<html>Standardni email format : ...@domen <br> Podržani domeni : gmail.com, hotmail.com, yahoo.com, uns.ac.rs</html>";
	public static String brLicKartToolTip = "<html>Samo brojevi su dozvoljni <br> tacno 9 cifara obavezno</html>";
	public static String titZvToolTip = "Dozvoljeno je jedna ili više reči";
	
	//Misc texts :
	public static String obvPolje = "Obavezno polje!";
	public static String errAddProf = "Neuspešno dodavanje profesora!";
	
	
	//Button toolips : 
	public static String addBtnToolTipTxt = "Dodaj novog";
	public static String editBtnToolTipTxt = "Izmeni";
	public static String delBtnToolTipTxt = "Obriši";
	public static String srchBtnToolTipTxt = "Pretraži";
	public static String srchFieldToolTipTxt = "";
	
	//Frame names : 
	public static String mfName = "Studentska služba";
	
	public static String tabStudentName = "Studenti";
	public static String tabProfesorName = "Profesori";
	public static String tabPredmetName = "Predmeti";
	
	public static String profAdd = "Dodavanje profesora";
	public static String profEdit = "Izmeni profeosra";
	public static String errName = "Greška";
	
	//Clomun names predmet : 
	public static String spr = "Šifra predmeta : ";
	public static String npr = "Naziv predmeta : ";
	public static String espb = "ESPB : ";
	public static String god = "Godina : ";
	public static String sem = "Semestar : ";
	
	//Image usage : 
	public static String addImg = "images/add_button.png";
	public static String editImg = "images/edit_button.png";
	public static String delImg = "images/bin_button.png";
	public static String srcImg = "images/search_button.png";
	
	//Button txts : 
	public static String btnOkName = "Potvrdi";
	public static String btnCncName = "Odustani";
	
	//Regex :
	public static String regExNameOrSurename = "[a-z]+";
	public static String regExAddress = "([a-z]+[\\s])+[1-9][0-9]{0,2}";
	public static String regExNumber = "[0-9]+";
	public static String regExEmail = ".+@((\\bgmail.com\\b)|(\\byahoo.com\\b)|(\\buns.ac.rs\\b)|(\\bhotmail.com\\b))";
	public static String regExTitOrMaj = "[a-z]+([\\s][a-z]+)*";

}

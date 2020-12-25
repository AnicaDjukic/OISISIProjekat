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
	public static String adrStanLab = "Adresa stanovanja : ";
	public static String konTelLab = "Kontakt telefon : ";
	public static String brLicKartLab = "Broj lične karte : ";
	public static String emailLab = "Email : ";
	public static String titulaLab = "Titula : ";
	public static String zvanjeLab = "Zvanje : ";
	
	public static String indexLab = "Broj indeksa : ";
	public static String upisLab = "Godina upisa : ";
	public static String trenutnaLab = "Trenutna godina studija : ";
	public static String finansLab = "Način finansiranja : ";
	
	//Label tooltips :
	public static String przImeToolTip = "Samo slova su dozvoljena";
	public static String drpToolTip = "dd.MM.yyyy format";
	public static String adrToolTip = "Adresa se sastoji iz imena ulice i broja zgrade";
	public static String konTelToolTip = "<html>Samo brojevi su dozvoljeni <br> izmedju 6 i 10 cifara</html>";
	public static String emailToolTip = "<html>Standardni email format : ...@domen <br> Podržani domeni : gmail.com, hotmail.com, yahoo.com, uns.ac.rs</html>";
	public static String brLicKartToolTip = "<html>Samo brojevi su dozvoljni <br> tacno 9 cifara obavezno</html>";
	public static String titZvToolTip = "Dozvoljeno je jedna ili više reči";
	public static String brIndexaToolTip = "<html>SS-xxx-yyyy format, SS-smer, xxx-broj (najmanje 1 cifra) <br> yyyy-godina upisa (od 2000.)</html>";
	public static String godUpisaToolTip = "yyyy format, godine od 2000.";
	
	//Misc texts :
	public static String obvPolje = "Obavezno polje!";
	public static String errAddProf = "Neuspešno dodavanje profesora!";
	public static String errAddStud = "Neuspešno dodavanje studenta, postoji student sa istim brojem indeksa!";
	public static String upitZatvaranjeMF = "Da li ste sigurni da želite da zatvorite aplikaciju?";
	public static String upitZatvaranjeTitle = "Zatvaranje aplikacije";
	public static String yesOpt = "Da";
	public static String noOpt = "Ne";
	
	//Button toolips : 
	public static String addBtnToolTipTxt = "New";
	public static String editBtnToolTipTxt = "Edit";
	public static String delBtnToolTipTxt = "Delete";
	public static String srchBtnToolTipTxt = "Search";
	public static String srchFieldToolTipTxt = "";
	
	
	public static String menuFile = "File"; 
	public static String menuNew = "New";
	public static String menuClose = "Close";
	public static String menuEdit = "Edit";
	public static String menuDelete = "Delete";
	public static String menuHelp = "Help";
	public static String menuAbout = "About";
	
	//Frame names : 
	public static String mfName = "Studentska služba";
	
	public static String tabStudentName = "Studenti";
	public static String tabProfesorName = "Profesori";
	public static String tabPredmetName = "Predmeti";
	
	public static String profAdd = "Dodavanje profesora";
	public static String profEdit = "Izmeni profeosra";
	public static String dodajStud = "Dodavanje studenta";
	public static String editStud = "Izmeni studenta";
	public static String errName = "Greška";
	
	//Clomun names predmet : 
	public static String spr = "Šifra predmeta : ";
	public static String npr = "Naziv predmeta : ";
	public static String espb = "ESPB : ";
	public static String god = "Godina : ";
	public static String sem = "Semestar : ";
	
	//Image usage : 
	public static String addImg = "images/add_button.png";
	public static String closeImg = "images/close_button.png";
	public static String editImg = "images/edit_button.png";
	public static String delImg = "images/bin_button.png";
	public static String helpImg = "images/help_button.png";
	public static String aboutImg = "images/about_button.png";
	public static String srcImg = "images/search_button.png";
	public static String menuBarImg = "images/Menu_Bar.png";
	public static String toolBarImg = "images/Tool_Bar.png";
	
	//Button txts : 
	public static String btnOkName = "Potvrdi";
	public static String btnCncName = "Odustani";
	
	//Regex :
	public static String regExNameOrSurename = "\\p{L}+";
	public static String regExAddress = "([\\p{L}]+[\\s])+[1-9][0-9]{0,2}";
	public static String regExNumber = "[0-9]+";
	public static String regExEmail = ".+@((\\bgmail.com\\b)|(\\byahoo.com\\b)|(\\buns.ac.rs\\b)|(\\bhotmail.com\\b))";
	public static String regExTitOrMaj = "[a-z]+([\\s][a-z]+)*";

	public static String regExBrIndexa = "[a-zA-Z]{2}[-][0-9]{1,3}[-][2]{1}[0]{1}[0,1,2]{1}[0-9]{1}";
	public static String regGodUpisa = "[2]{1}[0]{1}[0,1,2]{1}[0-9]{1}";
	public static String[] regExDatePoss = {"dd.MM.yyyy.", "dd.MM.yyyy", "d.MM.yyyy.", "d.MM.yyyy", "dd.M.yyyy.", "dd.M.yyyy", "d.M.yyyy.", "d.M.yyyy"};

}

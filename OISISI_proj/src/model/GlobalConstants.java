package model;

import java.io.File;

import javax.swing.Icon;

public class GlobalConstants {
	//Some default sizes :
	public static int aoedw = 400;  //addOrEditWidth
	public static int aoedh = 500;  //addOrEditHeight
	
	//Tekst za predmete koji nemaju profesora:
	public static String prdNemaProf = "Nema profesora";
	
	//Prof dummy:
	public static Profesor dummy = new Profesor();
	
	//Label names :
	public static String imeLab = "Ime* ";
	public static String przLab = "Prezime* ";
	public static String drLab = "Datum rođenja* "; 
	public static String adrKancLab = "Adresa kancelarije* ";
	public static String adrStanLab = "Adresa stanovanja* ";
	public static String konTelLab = "Kontakt telefon* ";
	public static String brLicKartLab = "Broj lične karte* ";
	public static String emailLab = "Email* ";
	public static String titulaLab = "Titula* ";
	public static String zvanjeLab = "Zvanje* ";
	
	public static String indexLab = "Broj indeksa* ";
	public static String upisLab = "Godina upisa* ";
	public static String trenutnaLab = "Trenutna godina studija* ";
	public static String finansLab = "Način finansiranja* ";
	
	public static String sifraLab = "Šifra* ";
	public static String nazivLab = "Naziv* ";
	public static String godIzvLab = "Godina*";
	public static String semestarLab = "Semestar* ";
	public static String espbLab = "ESPB* ";
	public static String profLab = "Profesor";
	public static String ocenaLab = "Ocena*";
	public static String datLab = "Datum*";
	
	//TextField tooltips :
	public static String przImeToolTip = "Samo slova su dozvoljena";
	public static String drpToolTip = "dd.MM.yyyy format";
	public static String adrToolTip = "Adresa se sastoji iz imena ulice i broja zgrade";
	public static String konTelToolTip = "<html>Samo brojevi su dozvoljeni <br> izmedju 6 i 10 cifara</html>";
	public static String emailToolTip = "<html>Standardni email format : ...@domen <br> Podržani domeni : gmail.com, hotmail.com, yahoo.com, uns.ac.rs</html>";
	public static String brLicKartToolTip = "<html>Samo brojevi su dozvoljni <br> tacno 9 cifara obavezno</html>";
	public static String titZvToolTip = "Dozvoljeno je jedna ili više reči";
	public static String brIndexaToolTip = "<html>SS-xxx-yyyy format, SS-smer, xxx-broj (najmanje 1 cifra)<br>yyyy-godina upisa (godine od 2000.)</html>";
    public static String godUpisaToolTip = "yyyy format, godine od 2000.";
	
	public static String srchProfToolTip = "<html>Format : \"prezime\" \"ime\"<br>Pretraga je case insensitive</html>";
	public static String srchPredToolTip = "<html>Format : \"naziv\"<br>Pretraga je case insensitive</html>";
	public static String srchStudToolTip =  "<html>Format : \"prezime\" \"ime\" \"broj indeksa\"<br>Pretraga je case insensitive</html>";
	
	public static String nazivPredToolTip = "Mora početi slovom, može sadržati i jednu cifru";
	public static String espbToolTip = "1 ili 2 cifre, prva cifra ne sme biti 0";
	public static String profToolTip = "Odaberite profesora klikom na dugme '+'";
	
	//Misc texts :
	public static String obvPolje = "Obavezno polje!";
	public static String errAddProf = "Neuspešno dodavanje profesora!";
	public static String errEditProf = "Neuspešna izmena profesora!";
	public static String errAddStud = "Neuspešno dodavanje studenta, postoji student sa istim brojem indeksa!";
	public static String errAddPred = "Neuspešno dodavanje predmeta, postoji predmet sa istom šifrom!";
	public static String upitZatvaranjeMF = "Da li ste sigurni da želite da zatvorite aplikaciju?";
	public static String upitZatvaranjeTitle = "Zatvaranje aplikacije";
	public static String yesOpt = "Da";
	public static String noOpt = "Ne";
	public static String upitBrisanjePred = "Da li ste sigurni da želite da obrišete izabrani?";
	public static String upitSklanjanjeProfTitle = "Uklanjanje profesora";
	public static String upitSklanjanjeProfSaPred = "Da li ste sigurni da želite da uklonite izabranog profesora sa predmeta?";
	public static String upitBrisanjePredTitle = "Uklanjanje predmeta";
	public static String dodavanjePredProfDialog = "Dodaj predmet";
	public static String dodavanjeProfPredDialog = "Odaberi profesora";
	public static String predmetiTekst = "Predmeti :";
	public static String upitBrisanjeProf = "Da li ste sigurni da želite da obrišete izabranog profesora?";
	public static String upitBrisanjeProfTitle = "Brisanje profesora";
	public static String btnPonisti = "Poništi ocenu";
	public static String upitBrisanjePredKodStud = "Da li ste sigurni da želite da uklonite predmet?";
    public static String greskaPriIzboruPredmeta = "Niste izabrali ni jedan predmet";
    public static String upitBrisanjeStud = "Da li ste sigurni da želite da obrišete izabranog studenta?";
    public static String upitBrisanjeStudTitle = "Brisanje studenta";
    public static String greskaPriIzboruOcene = "Niste izabrali ni jednu ocenu";
    public static String upitPonistavenjeOceneTitle = "Poništavanje ocene";
    public static String upitPonistavenjeOcene = "Da li ste sigurni da želite da poništite ocenu?";
    public static String upitBrisanjePredKodProf = "Da li ste sigurni?";
	
	public static String btnDodaj = "Dodaj";
	public static String btnObrisi = "Obriši";
	public static String btnPolaganje = "Polaganje";
	
	//Button toolips : 
	public static String addBtnToolTipTxt = "New";
	public static String editBtnToolTipTxt = "Edit";
	public static String delBtnToolTipTxt = "Delete";
	public static String srchBtnToolTipTxt = "Search";
	public static String srchFieldToolTipTxt = "";
	public static String advSearchToolTip = "Napredna pretraga";
	
	
	public static String menuFile = "File"; 
	public static String menuNew = "New";
	public static String menuClose = "Close";
	public static String menuEdit = "Edit";
	public static String menuDelete = "Delete";
	public static String menuHelp = "Help";
	public static String menuAbout = "About";
	public static String menuAdvanced = "Advanced"; 
	public static String menuLanguage = "Language";
	public static String menuSearch = "Search";
	public static String menuSerbian = "Serbian";
	public static String menuEnglish = "English";
	//Frame names : 
	public static String mfName = "Studentska služba";
	
	public static String tabStudentName = "Studenti";
	public static String tabProfesorName = "Profesori";
	public static String tabPredmetName = "Predmeti";
	
	public static String profAdd = "Dodavanje profesora";
	public static String profEdit = "Izmeni profesora";
	public static String studAdd = "Dodavanje studenta";
	public static String editStud = "Izmeni studenta";
	public static String predAdd = "Dodavanje predmeta";
	public static String predEdit = "Izmeni predmet";
	public static String errName = "Greška";
	public static String unosOcene = "Unos ocene";
	
	//Clomun names predmet : 
	public static String spr = "Šifra predmeta : ";
	public static String npr = "Naziv predmeta : ";
	public static String espb = "ESPB : ";
	public static String god = "Godina : ";
	public static String sem = "Semestar : ";
	
	//Image usage : 
	public static String addImg = "images" + File.separator + "add_button.png";
	public static String closeImg = "images" + File.separator + "close_button.png";
	public static String editImg = "images" + File.separator + "edit_button.png";
	public static String delImg = "images" + File.separator + "bin_button.png";
	public static String helpImg = "images" + File.separator + "help_button.png";
	public static String aboutImg = "images" + File.separator + "about_button.png";
	public static String srcImg = "images" + File.separator + "search_button.png";
	public static String menuBarImg = "images" +  File.separator + "Menu_Bar.png";
	public static String toolBarImg = "images" + File.separator + "Tool_Bar.png";
	public static String advSearImg = "images" + File.separator + "adv_search.png";
	public static String searchFieldImg = "images" + File.separator + "search_field.png";
	public static String languageImg = "images" + File.separator + "language_image.png";
	public static String serbianImg = "images" + File.separator + "serbian_img.png";
	public static String englishImg = "images" + File.separator + "english_img.png";
	
	//Button txts : 
	public static String btnOkName = "Potvrdi";
	public static String btnCncName = "Odustani";
	public static String btnDodPred = "Dodaj predmet";
	public static String btnUklPred = "Ukloni predmet";
	
	//Regex :
	public static String regExNameOrSurename = "\\p{L}+";
	public static String regExAddress = "([\\p{L}]+[\\s])+[1-9][0-9]{0,2}";
	public static String regExNumber = "[0-9]+";
	public static String regExEmail = ".+@((\\bgmail.com\\b)|(\\byahoo.com\\b)|(\\buns.ac.rs\\b)|(\\bhotmail.com\\b))";
	public static String regExTitOrMaj = "[a-z]+([\\s][a-z]+)*";
	public static String regExBrIndexa = "[a-zA-Z]{2}[-][0-9]{1,3}[-][2]{1}[0]{1}[0,1,2]{1}[0-9]{1}";
	public static String regGodUpisa = "[2]{1}[0]{1}[0,1,2]{1}[0-9]{1}";
	
	public static String regExNazivPred = "([\\p{L}]+[\\s]{0,1})+[0-9]{0,1}";
	public static String regExEspb = "[1-9]{1}[0-9]{0,1}";
	
	public static String[] regExDatePoss = {"dd.MM.yyyy.", "dd.MM.yyyy", "d.MM.yyyy.", "d.MM.yyyy", "dd.M.yyyy.", "dd.M.yyyy", "d.M.yyyy.", "d.M.yyyy"};
	
	//Edit tab names :
	public static String profEditTabOsnInf = "Informacije";
	public static String profEditTabPrd = "Predmeti";
	
	//Error za naprednu pretragu prof :
	public static String errAdvSearProf = "Nije omogućena napredna pretraga profesora";
	
	//Naslovi napredne pretrage :
	public static String advTitlePred = "Napredna pretraga predmeta";
	
	public static String labAdvSear = "Relacioni izraz :";
	
	//Possible marks :
	public static String[] ocene = {"6","7","8","9","10"};
	
	//Titula i zvanje :
	public static String[] zvanja = {"Saradnik u nastavi","Asistent", "Asistent sa doktoratom", "Docent", "Vanredni profesor", "Redovni profesor", "Profesor emeritus"};
	public static String[] titule = {"BSc", "MSc", "Magistar", "Doktor nauka", "Profesor dr."};
	
	//Tooltip za dodatni zadatak :
	public static String advSearchToolTipPred = "<html>Početak iskaza mora biti formata \"predmeti = (...)\" <br>Lista podržanih polja za pretragu kod "
												+ "predmeta : <br>  *sifra - po vrednosti (izmedju \"\") i po regex-u (između / /)<br>  *naziv - po vrednosti (između \"\") i po regex-u(između / /)<br>"
												+ "  *godina - po vrednosti<br>  *semestar - letnji/zimski<br>  *espb bodovima - po vrednosti<br>  *profesorima - profesori se unose"
												+ " u upit u obliku \"profesori == {...}\"<br>   polja podržana kod profesora :<br>    *ime - po vrednosti (između \"\") i po regex-u (između / /)<br>"
												+ "    *prezime - po vrednosti (između \" \") i po regex-u (između / /)<br>    *titula - jedna od titula iz ponuđenih<br>    *zvanje "
												+ "- jedno iz ponuđenih </html>";
	
}

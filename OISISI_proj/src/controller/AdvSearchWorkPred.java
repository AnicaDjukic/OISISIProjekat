package controller;

import java.util.ArrayList;
import java.util.Set;

import com.bpodgursky.jbool_expressions.Expression;
import com.bpodgursky.jbool_expressions.parsers.ExprParser;
import com.bpodgursky.jbool_expressions.rules.RuleSet;

import model.Predmet;
import view.AdvSearDialog;
import view.ErrorDialog;
import view.GlavniProzor;
import view.TabelaPredmeti;

//predmeti = (sifra == '0' and naziv == '0')
//predmeti = (sifra == a or godina == 2 and (sifra == 3 and semestar == letnji))
//A | B & C & D

public class AdvSearchWorkPred {	
	
	ErrorDialog err;
	boolean hadError;
	Expression<String> exp;
	String[] collection;
	char i;
	
	ArrayList<Var> vars;
	
	String myExp;
	
	ArrayList<Predmet> solution;
	
	public AdvSearchWorkPred(String s) {
		hadError = false;
		i = 'A';
		myExp = "";
		vars = new ArrayList<Var>();
		
		
		s = s.trim();
		
		s = s.replaceAll("\\Q(\\E", " ( ");
		s = s.replaceAll("\\Q)\\E", " ) ");
		s = s.replaceAll("\\Q&&\\E", "and");
		s = s.replaceAll("\\Q||\\E", "or");
		s = s.replaceAll(" +", " ");
		
		collection = s.split(" ");
		
		
		makeVars();
		
		if(!hadError) {
			exp = RuleSet.simplify(ExprParser.parse(myExp));	
			exp = RuleSet.toDNF(exp);
			myExp = exp.toString();
		}
		
		//Sredjivanje u pogodan oblik forme :
		
		if(!hadError) {
			myExp = myExp.replaceAll("\\Q(\\E", "");
			myExp = myExp.replaceAll("\\Q)\\E", "");
			myExp = myExp.replaceAll("\\Q & \\E", "");
			myExp = myExp.replaceAll("\\Q | \\E", "+");
			//System.out.println(myExp);
		}
		//Za svaku nadjenu promenljivu izvrsi njen upit :
		if(!hadError)
			executeVarQuerries();
			
		//Izvrsi ceo izraz :
		if(!hadError)
			executeExpression();
		
		if(!hadError) {
			ArrayList<String> foundSifs = new ArrayList<String>();
			for(Predmet p : solution)
				foundSifs.add(p.getSifPred());
			
			TabelaPredmeti.izlistajPredmete(foundSifs);
			AdvSearDialog.inst.setVisible(false);
		}
		
	}
	//Klasa promenljivih za predmete:
	class Var{
		char name;
		String value;
		ArrayList<Predmet> sol;
		
		public Var(char n, String v) {
			name = n;
			value = v;
			sol = new ArrayList<Predmet>();
		}
		
		public char getN() { return name; }
		public String getV() { return value; }
		public ArrayList<Predmet> getSol() {return sol;}
	}
	
	public void makeVars() {
		
		if(!collection[0].toLowerCase().equals("predmeti") || !collection[1].equals("=")) {
			err = new ErrorDialog("Iskaz ne počinje korektno");
			hadError = true;
			return;
		}
		else {
			int k = 2;
			do {
				if(collection[k].equals("(")) {
					myExp += " " + collection[k] + " ";
					k++;
				}
				else if(collection[k].equals(")")) {
					myExp += " " + collection[k] + " ";
					k++;
				}
				else if(collection[k].equalsIgnoreCase("sifra")) {
					hadError = !createVar(collection[k], collection[k+1], collection[k+2]);
					k+=3;
				}
				else if(collection[k].equalsIgnoreCase("naziv")) {
					hadError = !createVar(collection[k], collection[k+1], collection[k+2]);
					k+=3;
				}
				else if(collection[k].equalsIgnoreCase("ESPB")) {
					hadError = !createVar(collection[k], collection[k+1], collection[k+2]);
					k+=3;
				}
				else if(collection[k].equalsIgnoreCase("godina")) {
					hadError = !createVar(collection[k], collection[k+1], collection[k+2]);
					k+=3;
				}
				else if(collection[k].equals("semestar")) {
					hadError = !createVar(collection[k], collection[k+1], collection[k+2]);
					k+=3;
				} 
				else if(collection[k].equalsIgnoreCase("and")) {
					myExp += " & ";
					k++;
				}
				else if(collection[k].equalsIgnoreCase("or")) {
					myExp += " | ";
					k++;
				}
				else {
					err = new ErrorDialog("Nije spojeno ni sa jednim tokenom, proverite izraz");
					hadError = true;
					break;
				}
				if(hadError) 
					break;
				
			}while(k < collection.length);
		}
	}
	
	public boolean createVar(String col, String exp, String val) {
		
		Var temp;
		String s = col + " " +  exp + " " + val;
		if(col.equalsIgnoreCase("sifra") || col.equalsIgnoreCase("naziv")) {
			if(!exp.equals("==") && !exp.equals("!=")) {
				err = new ErrorDialog("Tipovi sifra i naziv mogu imati relacione operatore !=/==");
				return false;
			}
			temp = new Var(i,s);
			myExp += " " + i++ + " ";
			vars.add(temp);
		}
		else if(col.equalsIgnoreCase("espb") || col.equalsIgnoreCase("godina")) {
			if(!checkExp(exp)) {
				err = new ErrorDialog("Nije validan operator za tip ESPB/godina");
				return false;
			}
			temp = new Var(i,s);
			myExp += " " + i++ + " ";
			vars.add(temp);
		}
		else if(col.equalsIgnoreCase("semestar")) {
			if(!exp.equals("==") && !exp.equals("!=")) {
				err = new ErrorDialog("Tip semestar ne prihvata zadate relacione operatore");
				return false;
			}
			if(!val.toLowerCase().equals("zimski") && !val.toLowerCase().equals("letnji")) {
				err = new ErrorDialog("Tip semestar ne prihvata zadatu vrednost");
				return false;
			}
			temp = new Var(i,s);
			myExp += " " + i++ + " ";
			vars.add(temp);
		}
		else {
			return false;
		}
		
		return true;
	}
	
	public boolean checkExp(String exp) {
		switch(exp) {
		case "==":
		case "!=":
		case "<":
		case ">":
		case "<=":
		case ">=":
			return true;
		default : return false;
		}	
	}
	
	public void executeVarQuerries() {
		boolean noErrors = true;
		for(Var v : vars) {
			if(v.getV().toLowerCase().startsWith("sifra") || v.getV().toLowerCase().startsWith("naziv"))
				noErrors &= GlavniProzor.getControllerPredmet().advSrcTxt(v.getV(), v.getSol());
			else if(v.getV().toLowerCase().startsWith("espb") || v.getV().toLowerCase().startsWith("godina"))
				noErrors &= GlavniProzor.getControllerPredmet().advSrcNum(v.getV(), v.getSol());
			else if(v.getV().toLowerCase().startsWith("semestar"))
				noErrors &= GlavniProzor.getControllerPredmet().advSrcSem(v.getV(), v.getSol());
			else
				noErrors &= false;
		}
		if(!noErrors) {
			err = new ErrorDialog("Neuspešno izvršavanje pojedinačnih upita");
			hadError = true;
		}
	}
	
	//Nalazi promenljive po njihovom imenu tj slovu :
	public Var getVbyName(char a) {
		for(Var v : vars)
			if(v.getN() == a)
				return v;
		return null;
	}
	
	public void executeExpression() {
		String[] toInter = myExp.split("\\+");
		System.out.println(toInter.length);
		ArrayList<ArrayList<Predmet>> toDo = new ArrayList<ArrayList<Predmet>>();
		ArrayList<ArrayList<Predmet>> toOr = new ArrayList<ArrayList<Predmet>>();
		for(String s : toInter) {
			for(char c : s.toCharArray())
				toDo.add(getVbyName(c).getSol());
			toOr.add(GlavniProzor.getControllerPredmet().intersect(toDo));
			toDo = new ArrayList<ArrayList<Predmet>>();
		}
		
		solution = GlavniProzor.getControllerPredmet().union(toOr);
	}
}

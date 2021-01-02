package controller;

import java.util.ArrayList;
import java.util.Set;

import com.bpodgursky.jbool_expressions.Expression;
import com.bpodgursky.jbool_expressions.parsers.ExprParser;
import com.bpodgursky.jbool_expressions.rules.RuleSet;

import model.Predmet;
import view.AdvSearDialog;
import view.ErrorDialog;

//predmeti = (sifra == '0' and naziv == '0')

public class AdvSearchWorkPred {	
	
	ErrorDialog err;
	boolean hadError;
	Expression<String> exp;
	String[] collection;
	char i;
	
	Set<String> set;
	
	ArrayList<Var> vars;
	
	String myExp;
	
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
			System.out.println(myExp);
			
			for(Var v : vars) {
				System.out.println("--------------------------");
				System.out.println("Var : " + v.getN());
				System.out.println("Value : " + v.getV());
			}
		}
		System.out.println("Sad ide pravi test :");
		
		if(!hadError) {
			exp = RuleSet.simplify(ExprParser.parse(myExp));	
			AdvSearDialog.inst.getter().setVisible(false);
			exp = RuleSet.toDNF(exp);
			System.out.println(exp);
		}
		
	}
	
	class Var{
		char name;
		String value;
		ArrayList<Predmet> sol;
		
		public Var(char n, String v) {
			name = n;
			value = v;
		}
		
		public char getN() { return name; }
		public String getV() { return value; }
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
					err = new ErrorDialog("Nije spojeno ni sa jednim tokenom");
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
		switch(col) {
		case "sifra":
		case "naziv":
			if(!exp.equals("==") && !exp.equals("!=")) {
				err = new ErrorDialog("Tipovi sifra i naziv mogu imati relacione operatore !=/==");
				return false;
			}
			temp = new Var(i,s);
			myExp += " " + i++ + " ";
			vars.add(temp);
			return true;
		case "ESPB":
		case "godina":
			if(!checkExp(exp)) {
				err = new ErrorDialog("Nije validan operator za tip ESPB/godina");
				return false;
			}
			temp = new Var(i,s);
			myExp += " " + i++ + " ";
			vars.add(temp);
			break;
		case "semestar":
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
			break;
		default : return false;
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
		
	}
}

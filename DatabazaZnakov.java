package prvyPokus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabazaZnakov {

	private List<Info> databaza = new ArrayList<>();

	public DatabazaZnakov() {

		List<Typ> realReal = new ArrayList<>();
		realReal.add(Typ.REAL);
		realReal.add(Typ.REAL);
		List<Typ> String = new ArrayList<>();
		String.add(Typ.STRING);
		List<Typ> integerReal = new ArrayList<>();
		integerReal.add(Typ.INTEGER);
		integerReal.add(Typ.REAL);
		List<Typ> booBoo = new ArrayList<>();
		booBoo.add(Typ.BOOLEAN);
		booBoo.add(Typ.BOOLEAN);
		
		// bvs
		
		Info plus = new Info("+", 2, new Ins(2, realReal), Typ.REAL, Symbol.FUNK_SYM, null);
		databaza.add(plus);
		Info minus = new Info("-", 2, new Ins(2, realReal), Typ.REAL, Symbol.FUNK_SYM, null);
		databaza.add(minus);
		Info krat = new Info("*", 2, new Ins(2, realReal), Typ.REAL, Symbol.FUNK_SYM, null);
		databaza.add(krat);
		Info delenie = new Info(":", 2, new Ins(2, realReal), Typ.REAL, Symbol.FUNK_SYM, null);
		databaza.add(delenie);
		Info mocnina = new Info("^", 2, new Ins(2, integerReal), Typ.REAL, Symbol.FUNK_SYM, null);
		databaza.add(mocnina);
		
		Info rovnaSa = new Info("=", 2, new Ins(2, realReal), Typ.BOOLEAN, Symbol.REL_SYM, null);
		databaza.add(rovnaSa);
		Info implikacia = new Info("->", 2, new Ins(2, booBoo), Typ.BOOLEAN, Symbol.LOG_SYM, null);
		databaza.add(implikacia);
		Info konjunkcia = new Info("conj", 2, new Ins(2, booBoo), Typ.BOOLEAN, Symbol.LOG_SYM, null);
		databaza.add(konjunkcia);
		Info disjunkcia = new Info("disj", 2, new Ins(2, booBoo), Typ.BOOLEAN, Symbol.LOG_SYM, null);
		databaza.add(disjunkcia);
		Info ekvivalencia = new Info("<=>", 2, new Ins(2, booBoo), Typ.BOOLEAN, Symbol.LOG_SYM, null);
		databaza.add(ekvivalencia);
		
		Info suma = new Info("sum", 2, new Ins(2, integerReal), Typ.REAL, Symbol.FUNK_SYM, "i");
		databaza.add(suma);

		Info premennaX = new Info("x", 0, new Ins(0, String), Typ.INTEGER, null, null);
		databaza.add(premennaX);
		Info premennaY = new Info("y", 0, new Ins(0, String), Typ.REAL, null, null);
		databaza.add(premennaY);
		Info premennaA = new Info("a", 0, new Ins(0, String), Typ.REAL, null, null);
		databaza.add(premennaA);
		Info premennaB = new Info("b", 0, new Ins(0, String), Typ.REAL, null, null);
		databaza.add(premennaB);
		Info premennaI = new Info("i", 0, new Ins(0, String), Typ.INTEGER, null, null);
		databaza.add(premennaI);
		
		

	}

	public Info najdiZaznam(Znak z) {

		for (Info info : databaza) {
			if (info.getOznacenie().equals(z.znak)) {
				return info;
			}
		}
		System.out.println("Znak sa nenasiel.");
		return null;
	}
	
	public void bva(Znak znak) {
		
		List<Znak>bva = new ArrayList<>();
		
		Scanner sc = new Scanner(znak.info.getBvs());
		sc.useDelimiter(",");
		
		while(sc.hasNext()){
			
			bva.add(new Znak(sc.next()));
			
		}
		znak.setBva(bva);
		
	}

}

package prvyPokus;

import java.util.List;

public class Symbol extends Znak{
	
	public static final String KONST_SYM = "konstantovy symbol";
	public static final String FUNK_SYM = "funkciovy symbol";
	public static final String LOG_SYM = "logicky symbol";
	public static final String REL_SYM = "relacny symbol";
	public static final String PRED_SYM = "relacny symbol";
	
	

	private List<Znak> bvs = null;

	public Symbol(String znak) {
		super(znak);
		
	}	
	
	public List<Znak> getViazane() {
		return bvs;
	}
	
	public void pridatViazane(Premenna premenna) {
		
		bvs.add(premenna);
	}
	
	
	
	
	public void setBvs(List<Znak> bvs) {
		this.bvs = bvs;
	}

	public static void main(String[] args) {
		
		Symbol sym = new Symbol("sum()");
		Premenna p1 = new Premenna("i",new Typ("Integer"));
		Premenna p2 = new Premenna("n",new Typ("Integer"));
		
		sym.pridatViazane(p1);
		sym.pridatViazane(p2);
		
		System.out.println("Symbol: "+sym);
		System.out.println("Viazane premenne symbolu " + sym.toString() + " su:" + sym.getViazane().toString());
	}
}

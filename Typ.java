package prvyPokus;

import java.util.HashSet;
import java.util.Set;

import javax.swing.SpringLayout.Constraints;

public class Typ {

	private String oznacenie;
	private MnozinaTypov mT = new MnozinaTypov();
	private String hierarchia;
	
	public static final Typ INTEGER = new Typ("Integer");
	public static final Typ REAL = new Typ("Real");
	public static final Typ CHAR = new Typ("Char");
	public static final Typ STRING = new Typ("String");
	public static final Typ BOOLEAN = new Typ("Boolean");

	
	public Typ(String typ) {
		oznacenie = typ;
	}
	

	public String getPrislusnost() {
		return hierarchia;
	}


	public void setPrislusnost(String prislusnost) {
		this.hierarchia = prislusnost;
	}



	public Set getMnozinaTypov(){
		
		return mT.mnozina;
	}
	
	public boolean constrains(Typ typ){
		
		return mT.mnozina.contains(typ);
	}
	
	@Override
	public String toString() {
		return oznacenie;
	}
	
	private class MnozinaTypov  {
		
		private Set<Typ> mnozina = new HashSet<>();
		
		private MnozinaTypov() {
			
			mnozina.add(INTEGER);
			mnozina.add(REAL);
			mnozina.add(CHAR);
			mnozina.add(STRING);
		}
		
	}
	
	


	public static void main(String[] args) {
	
	}

}

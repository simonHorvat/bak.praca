package prvyPokus;

import java.util.ArrayList;
import java.util.List;

public class Ins {

	int ari;
	
	private List<Typ> typy;
	
	
	public Ins(int ari, List<Typ> typy) {
		super();
		this.ari = ari;
		this.typy = typy;
	}



	@Override
	public String toString() {
		
		String vysledok = "ins = <";
		for (int i = 0; i < ari-1; i++) {
			
		
		vysledok += typy.get(i) +",";
		}
		return vysledok + typy.get(ari-1) + ">";
	}
	
	
	
	public void setAri(int ari) {
		this.ari = ari;
	}



	public void setTypy(List<Typ> typy) {
		this.typy = typy;
	}



	public int getAri() {
		return ari;
	}



	public List<Typ> getTypy() {
		return typy;
	}


	public static void main(String[] args) {
		
		
		List<Typ> typy = new ArrayList<>();
		typy.add(new Typ("Real"));
		typy.add(new Typ("Real"));
		
		Ins plus = new Ins(2, typy);


		System.out.println(plus);
		

	}

}

package prvyPokus;

public class Premenna extends Znak {

	private Typ typ;
	private String oznacenie;
	
	
	public Premenna(String znak, Typ typ) {
		super(znak);
		this.typ = typ;
		oznacenie = znak;
	}
	
	

	public void setTyp(Typ typ) {
		this.typ = typ;
	}



	public static void main(String[] args) {

		Premenna prem = new Premenna("x", new Typ("Real"));
		System.out.println(prem.toString());
		System.out.println("Typ x je: " + prem.typ.toString());
	}

}

package prvyPokus;

import java.util.List;

public class Znak {

	Info info;
	DatabazaZnakov db = new DatabazaZnakov();
	private List<Znak> bva = null;


	String znak;

	public Znak(String znak) {
		super();
		this.znak = znak;
		this.pom();
	}

	@Override
	public String toString() {
		return znak;
	}

	public void pom() {

		try {
			Integer.parseInt(this.toString());
			info = new Info(this.toString(), 0, null, Typ.REAL, Symbol.KONST_SYM, null);

		} catch (NumberFormatException e) {

			info = db.najdiZaznam(this);
			if (info.getBvs() != null) {
				db.bva(this);
			}
		}
	}

	public List<Znak> getBva() {
		return bva;
	}

	public void setBva(List<Znak> bva) {
		this.bva = bva;
	}

}

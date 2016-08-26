package prvyPokus;

import java.util.HashSet;
import java.util.Set;

public class Vyraz extends Znak {

	Znak znak;

	private Vyraz lavy;
	private Vyraz pravy;

	public Vyraz(Znak znak, Vyraz lavy, Vyraz pravy) {
		super(znak.toString());

		this.znak = znak;
		this.lavy = lavy;
		this.pravy = pravy;
	}

	public Znak getZnak() {
		return znak;
	}

	public static String stromNaRetazec(Vyraz uzol) {
		String lavy;
		String pravy;
		if (uzol.lavy == null) {
			lavy = "";
		} else {
			lavy = "(" + stromNaRetazec(uzol.lavy) + ")";
		}
		if (uzol.pravy == null) {
			pravy = "";
		} else {
			pravy = "(" + stromNaRetazec(uzol.pravy) + ")";
		}

		return lavy + uzol.toString() + pravy;
	}

	public void vypisInfo() {

		System.out.println(this.znak.info);

		if (lavy != null) {
			lavy.vypisInfo();
		}
		if (pravy != null) {
			pravy.vypisInfo();
		}

	}

	private static Vyraz stromZRetazca(String opisStromu) {
		// System.out.println(opisStromu);
		if (!opisStromu.contains("(")) {
			return new Vyraz(new Symbol(opisStromu), null, null);
		}
		int pocet = 0;
		for (int i = 0; i < opisStromu.length(); i++) {
			char znak = opisStromu.charAt(i);
			if (znak == '(') {
				pocet++;
			}
			if (znak == ')') {
				pocet--;
			}
			if (pocet == 0) {
				int indexZatvorky = opisStromu.indexOf('(', i);
				int koniecCisla = (indexZatvorky == -1) ? opisStromu.length() : indexZatvorky;
				int zaciatokCisla = (i == 0) ? 0 : i + 1;
				Vyraz lavy = null;
				if (i > 0) {
					lavy = stromZRetazca(opisStromu.substring(1, i));
				}

				Vyraz pravy = null;

				if (indexZatvorky != -1) {
					pravy = stromZRetazca(opisStromu.substring(indexZatvorky + 1, opisStromu.length() - 1));
				}
				Vyraz koren = new Vyraz(new Symbol(opisStromu.substring(zaciatokCisla, koniecCisla)), lavy, pravy);
				return koren;
			}
		}
		return null;
	}

	public boolean patriDoExp() {

		if (this.znak.info.getKategoria() == null || this.znak.info.getKategoria() == Symbol.KONST_SYM) {
			return true;
		}

		Typ t1 = this.znak.info.getIns().getTypy().get(0);
		Typ t2 = this.znak.info.getIns().getTypy().get(1);

		if (!(this.znak.info.getAri() == this.znak.info.getIns().ari && t1 == lavy.znak.info.getOut()
				&& t2 == pravy.znak.info.getOut())) {
			System.err.println(this.toString());
			return false;
		}
		if (lavy.patriDoExp() && pravy.patriDoExp()) {
			return true;
		}
		return false;
	}

	public Set<Vyraz> vratSymboly() {

		Set<Vyraz> mn = new HashSet<>();

		if (this.znak.info.getKategoria() != null) {
			mn.add(this);
		}

		if (lavy != null) {
			mn.addAll(lavy.vratSymboly());
		}
		if (pravy != null) {
			mn.addAll(pravy.vratSymboly());
		}

		return mn;
	}

	public Set<Znak> getBve() {

		Set<Znak> bve = new HashSet<>();

		if (this.info.getKategoria() == null) {
			return null;
		}
		if (this.getBva() != null) {
			bve.addAll(this.getBva());
		}

		if (lavy != null) {
			Set<Znak> bveL = lavy.getBve();
			if (bveL != null) {
				bve.addAll(lavy.getBve());
			}
		}
		if (pravy != null) {
			Set<Znak> bveP = pravy.getBve();
			if (bveP != null) {
				bve.addAll(bveP);
			}
		}

		return bve;

	}

	public static void main(String[] args) {

		// String zadanyVyraz = "((4)=(2))->((3)=(y))";
		String zadanyVyraz = "(((i)sum(y))+(2))*(y)";

		System.out.println("Zadany vyraz: " + zadanyVyraz);

		Vyraz v = Vyraz.stromZRetazca(zadanyVyraz);

		System.out.println("Vyraz (Strom) retazca: " + Vyraz.stromNaRetazec(v));
		System.out.println();
		v.vypisInfo();
		System.out.println();

		System.out.println("bve vyrazu: " + v.getBve());
		System.out.println("Vyraz e: " + Vyraz.stromNaRetazec(v) + " patri do Exp: " + v.patriDoExp());

	}

}

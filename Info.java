package prvyPokus;

import java.util.List;

public class Info {

	private String oznacenie;
	private int ari;
	private Ins ins;
	private Typ out;
	private String kategoria;
	
	private String bvs = null;

	public Info(String oznacenie, int ari, Ins ins, Typ out, String kategoria, String bvs) {
		super();
		this.oznacenie = oznacenie;
		this.ari = ari;
		this.ins = ins;
		this.out = out;
		this.kategoria = kategoria;
		this.bvs = bvs;
	}

	@Override
	public String toString() {

		if (kategoria != null) {
			if (ins == null) {
				return "Sym: " + oznacenie + ", ari:" + ari + ", " + " ins = <> " + ", out: " + out + ", " + kategoria;
			}

			return "Sym: " + oznacenie + ", ari:" + ari + ", " + ins.toString() + ", out: " + out + ", " + kategoria;
		}
		return "Var: " + oznacenie +", " +out;
	}

	public String getOznacenie() {
		return oznacenie;
	}

	public int getAri() {
		return ari;
	}

	public Ins getIns() {
		return ins;
	}

	public Typ getOut() {
		return out;
	}

	public String getKategoria() {
		return kategoria;
	}
	
	public String getBvs() {
		return bvs;
	}

	public static void main(String[] args) {

	}

}

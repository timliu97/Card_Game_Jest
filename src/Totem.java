package Jest;

public class Totem {
	private TypeTotemes typeTotem;
	private Couleur couleurTotem;
	private Valeur valeurTotem;
	
	public Totem(TypeTotemes t,Couleur c,Valeur v) {
		this.typeTotem=t;
		this.couleurTotem=c;
		this.valeurTotem=v;
	}
	
	public TypeTotemes getType() {
		return this.typeTotem;
	}
	
	public Couleur getCouleur() {
		return this.couleurTotem;
	}
	
	public Valeur getValeur() {
		return this.valeurTotem;
	}
}

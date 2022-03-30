package Jest;

public class Carte {
	protected Valeur chiffreCarte;
	protected Couleur couleurCarte;
	protected Totem totem;
	
	public Carte(Valeur chiffre,Couleur c) {
		this.chiffreCarte=chiffre;
		this.couleurCarte=c;
	}
		
	public Valeur getValeur() {
		return chiffreCarte;
	}
	
	public Couleur getCouleur() {
		return couleurCarte;
	}
	
	public TypeTotemes getTypeTotem() {
		return totem.getType();
	}
	
	public Couleur getCouleurTotem() {
		return totem.getCouleur();
	}
	
	public Valeur getValeurTotem() {
		return totem.getValeur();
	}
	
	
	public void setValeur(Valeur v) {
		this.chiffreCarte=v;
	}
	
	public void setCouleur(Couleur c) {
		this.couleurCarte=c;
	}
	
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append(this.chiffreCarte.toString());
		sb.append(" de ");
		sb.append(this.couleurCarte.toString());
		return sb.toString();
	}
	
	public int ValeurtoInt() {
		int intValeurCarte=0;
		if (this.chiffreCarte==Valeur.Deux) {
			intValeurCarte = 2;
		}
		if (this.chiffreCarte==Valeur.Trois) {
			intValeurCarte = 3;
		}
		if (this.chiffreCarte==Valeur.Quatre) {
			intValeurCarte = 4;
		}
		//il faut rajouter pour As, Cinq et Joker encore(maybe, but not sure)
		return intValeurCarte;		
	}
}

package Jest;

import java.util.*;

public class Plateau {
	private int partieTrophee;
	private LinkedList<Trophee> trophee;
	
	public Plateau(int p) {
		this.partieTrophee=p;
	}
	
	public void afficherTrophee() {
		System.out.println("Le(s) trophée(s):");
		Iterator<Trophee> tro=trophee.iterator();
		while(tro.hasNext()) {
			Trophee t=(Trophee)tro.next();
			System.out.println(t.toString());
		}
		
	}
	/*
	public void nettoyerPlateau() {
		Iterator<Trophee> t=trophee.iterator();
		while(t.hasNext()) {
			t.remove();
		}
		Iterator<Hand> m=m.iterator();
		while(m.hasNext()) {
			m.remove();
		}
	}
	
	public void afficherOffre() {
		Iterator<Joueur> j=j.iterator();
		while (j.hasNext()) {
			Joueur joueur=(Joueur)j.next();
			System.out.println(joueur.nom+":"+joueur.offre);
		}
	}
	*/
	public void distribuerTrophee(Carte c,Joueur j) {
		j.main.add(c);
	}
	
	public void ajouterTrophee(Trophee t) {
		trophee.add(t);
	}
}

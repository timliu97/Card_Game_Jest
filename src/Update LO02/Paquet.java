package Jest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Paquet {
	public final static int nbCarte=Valeur.values().length*Couleur.values().length-3;
	private LinkedList<Carte> tasDeCartes;//tasDeCartes->cartes
	public ArrayList<Trophee> trophee;
	
	public Paquet() {
		tasDeCartes=new LinkedList<Carte>();//tasDeCartes->cartes
		trophee=new ArrayList<Trophee>();
		
		/*for(Couleur c:Couleur.values()) {
			for(Valeur v:Valeur.values()) {
				switch (v) {
				case Joker:
					Carte joker=new Carte(v,null);
					break;

				default:
					Carte carte=new Carte(v,c);
					tasDeCartes.add(carte);
					break;
				}
			
			}
		}*/
		
		Valeur[] v=Valeur.values();
		Couleur[] c=Couleur.values();
		for(int i=0 ; i < v.length; i++){
			for(int j=0 ; j < c.length ; j++){
				Carte carte = new Carte(v[i] , c[j] );
				tasDeCartes.add(carte);
			}
		}//on crée un tas de carte ordonnée la
	}
	
	public void melanger() {
		/*for(int i=0;i<Paquet.nbCarte;i++) {
			int position=(int)Math.round((Paquet.nbCarte-1)*Math.random());
			Carte carte=tasDeCartes.pop();
			tasDeCartes.add(carte);
		}*/
		Collections.shuffle(tasDeCartes);
	}
	
	public void recupererCarte(Carte c) {
		tasDeCartes.add(c);
	}
	
	
	public boolean estVide() {
		return tasDeCartes.isEmpty();
	}
	
	public String toString() {
		return tasDeCartes.toString();
	}
	
	public Carte tirerCarteDuDessus() {
		return tasDeCartes.poll();//pop to poll
	}
}

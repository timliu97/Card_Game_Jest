package Jest;

import java.util.ArrayList;
import java.util.Iterator;

public class ScoreCalculatorVisitor implements ScoreVisitor {
	private Joueur joueur;
	private Carte carte;
	
	public void visit(Joueur joueur) {
		System.out.println("I'm visiting "+joueur);
	}
	public void visit(Utilisateur utilisateur) {
		System.out.println("I'm visiting "+utilisateur);
	}
	public void visit(Bot bot) {
		System.out.println("I'm visiting "+bot);
	}

	
	public int calculScore(Joueur joueur) {//Visitor qui effectue le calcul du Score
		int jestValue = 0;
		Iterator<Carte> itDeJest = joueur.Jest.iterator();
		ArrayList<Couleur> valeursJest = new ArrayList<Couleur>();
		Iterator<Couleur> itDeCoeur = valeursJest.iterator();
		int nombreDeCoeur = 0;
		int nombreDeCarreau = 0;
		int nombreDePique = 0;
		int nombreDeTrefle = 0;

		while (itDeJest.hasNext()) {
			valeursJest.add(itDeJest.next().couleurCarte);
		}
		while (itDeCoeur.hasNext()) {
			if(itDeJest.next().getCouleur() == Couleur.Coeur) {
				nombreDeCoeur ++;
			}
			if(itDeJest.next().getCouleur() == Couleur.Trefle) {
				nombreDeTrefle ++;
			}
			if(itDeJest.next().getCouleur() == Couleur.Pique) {
				nombreDePique ++;
			}
			if(itDeJest.next().getCouleur() == Couleur.Carreau) {
				nombreDeCarreau ++;
			}
		}
		while (itDeJest.hasNext()){
			if(itDeJest.next().getCouleur() == Couleur.Trefle) {
				if(itDeJest.next().getValeur()==carte.getValeur()) {//est-ce qu'elle va itérer sur carte1 encore et trouver que 2 se ressemblent ? 
					jestValue += 2;
					jestValue += itDeJest.next().ValeurtoInt();
					
				}
				else {
					jestValue += itDeJest.next().ValeurtoInt();
				}
			}
			if(itDeJest.next().getCouleur() == Couleur.Pique) {
				if(itDeJest.next().getValeur()==carte.getValeur()) {
					jestValue += 2;
					jestValue += itDeJest.next().ValeurtoInt();
				}
				else {
					jestValue += itDeJest.next().ValeurtoInt();
				}
			}
			if(itDeJest.next().getCouleur() == Couleur.Carreau) {
				jestValue -= itDeJest.next().ValeurtoInt();
			}
			if(itDeJest.next().getValeur() == Valeur.AceOuCinq) {//Is the one under still the same card ?
				if(itDeJest.next().getCouleur() == Couleur.Carreau & nombreDeCarreau == 1) {//1 parce qu'on compte l'Ace
					jestValue += 5;
				} 
				else if(itDeJest.next().getCouleur() == Couleur.Pique & nombreDePique == 1) {
					jestValue += 5;
				} 
				else if(itDeJest.next().getCouleur() == Couleur.Trefle & nombreDeTrefle == 1) {
					jestValue += 5;
				}
				else if(itDeJest.next().getCouleur() == Couleur.Coeur & nombreDeCoeur == 1) {
					jestValue += 5;
				}	
			}
			if(nombreDeCoeur == 0) {
				if(itDeJest.next().getValeur() == Valeur.Joker) {
					jestValue += 4;
				}
			}
			else {
				if(itDeJest.next().getValeur() == Valeur.Joker) {
					jestValue += 0;
				}
				if(nombreDeCoeur <= 3) {
					if(itDeJest.next().getCouleur() == Couleur.Coeur) {
						jestValue -= itDeJest.next().ValeurtoInt();
					}
				}
				if(nombreDeCoeur == 4) {
					if(itDeJest.next().getCouleur() == Couleur.Coeur) {
						jestValue += itDeJest.next().ValeurtoInt();
					}
				}
			}
		}
		return jestValue;
	}

}

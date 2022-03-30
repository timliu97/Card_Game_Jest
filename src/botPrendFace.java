package Jest;

import java.util.ArrayList;
import java.util.Iterator;

public class botPrendFace implements Strategy{
	private ArrayList<Joueur> joueurs;
	private Bot bot;
	
	@Override
	public void prendreOffre() {
		ArrayList<Joueur> choixPossible = new ArrayList<Joueur>();
		Iterator<Joueur> itDeJoueur = joueurs.iterator();
		while (itDeJoueur.hasNext()) {
			if (itDeJoueur.next().main.size()==2) {
				choixPossible.add(itDeJoueur.next());
			}//vérifie qu'on peut toujours prendre chez ce joueur
		}
		if(choixPossible.size()!=0) {
			int x = (int)(Math.random()*((choixPossible.size()-0)+1));
			Joueur J = choixPossible.get(x);//random de l'arraylist 
			bot.main.add(J.Offre);//le bot prend toujours la carte dos
		}else bot.prendreMonOffre();
		
	}

}

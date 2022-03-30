package Jest;

import java.util.ArrayList;
import java.util.Iterator;

public class botPrendFace implements Strategy{
	private ArrayList<Joueur> joueurs;
	private Bot bot;

	
	@Override
	public void prendreOffre(ArrayList<Joueur> choixPossible) {
			int x = (int)(Math.random()*((choixPossible.size()-0)+1));
			Joueur J = choixPossible.get(x);//random de l'arraylist 
			bot.Jest.add(J.Offre);//le bot prend toujours la carte dos
	}

}

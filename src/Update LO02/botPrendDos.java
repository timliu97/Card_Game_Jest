package Jest;

import java.util.ArrayList;
import java.util.Iterator;

public class botPrendDos implements Strategy{
	private ArrayList<Joueur> joueurs;
	private Bot bot;
	
	
	
	
	@Override
	public void prendreOffre(ArrayList<Joueur> choixPossible) {
			String nextPlayerName;
			int x = (int)(Math.random()*((choixPossible.size()-0)+1));
			System.out.println("dis the size of choixPossible :"+choixPossible.size());
			Joueur next = choixPossible.get(x);//random de l'arraylist 
			System.out.println(next.nom);
			System.out.println(next.pasOffre);
			//bot.Jest.add(next.pasOffre);//le bot prend toujours la carte dos
			/*nextPlayerName = next.nom;
			System.out.println(nextPlayerName);*/
	}
}
//Je ne sais pas comment faire pour que le bot rajoute dans son jest la carte next.pasOffre.
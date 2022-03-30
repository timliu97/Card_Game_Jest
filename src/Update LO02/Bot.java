package Jest;
import java.util.*;

public class Bot extends Joueur implements Strategy, Score{
	private ArrayList<Joueur> joueurs;
	private Strategy prendreOffreStrategy;
	
	public Bot(String nom, int strategy) {
		super(nom);
		if(strategy == 1) {
			this.prendreOffreStrategy = new botPrendDos();
		}
		else if(strategy == 2) {
			this.prendreOffreStrategy = new botPrendFace();
		}
	}
	
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	public void setPrendreOffreStrategy(Strategy prendreOffreStrategy){
		this.prendreOffreStrategy = prendreOffreStrategy;
	}
	
	public void prendreOffre(ArrayList<Joueur> choixPossible) {
		prendreOffreStrategy.prendreOffre(choixPossible);
	}
	
	public Carte faireOffre() {
		this.Offre = main.get(0);
		//System.out.println("Offre de "+this.nom+" : "+this.Offre);
		//main.remove(0);bc it helps check si on peut piocher chez lui
		this.pasOffre = main.get(1);
		//main.remove(1);
		return this.Offre;
	}
	public void prendreMonOffre() {
		Jest.add(this.Offre);
	}

	@Override
	public void accept(ScoreVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
		
	}
	

}

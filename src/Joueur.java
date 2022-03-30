package Jest;
import java.util.*;


public class Joueur implements Score{
	protected LinkedList<Carte> main;
	protected LinkedList<Carte> Jest;
	protected ArrayList<Joueur> joueurs;
	protected Carte Offre;
	protected Carte pasOffre;
	protected String nom;
	protected int score;
	protected boolean isWinner= false;
	
	
	public Joueur(String nom) {
		this.nom=nom;
		main= new LinkedList<Carte>();
		Iterator<Carte> itMain = main.iterator();
		Jest = new LinkedList<Carte>();
		Iterator<Carte> itJest = Jest.iterator();
	}
	public ArrayList<Joueur> getJoueurs(){
		return joueurs;
	}
	public void prendreOffre() {
		
	}
	public void ramasserCarte(Carte carte) {
		main.add(carte);
	}
	
	public Carte faireOffre() {
		return this.Offre;
	}
	
	public void prendreMonOffre() {	
	}
	
	public void mettreDansJest() {
		Iterator<Carte> it = main.iterator();
		while (it.hasNext()) {
			Jest.add(it.next());
			main.remove(it.next());
		this.Offre = null;//trial for removal offre
		this.pasOffre = null;
		}
	}
	public boolean aGagne() {
		return this.isWinner;
	}
	@Override
	public void accept(ScoreVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
	
	//Method under most probably goes to ScoreCalculatorVisitor
	
}
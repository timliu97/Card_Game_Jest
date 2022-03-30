package Jest;
import java.util.*;
import java.util.Map.Entry;

public class Utilisateur extends Joueur implements Score {
		//private ArrayList<Joueur> joueurs;
		
		
		
		public Utilisateur(String nom) {
			super(nom);
		}
		
		public void prendreOffre(ArrayList<Joueur> choixPossible) {
			//Vérification des disponibilités des cartes
			//ArrayList<Joueur> choixPossible = new ArrayList<Joueur>();
			/*Iterator<Joueur> itDeJoueur = joueurs.iterator();
			while (itDeJoueur.hasNext()) {
				if (itDeJoueur.next().main.size()==2) {
					choixPossible.add(itDeJoueur.next());
				}
			}*/
			
			
			Scanner sc = new Scanner(System.in);
			//System.out.println("Tapez un chiffre entre 1 et "+a);
			int i = sc.nextInt() ;
			Joueur joueur = choixPossible.get(i);
			System.out.println("Choississez la carte face(true) ou dos(false)");
			boolean choix = sc.nextBoolean();
			while (choix != true && choix != false) {
			if (choix == true) {
				main.add(joueur.Offre);
			} else if (choix == false){ 
				main.add(joueur.pasOffre);
			}
			}
			
		}
		public Carte faireOffre() {
			System.out.println(this.nom+" va faire une offre...");
			Iterator<Carte> it = this.main.iterator();
			while (it.hasNext()) {
				Carte c=(Carte)it.next();
				System.out.println(c.toString());
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("Pick a card, true = 1  or false = 2");
			boolean i = sc.nextBoolean();
			if(i==true) {
				this.Offre = main.get(0);
				this.pasOffre = main.get(1);
			}else if (i==false){
				this.Offre = main.get(1);
				this.pasOffre = main.get(0);
			}
				//this.Offre = main.get(i);
				//main.remove(i);//on enleve les offres de la main
				//this.pasOffre = main.get(0);
				//main.remove(this.pasOffre);
				//System.out.println("Offre de "+this.nom+" : "+this.Offre);
				//enlever offre tour precedent 
			
			return this.Offre;
		}
			
		public void prendreMonOffre() {
			System.out.println("Choississez la carte face (true) ou dos (false)");
			Scanner sc = new Scanner(System.in);
			 boolean choix = sc.nextBoolean();
			while (choix != true & choix != false) {
				if (choix == true) {
					Jest.add(this.Offre);
				} else if (choix == false){ 
					Jest.add(this.pasOffre);
				}
			}
		}
		
		public void mettreDansJest() {
			
		}
		
		
		public LinkedList<Carte> getMain() {
			return main;
		}

		public void setMain(LinkedList<Carte> main) {
			this.main = main;
		}

		/*public ArrayList<Joueur> getJoueurs() {
			return joueurs;
		}

		public void setJoueurs(ArrayList<Joueur> joueurs) {
			this.joueurs = joueurs;
		}*/

		@Override
		public void accept(ScoreVisitor visitor) {
			// TODO Auto-generated method stub
			visitor.visit(this);
		}
		
		public static void main(String[]args) {
			/*Partie partie = new Partie();
			ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
			Utilisateur utilisateur = new Utilisateur("Fabrice");
			Utilisateur utilisateur1 = new Utilisateur("Harena");
			Utilisateur utilisateur2 = new Utilisateur("Cynthia");
			joueurs.add(utilisateur);
			joueurs.add(utilisateur1);
			joueurs.add(utilisateur2);
			utilisateur.prendreOffre();*/
			
		}
		

}

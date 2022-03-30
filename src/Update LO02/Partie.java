package Jest;
import java.util.*;
import java.util.Map.Entry;
import com.sun.tools.javac.code.Attribute.Array;

import sun.tools.tree.ThisExpression;

public class Partie {
	public int nbBot;
	public int nbJoueur;
	public static int nbTourTotal;
	public int numTour=1;
	private Joueur gagnantDePartie;
	protected ArrayList<Joueur> joueurs;
	private ArrayList<Utilisateur> utilisateurs;
	private ArrayList<Bot> bots;
	private Paquet cartes;//
	private Plateau trophee;
	private ArrayList<Carte> trophees;
	private boolean partieEnCours;
	int nbTrophee=-(nbBot+nbJoueur)+5;
	private Bot Bot;//To review
	private Joueur Gagnant;
	private ArrayList<Carte> Trophee;
	
	public Partie() {
		//boolean nbFasable=false;
		trophees=new ArrayList<Carte>();
		joueurs=new ArrayList<Joueur>();
		bots=new ArrayList<Bot>();
		utilisateurs=new ArrayList<Utilisateur>();
		cartes=new Paquet();
		trophee=new Plateau(nbTrophee);
		//cartes.melanger();
		/*while(nbFasable=false) {
		System.out.println("Combien de joueur virtuel vous voulez ajouter?");
		Scanner bot=new Scanner(System.in);
		this.nbBot=bot.nextInt();
		
		//Essaie Strategy
		System.out.println("Quelle stratgie voulez vous pour les joueurs virtuels? 1 ou 2");
		Scanner scStrategy = new Scanner(System.in);
		Iterator<Bot> itDeBot = bots.iterator();
		int choixStrategy = scStrategy.nextInt();
		if (choixStrategy == 1) {
			while(itDeBot.hasNext()) {
			itDeBot.next().setPrendreOffreStrategy(new botPrendFace());
			}
		}else if (choixStrategy == 2) {
			while(itDeBot.hasNext()) {
			itDeBot.next().setPrendreOffreStrategy(new botPrendDos());
			}
		}
		
			//Fin tentative

		System.out.println("Combien de joueur rÃˆel vous voulez ajouter?");
		Scanner reel=new Scanner(System.in);
		this.nbJoueur=reel.nextInt();
		if(nbBot+nbJoueur==3) {
			Partie.nbTourTotal=5;
			nbFasable=true;
		}
		if(nbBot+nbJoueur==4) {
			Partie.nbTourTotal=4;
			nbFasable=true;
		}else {
			System.out.println("Le nombre de joueur maximal est 4, veuillez vous retaper");
		}
		}
		for(int i=1;i<=nbJoueur;i++) {
			System.out.println("Entrez le nom de n."+i+"joueur");
			Scanner nom=new Scanner(System.in);
			String name=nom.nextLine();
			Utilisateur joueur=new Utilisateur(name);
			joueurs.add(joueur);
			utilisateurs.add(joueur);
		}
		for(int j=1;j<=nbBot;j++) {
			System.out.println("Entrez le nom de n."+j+"Bot");
			Scanner nomB=new Scanner(System.in);
			String name=nomB.nextLine();
			Bot bot=new Bot(name);
			joueurs.add(bot);
			bots.add(bot);
		}*/
		System.out.println("La partie demarre!");
		//this.initialisationJoueur();
		//this.attributionTrophee();
		partieEnCours=false;
	}
	/*
	//ajouter un joueur
	public void ajouterJoueur(Joueur j) {
		if(partieEnCours=false) {
			joueurs.add(j);
		}
	}
	*/
	
	
	public void initialisationJoueur() {
		System.out.println("On initialise les joueurs");
		boolean nbFasable=false;
		while(nbFasable==false) {
			System.out.println("Combien de joueur virtuel vous voulez ajouter?");
			Scanner bot=new Scanner(System.in);
			this.nbBot=bot.nextInt();
			
			//Essaie Strategy
			/*System.out.println("Quelle strategie voulez vous pour les joueurs virtuels? 1 ou 2");
			Scanner scStrategy = new Scanner(System.in);
			Iterator<Bot> itDeBot = bots.iterator();
			int choixStrategy = scStrategy.nextInt();
			if (choixStrategy == 1) {
				while(itDeBot.hasNext()) {
				itDeBot.next().setPrendreOffreStrategy(new botPrendFace());
				}
			}else if (choixStrategy == 2) {
				while(itDeBot.hasNext()) {
				itDeBot.next().setPrendreOffreStrategy(new botPrendDos());
				}
			}*/
			
				//Fin tentative

			System.out.println("Combien de joueur reel vous voulez ajouter?");
			Scanner reel=new Scanner(System.in);
			this.nbJoueur=reel.nextInt();
			if(nbBot+nbJoueur==3) {
				Partie.nbTourTotal=5;
				nbFasable=true;
			}
			if(nbBot+nbJoueur==4) {
				Partie.nbTourTotal=4;
				nbFasable=true;
			}else {
				System.out.println("Le nombre de joueur maximal est 4, veuillez vous retaper");
			}
			}
			for(int i=1;i<=nbJoueur;i++) {
				System.out.println("Entrez le nom de n."+i+"joueur");
				Scanner nom=new Scanner(System.in);
				String name=nom.nextLine();
				Utilisateur utilisateur=new Utilisateur(name);
				joueurs.add(utilisateur);
				utilisateurs.add(utilisateur);
			}
			for(int j=1;j<=nbBot;j++) {
				System.out.println("Entrez le nom de n."+j+"Bot");
				Scanner nomB=new Scanner(System.in);
				String name=nomB.nextLine();
				System.out.println("Quelle strategie voulez vous pour les joueurs virtuels? 1 ou 2");
				int strategie = nomB.nextInt();
				Bot bot=new Bot(name, strategie);
				joueurs.add(bot);
				bots.add(bot);
			}
	}
	
	
	//Supprimier un joueur dans la liste des joueurs
	public void retirerJoueur(Joueur j) {
		if(partieEnCours=false) {
			joueurs.remove(j);
	}
	}
	
	//Chaque joueur prend deux cartes dans paquet et les ajoute dans leurs main
	public void distribuerCartes() {
		this.cartes.melanger();
		this.partieEnCours=true;
		if(this.cartes.estVide()==false) {
			Iterator<Joueur> it=joueurs.iterator();
			while(it.hasNext()) {
					Carte carte = this.cartes.tirerCarteDuDessus();
					it.next().ramasserCarte(carte);
			}
		}
	}
		public void UtilisateurFaireOffre() {
			Iterator<Utilisateur> u=utilisateurs.iterator();
			while(u.hasNext()) {
				Utilisateur util=(Utilisateur)u.next();
				util.faireOffre();
			}
			
		}
		public void BotFaireOffre() {
			Iterator<Bot> b=bots.iterator();
			while(b.hasNext()) {
				Bot bot=(Bot)b.next();
				bot.faireOffre();
			}
			
		}
		
		public void jouer() {
			initialisationJoueur();
			attributionTrophee();
			
		}
		
		public void Tour() {
			String nextPlayername = null;
			ArrayList<Joueur> choixPossible = new ArrayList<Joueur>();
			System.out.println("On distribue les cartes aux joueurs");
			distribuerCartes();
			distribuerCartes();
			UtilisateurFaireOffre();
			BotFaireOffre();
			afficherOffre();
			nextPlayername = this.choisirOffre(joueurGagnant(carteGagnante()),choixPossible);
			System.out.println("C'est à "+nextPlayername+" de jouer");
			Iterator<Joueur> itDeJ = joueurs.iterator();
			while(choixPossible.size()!=0) {
				if(choixPossible.size()!=1) {
					while(itDeJ.hasNext()) {
						Joueur j=(Joueur)itDeJ.next();
						if(j.nom==nextPlayername) {
							System.out.println("hello");//permet de verifier	
							choixPossible.remove(j);
							nextPlayername=ChoisirOffre(j,choixPossible);
						}
					}
				}
				else if(choixPossible.size()==1) {
					while(itDeJ.hasNext()) {
						Joueur j=(Joueur)itDeJ.next();
						if(j.nom==nextPlayername) {
							System.out.println("hello");//permet de verifier	
							choixPossible.remove(j);
							j.prendreMonOffre();
						}
					}	
				}
			}
			recupererOffreNonChoisi();
		}
		
		
		
		
	
	//mettre toutes les cartes des mains des joueurs dans paquet; si c'est le dernier tour, on les met dans leurs Jest
	public void recupererOffreNonChoisi() {
		if(numTour<nbTourTotal) {
			Iterator<Joueur> ij=joueurs.iterator();
			while(ij.hasNext()) {
				Joueur joueur=ij.next();
				Iterator<Carte> c=joueur.main.iterator();
				while(c.hasNext()) {
					Carte carte=c.next();
					cartes.recupererCarte(carte);
				}
			}
		}
		if(numTour==nbTourTotal) {
			Iterator<Joueur> j=joueurs.iterator();
			while(j.hasNext()) {
				Joueur joueur=j.next();
				Iterator<Carte> c=joueur.main.iterator();
				while(c.hasNext()) {
					Carte carte=c.next();
					joueur.Jest.add(carte);
				}
			}
		}
	}
	
	//afficher dse offres des joueurs
	public void afficherOffre() {
		Iterator<Joueur> joueur=joueurs.iterator();
		while(joueur.hasNext()) {
			Joueur j=(Joueur)joueur.next();
			Carte o=(Carte)j.Offre;
			System.out.println("L'offre de joueur "+j.nom+" est "+o.chiffreCarte+" de "+o.couleurCarte+"\t");
		}
	}
	
	//determiner l'offre qui a une valeur plus grande
	private Carte carteGagnante() {
		System.out.println("                     ");
		Carte PlusGrandeCarte=null;
		Iterator<Joueur> itDeJoueur=joueurs.iterator();
		ArrayList<Carte> Offres = new ArrayList();
		while(itDeJoueur.hasNext()) {
			Offres.add(itDeJoueur.next().Offre);
		}
		Iterator<Joueur> ij=joueurs.iterator();
		while(ij.hasNext()) {
			Joueur joueur=ij.next();
			Iterator<Carte> it=Offres.iterator();
			while(it.hasNext()) {
				Carte c=(Carte)it.next();
				if(PlusGrandeCarte==null) {
					PlusGrandeCarte=c;
				}else {
					if(c.getValeur().ordinal()>PlusGrandeCarte.getValeur().ordinal()) {
						PlusGrandeCarte=c;
					}
				//si leurs valeusr sont parailes, on compare leurs couleurs
					if(c.getValeur().ordinal()==PlusGrandeCarte.getValeur().ordinal()) {
						if(c.getCouleur().ordinal()<PlusGrandeCarte.getCouleur().ordinal()) {
						PlusGrandeCarte=c;
						}
					}
				}	
			
			}
		}
		System.out.println("L'offre la plus forte est :"+PlusGrandeCarte);
		return PlusGrandeCarte;
	}

	//determiner le plus grand offre appartient a qui
	public Joueur joueurGagnant(Carte c) {//private->public
		Iterator<Joueur> j=joueurs.iterator();
		Iterator<Joueur> itDeJ=joueurs.iterator();
		ArrayList<Carte> Offres = new ArrayList();
		boolean trouveGagnant=false;
		Joueur gagnant=null;
		while(itDeJ.hasNext()) {
			Offres.add(itDeJ.next().Offre);
		}
		while(j.hasNext()&&trouveGagnant==false) {
			gagnant=(Joueur)j.next();
			if(c.equals(gagnant.Offre)) {
				trouveGagnant=true;
			}
		}
		System.out.println("Le joueur "+gagnant.nom+" est le premier à jouer");
		return gagnant;
	}
	
	//deuxième méthode
	public String ChoisirOffre(Joueur nextPlayer, ArrayList<Joueur> choixPossible) {
		int a = choixPossible.size();
		String nextPlayername = null;
		System.out.println(a);
		
		if (nextPlayer instanceof Utilisateur) {
			System.out.println("                 ");
			System.out.println("C'est à "+nextPlayer.nom+" de jouer");
			System.out.println("Chez quel joueur ? ");
			Scanner sc = new Scanner(System.in);
			int b = a-1;//starts at zero
			System.out.println("Tapez un chiffre entre 0 et "+b);
			Joueur joueur = choixPossible.get(sc.nextInt());
			nextPlayername = joueur.nom;
			System.out.println(joueur.nom);
			System.out.println("Choississez la carte face = true ou dos = false");
			boolean choix = sc.nextBoolean();
			
			
			if (choix == true) {
				Iterator<Joueur> itDeJ = joueurs.iterator();
				while(itDeJ.hasNext()) {
					Joueur j=(Joueur)itDeJ.next();
					if(j.nom==joueur.nom) {
						System.out.println(joueur.nom);//permet de verifier
						nextPlayer.Jest.add(joueur.Offre);
						joueur.Offre=null;
						System.out.println(nextPlayer.Jest);	
					}
				}
			}
			
			else if(choix==false) {
				Iterator<Joueur> itDeJ = joueurs.iterator();
				while(itDeJ.hasNext()) {
					Joueur j=(Joueur)itDeJ.next();
					if(j.nom==joueur.nom) {
						System.out.println(joueur.nom);//permet de verifier
						nextPlayer.Jest.add(joueur.pasOffre);
						joueur.pasOffre=null;
						System.out.println(nextPlayer.Jest);	
					}
				}
			}
		}
		
		else if (nextPlayer instanceof Bot) {
			System.out.println("Construction en cours...");
			((Bot) nextPlayer).prendreOffre(choixPossible);
			//Il faut pouvoir retourner nextPlayername
		}
		
		return nextPlayername;
		
	}

	
	public String choisirOffre(Joueur joueurGagnant, ArrayList<Joueur> choixPossible) {
		//Vérification des disponibilités des cartes
		System.out.println("                 ");
		/*Iterator<Joueur> itDeJoueur = joueurs.iterator();
		ArrayList<Joueur> choixPossible = new ArrayList<Joueur>();
		Iterator<Joueur> itDeChoix = choixPossible.iterator();
		Joueur c = null;
		c=(Joueur)itDeJoueur.next();
		while (itDeJoueur.hasNext()&&itDeJoueur.next().main.size()==2){
			choixPossible.add(c);
		} 
		System.out.println("                  ");
		System.out.println(choixPossible.size());*/
		
		Iterator<Joueur> itDeJoueur = joueurs.iterator();
		String nextPlayer = null;
		
		Joueur c = null;
		while (itDeJoueur.hasNext()){
			c=(Joueur)itDeJoueur.next();
			if (c.main.size()==2){
				choixPossible.add(c);
				System.out.println(c.nom);
				
		         }
		}
		int a = choixPossible.size();
		System.out.println(a);
		
		if (joueurGagnant instanceof Utilisateur) {
			System.out.println("                 ");
			System.out.println("C'est à "+joueurGagnant.nom+" de jouer");
			System.out.println("Chez quel joueur ? ");
			Scanner sc = new Scanner(System.in);
			int b = a-1;//starts at zero
			System.out.println("Tapez un chiffre entre 0 et "+b);
			Joueur joueur = choixPossible.get(sc.nextInt());
			nextPlayer = joueur.nom;
			System.out.println(joueur.nom);
			System.out.println("Choississez la carte face = true ou dos = false");
			boolean choix = sc.nextBoolean();
			
			
			if (choix == true) {
				Iterator<Joueur> itDeJ = joueurs.iterator();
				while(itDeJ.hasNext()) {
					Joueur j=(Joueur)itDeJ.next();
					if(j.nom==joueur.nom) {
						System.out.println(joueur.nom);//permet de verifier
						joueurGagnant.Jest.add(joueur.Offre);
						joueur.Offre=null;
						System.out.println(joueurGagnant.Jest);	
					}
				}
			}
			
			else if(choix==false) {
				Iterator<Joueur> itDeJ = joueurs.iterator();
				while(itDeJ.hasNext()) {
					Joueur j=(Joueur)itDeJ.next();
					if(j.nom==joueur.nom) {
						System.out.println(joueur.nom);//permet de verifier
						joueurGagnant.Jest.add(joueur.pasOffre);
						joueur.pasOffre=null;
						System.out.println(joueurGagnant.Jest);	
					}
				}
			}
		}
		
		else if (joueurGagnant instanceof Bot) {
			System.out.println("Construction en cours...");
			((Bot) joueurGagnant).prendreOffre();
			System.out.println(joueurGagnant.Jest);
			//Il faut retourner nextPlayer
		}
		
		return nextPlayer;
		
	
	}
	
	

	//Demander des joueurs quel offre il veut prendre, erreur si il tape son propre offre. Pour le dernier joueur, il risque de prendre son propre offre
	public void choisirOffre(Joueur joueurGagnant,int nbJoueur) {
			boolean faisable=false;
			if(nbJoueur>0) {
			String nom = null;
			while(faisable==false) {
			System.out.println(joueurGagnant.nom+": Tapez le nom du joueur duquel tu veux prendre la carte");
			Scanner scan = new Scanner(System.in);
			if (scan.hasNextLine()) {
	            nom = scan.nextLine();
	            }
			System.out.println("Si vous voulez prendre la carte en face, tapez 1; Sinon tapez 2");
			
			Scanner scan1 = new Scanner(System.in);
			int carte=0;
			if (scan1.hasNextLine()) {
	            carte = scan1.nextInt();
	            }
			
		//trouver le joueur
				Iterator<Joueur> itj=joueurs.iterator();
				while(itj.hasNext()) {
					Joueur j=(Joueur)itj.next();
					if(j.nom==nom) {
						//verifier la condition
						if(j.Offre!=null&&j.pasOffre!=null) {
							if(carte==1) {
							joueurGagnant.Jest.add(j.Offre);
							j.Offre=null;
							}
							if(carte==2) {
								joueurGagnant.Jest.add(j.pasOffre);
								j.pasOffre=null;
							}
							nbJoueur-=1;
							if(j instanceof Utilisateur) {//Here !! 
							choisirOffre(j, nbJoueur);
							}
							if(j instanceof Bot) {
								//*************************************************************************
								//Bot choisit offre
								//*************************************************************************
							}
						}
						else {
							System.out.println("Ce joueur n'est pas disponible");
						}
					}
				}
			}
		}
			//pour le dernier joueur
			if(nbJoueur==0) {
				//prendre une carte dans sa main
				if (joueurGagnant.Offre!=null&&joueurGagnant.pasOffre!=null) {
					System.out.println("Vous devez choisir une carte dans votre main et la ajouter dans le Jest");
					System.out.println("Si vous voulez prendre la carte en face, tapez 1; Sinon tapez 2");
					
					Scanner scan1 = new Scanner(System.in);
					int carte=0;
					if (scan1.hasNextLine()) {
			            carte = scan1.nextInt();
			        }
					if(carte==1) {
						joueurGagnant.Jest.add(joueurGagnant.Offre);
						joueurGagnant.Offre=null;
					}
					if(carte==2) {
						joueurGagnant.Jest.add(joueurGagnant.pasOffre);
						joueurGagnant.pasOffre=null;
					}
				}
				//prendre une carte d'autre
				else {
					boolean faisable1=false;
				while(faisable1==false){
					afficherOffre();
					String nom=null;
					System.out.println(joueurGagnant.nom+": Tapez le nom du joueur duquel tu veux prendre la carte");
					Scanner scan = new Scanner(System.in);
					if (scan.hasNextLine()) {
			            nom = scan.nextLine();
			            }
					System.out.println("Si vous voulez prendre la carte en face, tapez 1; Sinon tapez 2");
					
					Scanner scan1 = new Scanner(System.in);
					int carte=0;
					if (scan1.hasNextLine()) {
			            carte = scan1.nextInt();
			            }
					
				//trouver le joueur
						Iterator<Joueur> itj=joueurs.iterator();
						while(itj.hasNext()) {
							Joueur j=(Joueur)itj.next();
							if(j.nom==nom) {
								//verifier la condition
								if(j.Offre!=null&&j.pasOffre!=null) {
									if(carte==1) {
									joueurGagnant.Jest.add(j.Offre);
									j.Offre=null;
									}
									if(carte==2) {
										joueurGagnant.Jest.add(j.pasOffre);
										j.pasOffre=null;
									}
									faisable=true;
									nbJoueur-=1;
								}else {
									System.out.println("Ce joueur n'est pas disponible");
								}
							}
				}
						}
				}
			}
	}
	/*public HashMap<Carte,Joueur> OrdreJoueur() {
		
		HashMap<Carte,Joueur> ordre=new HashMap<Carte,Joueur>();
		Carte ValuePlusGrand=null;
		Iterator<Joueur> o=joueurs.iterator();
		while(o.hasNext()) {
			Joueur j=(Joueur)o.next();
			Carte offre=(Carte)j.main.peek();
			if(ValuePlusGrand==null||offre.getValeur().ordinal()<ValuePlusGrand.getValeur().ordinal()) {
				OrdreJoueur().add(j);
			}else {
				if(offre.getValeur().ordinal()>ValuePlusGrand.getValeur().ordinal()) {
					OrdreJoueur().addFirst(j);
				}
			}
		}
		return ordre;
	}
	*/
	
	//Verifier des conditions des Trophees, et puis distribuer aux joueurs
	public void distribuerTrophee() {
		TypeTotemes type=null;
		Couleur couleur=null;
		Valeur valeur=null;
		Iterator<Carte> t=trophees.iterator();
		while(t.hasNext()) {
			Carte tro=(Carte)t.next();
			type=tro.getTypeTotem();
			couleur=tro.getCouleur();
			valeur=tro.getValeurTotem();
			switch (type) {
			case BEST_JEST_SANS_JOKER:
				int best_score=0;
				Joueur best_joueur=null;
				Joueur joker=null;
				Iterator<Joueur> j0=joueurs.iterator();
				while(j0.hasNext()) {
					Joueur joueur=(Joueur)j0.next();
					Iterator<Carte> c=joueur.Jest.iterator();
					while(c.hasNext()) {
						Carte carte=(Carte)c.next();
						if(carte.getValeur()==valeur.Joker) {
							joker=joueur;
						}
						}
					}
				Iterator<Joueur> j=joueurs.iterator();
				while(j.hasNext()) {
					int score=0;
					ScoreCalculatorVisitor calcul = new ScoreCalculatorVisitor();
					Joueur joueur=(Joueur)j.next();
					score = calcul.calculScore(joueur);
						if(best_score==0&&joueur!=joker) {
							best_score=score;
							best_joueur=joueur;
						}else {
							if(score>best_score&&joueur!=joker) {
								best_score=score;
								best_joueur=joueur;
							}
						}
				}
				Iterator<Joueur> jb=joueurs.iterator();
				while(jb.hasNext()) {
					Joueur jbest=(Joueur)jb.next();
					if(best_joueur==jbest) {
						jbest.Jest.add(tro);
					}
				}
				break;
			case BEST_JEST:
				int best_score1=0;
				Joueur best_joueur1=null;
				Iterator<Joueur> j1=joueurs.iterator();
				while(j1.hasNext()) {//j'ai change j -> j1
					int score=0;
					ScoreCalculatorVisitor calcul = new ScoreCalculatorVisitor();
					Joueur joueur=(Joueur)j1.next();//la meme
					score=calcul.calculScore(joueur);
						if(best_score1==0) {//j'ai change de best_score -> best_score1
							best_score=score;
							best_joueur=joueur;
						}else {
							if(score>best_score1) {//la meme
								best_score=score;
								best_joueur=joueur;
							}
						}
				}
				Iterator<Joueur> jb1=joueurs.iterator();
				while(jb1.hasNext()) {
					Joueur jbest=(Joueur)jb1.next();
					if(best_joueur1==jbest) {//j'ai change best_joueur en best_joueur1
						jbest.Jest.add(tro);
					}
				}
				break;
			case Highest:
				switch (couleur) {
				case Carreau:
					Iterator<Joueur> jh=joueurs.iterator();
					while(jh.hasNext()) {
						Joueur joueur=(Joueur)jh.next();
						Iterator<Carte> c=joueur.Jest.iterator();
						while(c.hasNext()) {
							Carte carte=(Carte)c.next();
							if(carte.getCouleur()==couleur.Carreau&&carte.getValeur()==valeur.Quatre) {
								joueur.Jest.add(tro);
							}
						}
							
					}
					break;

				case Coeur:
					Iterator<Joueur> jc=joueurs.iterator();
					while(jc.hasNext()) {
						Joueur joueur=(Joueur)jc.next();
						Iterator<Carte> c=joueur.Jest.iterator();
						while(c.hasNext()) {
							Carte carte=(Carte)c.next();
							if(carte.getCouleur()==couleur.Coeur&&carte.getValeur()==valeur.Quatre) {
								joueur.Jest.add(tro);
							}
						}
							
					}
					break;
					
				case Pique:
					Iterator<Joueur> j2=joueurs.iterator();
					while(j2.hasNext()) {//j'ai change j->j2
						Joueur joueur=(Joueur)j2.next();//la meme
						Iterator<Carte> c=joueur.Jest.iterator();
						while(c.hasNext()) {
							Carte carte=(Carte)c.next();
							if(carte.getCouleur()==couleur.Pique&&carte.getValeur()==valeur.Quatre) {
								joueur.Jest.add(tro);
							}
						}
							
					}
				break;
				
				case Trefle:
					Iterator<Joueur> j3=joueurs.iterator();//j'ai change les deux lignes suivantes de j en j3
					while(j3.hasNext()) {
						Joueur joueur=(Joueur)j3.next();
						Iterator<Carte> c=joueur.Jest.iterator();
						while(c.hasNext()) {
							Carte carte=(Carte)c.next();
							if(carte.getCouleur()==couleur.Trefle&&carte.getValeur()==valeur.Quatre) {
								joueur.Jest.add(tro);
							}
						}
							
					}
					break;
				}
				break;

			case Joker:
				Iterator<Joueur> jj=joueurs.iterator();
				while(jj.hasNext()) {
					Joueur joueur=(Joueur)jj.next();
					Iterator<Carte> c=joueur.Jest.iterator();
					while(c.hasNext()) {
						Carte carte=(Carte)c.next();
						if(carte.getValeur()==valeur.Joker) {
							joueur.Jest.add(carte);
						}
					}
					}
				break;
				
			case Lowest:
				switch (couleur) {
				case Carreau:
					Iterator<Joueur> jl=joueurs.iterator();
					while(jl.hasNext()) {
						Joueur joueur=(Joueur)jl.next();
						Iterator<Carte> c=joueur.Jest.iterator();
						while(c.hasNext()) {
							Carte carte=(Carte)c.next();
							if(carte.getCouleur()==couleur.Carreau&&carte.getValeur()==valeur.AceOuCinq) {
								joueur.Jest.add(tro);
							}
						}
							
					}
					break;

				case Coeur:
					Iterator<Joueur> jc=joueurs.iterator();
					while(jc.hasNext()) {
						Joueur joueur=(Joueur)jc.next();
						Iterator<Carte> c=joueur.Jest.iterator();
						while(c.hasNext()) {
							Carte carte=(Carte)c.next();
							if(carte.getCouleur()==couleur.Coeur&&carte.getValeur()==valeur.AceOuCinq) {
								joueur.Jest.add(tro);
							}
						}
							
					}
					break;
					
				case Pique:
					Iterator<Joueur> j2=joueurs.iterator();
					while(j2.hasNext()) {//j'ai changÃˆ j->j2
						Joueur joueur=(Joueur)j2.next();//la meme
						Iterator<Carte> c=joueur.Jest.iterator();
						while(c.hasNext()) {
							Carte carte=(Carte)c.next();
							if(carte.getCouleur()==couleur.Pique&&carte.getValeur()==valeur.AceOuCinq) {
								joueur.Jest.add(tro);
							}
						}
							
					}
				break;
				
				case Trefle:
					Iterator<Joueur> j3=joueurs.iterator();
					while(j3.hasNext()) {//j'ai change de j->j3
						Joueur joueur=(Joueur)j3.next();//j'ai change de j->j3
						Iterator<Carte> c=joueur.Jest.iterator();
						while(c.hasNext()) {
							Carte carte=(Carte)c.next();
							if(carte.getCouleur()==couleur.Trefle&&carte.getValeur()==valeur.AceOuCinq) {
								joueur.Jest.add(tro);
							}
						}
							
					}
					break;
				}
				break;
			case MostOf:
			switch (valeur) {
			case AceOuCinq:
				Joueur gagnant=null;
				Iterator<Joueur> jm=joueurs.iterator();
				while(jm.hasNext()) {
					Joueur joueur=(Joueur)jm.next();
					Iterator<Carte> c=joueur.Jest.iterator();
					while(c.hasNext()) {
						Carte carte=(Carte)c.next();
						if(carte.getCouleur()==couleur.Carreau&&carte.getValeur()==valeur.AceOuCinq) {
							joueur.Jest.add(tro);
						}
					}
						
				}
				break;

			case Deux:
				break;
				
			case Trois:
				break;
				
			case Quatre:
				break;
			}
				break;
			}
			
		}
	}
	
	//Trirer une carte comme Trophees par hazard
	/*public Carte choisirTrophee() {
		cartes.melanger();
		Carte trophee = cartes.tirerCarteDuDessus();
		//trophee=cartes.tirerCarteDuDessus();
		return trophee;
	}*/
	
	//Mettre le trophee dans Trophee
	public void attributionTrophee() {
		/*for(int i=0;i<nbTrophee;i++) {
		Carte t = choisirTrophee();
		
		//t=(Trophee)choisirTrophee();
		trophee.ajouterTrophee(t);
		trophees.add(t);
		}*/
		if(this.joueurs.size() == 3) {               
			while (this.Trophee.size() != 2) {
				this.Trophee.add(this.cartes.tirerCarteDuDessus());
			}
			System.out.println("Il y a "+Trophee.size()+" trophees qui sont "+trophees.get(0)+" et "+trophees.get(1));
		}else if (this.joueurs.size() == 4) {
				this.trophees.add(this.cartes.tirerCarteDuDessus());
				System.out.println("Il y a "+trophees.size()+" trophee qui est "+trophees.get(0));
			}
		
	}
	
	//Verifier si la partie est terminee
	public boolean estTerminee() {
		Iterator<Joueur> it=joueurs.iterator();
		boolean estTerminere=false;
		while(it.hasNext()&&estTerminere==false) {
			Joueur j=(Joueur)it.next();
			estTerminere=j.aGagne();
		}
		return estTerminere;
	}
	public boolean quiGagne() {//name should be "who won?"
		//cette methode regarde le score de chaque joueur et choisi qui a gagne
		//boolean jaigagne = false;
		HashMap<Joueur, Integer> Score = new HashMap<Joueur, Integer>();
		Iterator<Joueur> itDeJoueur = joueurs.iterator();
		while(itDeJoueur.hasNext()) {
			Score.put(itDeJoueur.next(), itDeJoueur.next().score);
		}
		int max = (Collections.max(Score.values()));
		for (Entry<Joueur, Integer> entry : Score.entrySet()) {//retourne la valeur max dans HashMap
			if (entry.getValue()==max) {//Iterate through HashMap
				Gagnant = entry.getKey();//get the key with max value
				Gagnant.isWinner=true;
			}
			else {
				Gagnant.isWinner=false;
			}
		}
		return Gagnant.isWinner;
	}

	public static void main(String[] args) {
		Partie partie=new Partie();
		partie.jouer();
		while(partie.numTour!=nbTourTotal) {
			partie.Tour();
			partie.numTour+= 1;
		}
	}	
}

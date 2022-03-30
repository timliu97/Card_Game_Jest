package Jest;

public interface ScoreVisitor {
	void visit(Joueur joueur);
	void visit(Bot bot);
	void visit(Utilisateur utilisateur);
	

}

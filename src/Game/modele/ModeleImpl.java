package Game.modele;


import Game.controleur.*;
import Game.exceptions.CasePriseException;
import Game.exceptions.OutOfTabException;
import Game.exceptions.PseudoInvalideException;

public class ModeleImpl implements Modele {
    private String joueur1;
    private String joueur2;
    private String joueurCourant;
    private Tableau tableau;
    private String gagnant = null;

    public ModeleImpl(Controleur controleur){
    }


    @Override
    public void play(int x, int y) throws OutOfTabException, CasePriseException {
        if(x < 0 || x > 2 || y < 0 || y > 2){
            throw new OutOfTabException();
        }
        tableau.ajouterPiece(x,y, (joueurCourant.equals(joueur1) ? Piece.X : Piece.O));
        joueurCourant = (joueurCourant.equals(joueur1) ? joueur2 : joueur1);
    }

    @Override
    public boolean quitter(String nextLine) {
        boolean res = nextLine.equals("Q") ? true : false;
        joueurCourant = joueurCourant.equals(joueur1) ? joueur2 : joueur1;
        return res;
    }

    @Override
    public boolean partieTerminee() {
        return tableau.partieTerminee();
    }

    @Override
    public String getGagnant() {
        Piece pieceGagnant = tableau.getGagnant();
        if(pieceGagnant == null) return null;
        else if(pieceGagnant.equals(Piece.X)) return joueur1;
        else return joueur2;
    }

    @Override
    public void rejouer() {
        tableau.init();
        joueurCourant = joueur2;
    }

    @Override
    public void creerPartie(String joueur1, String joueur2) throws PseudoInvalideException {
        if (joueur1.length() > 3 && joueur2.length() > 3 && !joueur1.equals(joueur2)) {
            this.joueur1 = joueur1;
            this.joueur2 = joueur2;
            this.joueurCourant = joueur1;
            tableau = new Tableau();
        }
        else
            throw new PseudoInvalideException();
    }

    @Override
    public Tableau getTableau() {
        return tableau;
    }
}

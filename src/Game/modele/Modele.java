package Game.modele;

import Game.exceptions.CasePriseException;
import Game.exceptions.OutOfTabException;
import Game.exceptions.PseudoInvalideException;

public interface Modele {

    void play(int x, int y) throws OutOfTabException, CasePriseException;

    boolean quitter(String s);

    boolean partieTerminee();

    String getGagnant();

    void rejouer();

    void creerPartie(String joueur1, String joueur2) throws PseudoInvalideException;

    Tableau getTableau();
}

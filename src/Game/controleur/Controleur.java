package Game.controleur;

import Game.exceptions.CasePriseException;
import Game.exceptions.OutOfTabException;
import Game.exceptions.PseudoInvalideException;
import Game.modele.Modele;
import Game.modele.ModeleImpl;
import Game.modele.Tableau;
import Game.vue.Screen;
import Game.vue.Vue;

public class Controleur {

    private Vue screen;
    private Modele modele;

    public Controleur(){
    }

    public void creerPartie(String text, String text1) throws PseudoInvalideException {
        modele.creerPartie(text, text1);
    }

    public void start() {
        screen = new Screen(this);
        modele = new ModeleImpl(this);
    }

    public void placerPiece(int x, int y) throws CasePriseException, OutOfTabException {
        modele.play(x,y);
    }

    public Tableau getTableau() {
        return modele.getTableau();
    }

    public boolean isWin() {
        return modele.partieTerminee();
    }

    public String getGagnant() {
        return modele.getGagnant();
    }

    public void rejouer() {
        modele.rejouer();
    }
}

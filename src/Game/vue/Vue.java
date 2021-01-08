package Game.vue;

import Game.controleur.Connection;
import Game.controleur.FinPartie;
import Game.controleur.Partie;

public interface Vue {

    /**
     * Permet de changer l'état du jeu
     */
    void setStep(Etat step);

    /**
     * Affiche la vue de connection
     */

    void afficherMenuConnection(Connection connection);

    /**
     *Affiche la vue de la partie
     */
    void affichePartie(Partie partie);

    /**
     *Affiche la page de fin de partie
     */

    void afficheFinDePartie(FinPartie finPartie);
}

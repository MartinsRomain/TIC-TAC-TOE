package Game.modele;

import Game.exceptions.CasePriseException;

public class Tableau {
    private Piece[][] tableau;
    private Piece gagnant;

    public Tableau(){
        tableau = new Piece[3][3];
        init();
    }

    public void init(){
        for(int x=0 ; x<3 ; x++){
            for(int y=0 ; y<3 ; y++){
                tableau[x][y] = Piece.VIDE;
            }
        }
        gagnant = null ;
    }

    public void ajouterPiece(int x, int y, Piece piece) throws CasePriseException {
        if(!tableau[x][y].equals(Piece.VIDE))
            throw new CasePriseException();
        else
            tableau[x][y] = piece;
    }

    public boolean partieTerminee() {
        byte[][][] combinaisons = {{{0,0},{0,1},{0,2}},{{1,0},{1,1},{1,2}},{{2,0},{2,1},{2,2}},{{0,0},{1,0},{2,0}},{{0,1},{1,1},{2,1}},{{0,2},{1,2},{2,2}},{{0,0},{1,1},{2,2}},{{0,2},{1,1},{2,0}}};
        for (byte[][] combinaison : combinaisons){
            if (tableau[combinaison[0][0]][combinaison[0][1]] == tableau[combinaison[1][0]][combinaison[1][1]] &&
                    tableau[combinaison[0][0]][combinaison[0][1]] == tableau[combinaison[2][0]][combinaison[2][1]] &&
                    tableau[combinaison[0][0]][combinaison[0][1]] != Piece.VIDE) {
                gagnant = tableau[combinaison[0][0]][combinaison[0][1]];
                return true;
            }
        }
        return isFull();
    }

    private boolean isFull() {
        for (Piece[] ligne : tableau){
            for(Piece piece : ligne){
                if (piece.equals(Piece.VIDE)) return false;
            }
        }
        return true;
    }

    public Piece[][] getTableau() {
        return tableau;
    }

    @Override
    public String toString() {
        String ch = "";
        for (Piece[] lignePiece : tableau){
            ch += "-------------\n| ";
            for (Piece  piece : lignePiece){
                ch += " " + piece + " |";
            }
            ch += " \n";
        }
        return ch;
    }


    public Piece getGagnant() {
        return gagnant;
    }
}

package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {

    public static final int LARGEUR_PAR_DEFAUT = 10;
    public static final int PROFONDEUR_PAR_DEFAUT = 20;

    private int largeur;
    private int profondeur;
    private Piece pieceActuelle;
    private Piece pieceSuivante;

    public Puits() {
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
    }

    public Puits(int largeur, int profondeur) {
        if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("Largeur invalide : doit être entre 5 et 15.");
        }
        if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("Profondeur invalide : doit être entre 15 et 25.");
        }
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.pieceActuelle = null;
        this.pieceSuivante = null;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public int getProfondeur() {
        return this.profondeur;
    }

    public Piece getPieceActuelle() {
        return this.pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return this.pieceSuivante;
    }

    public void setPieceSuivante(Piece piece) {
        this.pieceSuivante = piece;
    }

    public void setPieceSuivanteEtSuivante(Piece piece) {
        this.pieceActuelle = this.pieceSuivante;
        this.pieceSuivante = piece;
    }

    @Override
    public String toString() {
        return "Puits : Dimension " + this.largeur + " x " + this.profondeur;
    }
}

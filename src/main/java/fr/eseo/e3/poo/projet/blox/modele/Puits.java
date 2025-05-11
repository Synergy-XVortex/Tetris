package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

// Classe représentant un puits dans lequel les pièces tombent (comme dans Tetris)
public class Puits {

    // Constantes pour la largeur et la profondeur par défaut du puits
    public static final int LARGEUR_PAR_DEFAUT = 10;
    public static final int PROFONDEUR_PAR_DEFAUT = 20;

    // Attributs représentant la largeur, la profondeur, la pièce actuelle et la suivante
    private int largeur;
    private int profondeur;
    private Piece pieceActuelle;
    private Piece pieceSuivante;

    // Constructeur par défaut utilisant les dimensions par défaut
    public Puits() {
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
    }

    // Constructeur avec dimensions personnalisées, avec vérification des bornes
    public Puits(int largeur, int profondeur) {
        if (largeur < 5 || largeur > 15) {
            // Lève une exception si la largeur n'est pas dans les bornes autorisées
            throw new IllegalArgumentException("Largeur invalide : doit être entre 5 et 15.");
        }
        if (profondeur < 15 || profondeur > 25) {
            // Lève une exception si la profondeur n'est pas dans les bornes autorisées
            throw new IllegalArgumentException("Profondeur invalide : doit être entre 15 et 25.");
        }
        // Initialisation des attributs
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.pieceActuelle = null;
        this.pieceSuivante = null;
    }

    // Getter pour la largeur du puits
    public int getLargeur() {
        return this.largeur;
    }

    // Getter pour la profondeur du puits
    public int getProfondeur() {
        return this.profondeur;
    }

    // Getter pour la pièce actuellement en jeu
    public Piece getPieceActuelle() {
        return this.pieceActuelle;
    }

    // Getter pour la prochaine pièce à venir
    public Piece getPieceSuivante() {
        return this.pieceSuivante;
    }

    // Setter pour définir la prochaine pièce
    public void setPieceSuivante(Piece piece) {
        this.pieceSuivante = piece;
    }

    // Méthode pour faire avancer la pièce suivante comme actuelle, et définir une nouvelle suivante
    public void setPieceSuivanteEtSuivante(Piece piece) {
        this.pieceActuelle = this.pieceSuivante;
        this.pieceSuivante = piece;
    }

    // Redéfinition de toString pour afficher les dimensions du puits
    @Override
    public String toString() {
        return "Puits : Dimension " + this.largeur + " x " + this.profondeur;
    }
}

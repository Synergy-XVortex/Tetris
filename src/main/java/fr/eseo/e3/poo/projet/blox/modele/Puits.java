package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Tetromino;

public class Puits {
    // Constantes pour les dimensions par défaut
    public static final int LARGEUR_PAR_DEFAUT = 10;
    public static final int PROFONDEUR_PAR_DEFAUT = 20;

    private int largeur;
    private int profondeur;
    private Tetromino pieceCourante;
    private Tetromino pieceSuivante;

    // Constructeur avec valeurs par défaut
    public Puits() {
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
    }

    // Constructeur avec paramètres
    public Puits(int largeur, int profondeur) {
        if (largeur <= 0 || profondeur <= 0) {
            throw new IllegalArgumentException("Largeur et profondeur doivent être positives.");
        }
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.pieceCourante = null;
        this.pieceSuivante = null;
    }

    // Getters et setters
    public int getLargeur() {
        return largeur;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public Tetromino getPieceCourante() {
        return pieceCourante;
    }

    public void setPieceCourante(Tetromino pieceCourante) {
        this.pieceCourante = pieceCourante;
    }

    public Tetromino getPieceSuivante() {
        return pieceSuivante;
    }

    public void setPieceSuivante(Tetromino pieceSuivante) {
        this.pieceSuivante = pieceSuivante;
    }

    // Affichage du puits
    public void afficher() {
        System.out.println("Puits : " + largeur + "x" + profondeur);
        System.out.println("Pièce courante : " + (pieceCourante != null ? pieceCourante.getClass().getSimpleName() : "Aucune"));
        System.out.println("Pièce suivante : " + (pieceSuivante != null ? pieceSuivante.getClass().getSimpleName() : "Aucune"));
    }
}

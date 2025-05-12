package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

// Classe représentant un puits dans lequel les pièces tombent (comme dans Tetris)
public class Puits {

<<<<<<< HEAD
    /* constantes déjà existantes */
    public static final int LARGEUR_PAR_DEFAUT    = 10;
    public static final int PROFONDEUR_PAR_DEFAUT = 20;

    /* ✨ NOUVEAU : identifiants de propriété */
    public static final String MODIFICATION_PIECE_ACTUELLE = "pieceActuelle";
    public static final String MODIFICATION_PIECE_SUIVANTE = "pieceSuivante";

    /* état interne */
=======
    // Constantes pour la largeur et la profondeur par défaut du puits
    public static final int LARGEUR_PAR_DEFAUT = 10;
    public static final int PROFONDEUR_PAR_DEFAUT = 20;

    // Attributs représentant la largeur, la profondeur, la pièce actuelle et la suivante
>>>>>>> b7d2ccba6819c62cee104e367bc48b180d3cbd7b
    private int largeur;
    private int profondeur;
    private Piece pieceActuelle;
    private Piece pieceSuivante;

<<<<<<< HEAD
    /* ✨ NOUVEAU : support de notifications */
    private final PropertyChangeSupport pcs;

    /* constructeurs */
    public Puits() {
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
    }
    public Puits(int largeur, int profondeur) {
        if (largeur < 5 || largeur > 15)
            throw new IllegalArgumentException("Largeur hors-bornes (5–15)");
        if (profondeur < 15 || profondeur > 25)
            throw new IllegalArgumentException("Profondeur hors-bornes (15–25)");
        this.largeur     = largeur;
        this.profondeur  = profondeur;
=======
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
>>>>>>> b7d2ccba6819c62cee104e367bc48b180d3cbd7b
        this.pieceActuelle = null;
        this.pieceSuivante = null;
        /* ✨ initialise le support en lui passant « this » */
        this.pcs = new PropertyChangeSupport(this);
    }

<<<<<<< HEAD
    /* ----------------- accesseurs ----------------- */
    public int    getLargeur()         { return largeur; }
    public int    getProfondeur()      { return profondeur; }
    public Piece  getPieceActuelle()   { return pieceActuelle; }
    public Piece  getPieceSuivante()   { return pieceSuivante; }

    /* ----------------- mutateurs ------------------ */
    public void setLargeur(int largeur) {
        if (largeur < 5 || largeur > 15)
            throw new IllegalArgumentException("Largeur hors-bornes (5–15)");
        this.largeur = largeur;
    }
    public void setProfondeur(int profondeur) {
        if (profondeur < 15 || profondeur > 25)
            throw new IllegalArgumentException("Profondeur hors-bornes (15–25)");
        this.profondeur = profondeur;
    }

    /**
     * Définit la prochaine pièce ; fait aussitôt « tomber » l’ancienne
     * pièceSuivante (s’il y en a une) dans pieceActuelle, puis notifie.
     */
    public void setPieceSuivante(Piece nouvellePiece) {
        /* 1) on bascule la suivante en actuelle (si != null) */
        Piece ancienneActuelle  = this.pieceActuelle;
        Piece ancienneSuivante  = this.pieceSuivante;

        if (ancienneSuivante != null) {
            this.pieceActuelle = ancienneSuivante;
            /* centre la nouvelle actuelle en haut du puits */
            int centreX = this.largeur / 2;
            this.pieceActuelle.setPosition(centreX, -4);
            /* notification de la pieceActuelle */
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE,
                                   ancienneActuelle,
                                   this.pieceActuelle);
        }

        /* 2) la nouvelle pièce devient la « suivante » */
        this.pieceSuivante = nouvellePiece;
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE,
                               ancienneSuivante,
                               this.pieceSuivante);
    }

    /* -------------- gestion des listeners ---------- */
    public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }
    public void removePropertyChangeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    /* -------------- représentation texte ----------- */
=======
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
>>>>>>> b7d2ccba6819c62cee104e367bc48b180d3cbd7b
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
            "Puits : Dimension " + largeur + " x " + profondeur + "\n");
        sb.append("Piece Actuelle : ")
          .append(pieceActuelle == null ? "<aucune>" : pieceActuelle)
          .append("\nPiece Suivante : ")
          .append(pieceSuivante == null ? "<aucune>" : pieceSuivante);
        return sb.toString();
    }
}

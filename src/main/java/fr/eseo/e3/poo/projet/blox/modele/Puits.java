package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {

    // Constantes
    public static final int LARGEUR_PAR_DEFAUT = 10;
    public static final int PROFONDEUR_PAR_DEFAUT = 20;
    public static final String MODIFICATION_PIECE_ACTUELLE = "pieceActuelle";
    public static final String MODIFICATION_PIECE_SUIVANTE = "pieceSuivante";

    // Attributs
    private int largeur;
    private int profondeur;
    private Piece pieceActuelle;
    private Piece pieceSuivante;
    private Tas tas;

    private final PropertyChangeSupport pcs;

    // Constructeurs
    public Puits() {
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
    }

    public Puits(int largeur, int profondeur) {
        if (largeur < 5 || largeur > 15)
            throw new IllegalArgumentException("Largeur hors-bornes (5–15)");
        if (profondeur < 15 || profondeur > 25)
            throw new IllegalArgumentException("Profondeur hors-bornes (15–25)");

        this.largeur = largeur;
        this.profondeur = profondeur;
        this.pieceActuelle = null;
        this.pieceSuivante = null;
        this.pcs = new PropertyChangeSupport(this);
        this.tas = new Tas(this); // Initialise un tas vide par défaut
    }

    // Constructeur avec initialisation du tas
    public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
        this(largeur, profondeur);
        this.tas = new Tas(this, nbElements, nbLignes);
    }

    // Accesseurs
    public int getLargeur() {
        return largeur;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public Piece getPieceActuelle() {
        return pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return pieceSuivante;
    }

    public Tas getTas() {
        return tas;
    }

    // Mutateurs
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

    public void setTas(Tas tas) {
        this.tas = tas;
    }

    /**
     * Définit la pièce suivante. Si une pièceSuivante existe déjà,
     * elle devient la pièceActuelle centrée en haut du puits.
     */
    public void setPieceSuivante(Piece nouvellePiece) {
        Piece ancienneActuelle = this.pieceActuelle;
        Piece ancienneSuivante = this.pieceSuivante;

        if (ancienneSuivante != null) {
            this.pieceActuelle = ancienneSuivante;
            int centreX = this.largeur / 2;
            this.pieceActuelle.setPosition(centreX, 0);
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, ancienneActuelle, this.pieceActuelle);
        }

        this.pieceSuivante = nouvellePiece;
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, ancienneSuivante, this.pieceSuivante);
    }

    // Gestion des PropertyChangeListeners
    public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    // Représentation textuelle du puits
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

package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

<<<<<<< HEAD
public class VuePuit extends JPanel implements PropertyChangeListener {
=======
// Classe responsable de l'affichage graphique du puits et de la pièce en cours
public class VuePuit extends JPanel {
>>>>>>> b7d2ccba6819c62cee104e367bc48b180d3cbd7b

    // Taille par défaut d'une case (en pixels)
    public static final int TAILLE_PAR_DEFAUT = 20;

<<<<<<< HEAD
    private Puits puits;
    private int   taille;
    /* ✨ Vue de la pièce actuelle */
    private VuePiece vuePiece;

    /* ---------------- constructeurs ---------------- */
    public VuePuit(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }
    public VuePuit(Puits puits, int taille) {
        this.puits  = puits;
        this.taille = taille;
        setPreferredSize(new Dimension(
                puits.getLargeur() * taille,
                puits.getProfondeur() * taille));
        /* s’enregistre pour écouter le modèle */
        puits.addPropertyChangeListener(this);
        /* crée la première VuePiece si une pièce est déjà fixée */
        if (puits.getPieceActuelle() != null)
            setVuePiece(new VuePiece(puits.getPieceActuelle(), taille));
    }

    /* --------------- paintComponent ---------------- */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerGrille(g);
        dessinerPieceActuelle(g);
=======
    // Référence vers le modèle du puits
    private final Puits puit;
    // Taille des cases pour l'affichage
    private final int taille;

    // Constructeur utilisant la taille par défaut
    public VuePuit(Puits puit) {
        this(puit, TAILLE_PAR_DEFAUT);
    }

    // Constructeur avec taille de case personnalisée
    public VuePuit(Puits puit, int taille) {
        this.puit = puit;
        this.taille = taille;
        // Définit la taille préférée du panneau en fonction du puits et de la taille des cases
        setPreferredSize(new Dimension(puit.getLargeur() * taille, puit.getProfondeur() * taille));
    }

    // Redéfinition de la méthode paintComponent pour dessiner le composant
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerGrille(g); // Dessine la grille du puits
        dessinerPiece(g, puit.getPieceActuelle()); // Dessine la pièce actuelle
>>>>>>> b7d2ccba6819c62cee104e367bc48b180d3cbd7b
    }

    // Méthode privée pour dessiner la grille du puits
    private void dessinerGrille(Graphics g) {
<<<<<<< HEAD
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= puits.getLargeur(); i++)
            g.drawLine(i * taille, 0,
                       i * taille, puits.getProfondeur() * taille);
        for (int j = 0; j <= puits.getProfondeur(); j++)
            g.drawLine(0, j * taille,
                       puits.getLargeur() * taille, j * taille);
    }

    private void dessinerPieceActuelle(Graphics g) {
        if (vuePiece == null) return;
        /* délègue simplement le dessin à VuePiece */
        vuePiece.paintComponent(g);
    }

    /* ------------- PropertyChangeListener ---------- */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Puits.MODIFICATION_PIECE_ACTUELLE.equals(evt.getPropertyName())) {
            Piece nouvelle = (Piece) evt.getNewValue();
            setVuePiece(new VuePiece(nouvelle, taille));
            repaint();
        }
    }

    /* ------------ getters / setters utiles --------- */
    public int  getTaille()      { return taille; }
    public Puits getPuit()       { return puits; }
    public VuePiece getVuePiece(){ return vuePiece; }

    public void setTaille(int taille) {
        this.taille = taille;
        repaint();
    }

    public void setPuits(Puits nouveau) {
        if (this.puits != null)
            this.puits.removePropertyChangeListener(this);
        this.puits = nouveau;
        if (nouveau != null) {
            nouveau.addPropertyChangeListener(this);
            /* recalcule la VuePiece selon la nouvelle pièce actuelle */
            if (nouveau.getPieceActuelle() != null)
                setVuePiece(new VuePiece(nouveau.getPieceActuelle(), taille));
            repaint();
        }
    }

    /* ✨ désormais PRIVÉ : on ne modifie la vue que via propertyChange */
    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
=======
        g.setColor(Color.LIGHT_GRAY); // Couleur de la grille
        // Lignes verticales
        for (int i = 0; i <= puit.getLargeur(); i++) {
            g.drawLine(i * taille, 0, i * taille, puit.getProfondeur() * taille);
        }
        // Lignes horizontales
        for (int j = 0; j <= puit.getProfondeur(); j++) {
            g.drawLine(0, j * taille, puit.getLargeur() * taille, j * taille);
        }
    }

    // Méthode privée pour dessiner une pièce donnée dans le puits
    private void dessinerPiece(Graphics g, fr.eseo.e3.poo.projet.blox.modele.pieces.Piece piece) {
        if (piece == null) return; // Si aucune pièce, ne rien dessiner

        for (Element element : piece.getElements()) {
            // Coordonnées converties en pixels
            int x = element.getCoordonnees().getAbscisse() * taille;
            int y = element.getCoordonnees().getOrdonnee() * taille;
            // Définition de la couleur de l'élément
            g.setColor(element.getCouleur().getAwtColor());
            // Dessin d'un rectangle 3D
            g.fill3DRect(x, y, taille, taille, true);
        }
    }

    // Getter pour la taille des cases
    public int getTaille() {
        return taille;
    }

    // Getter pour le puits associé
    public Puits getPuit() {
        return puit;
>>>>>>> b7d2ccba6819c62cee104e367bc48b180d3cbd7b
    }
}

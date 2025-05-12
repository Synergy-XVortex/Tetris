package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

// Classe représentant une pièce de type "O" (carré) héritant de Tetromino
public class OTetromino extends Tetromino {

    // Constructeur : initialise la pièce avec une position et une couleur
    public OTetromino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur); // Appelle le constructeur de la classe mère
        setElements(coordonnees, couleur); // Définit les éléments de la pièce
    }

    // Initialise les éléments de la pièce de type carré
    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        elements[0] = new Element(coordonnees, couleur); // Élément de référence (coin supérieur gauche)
        elements[1] = new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee(), couleur); // Élément à droite
        elements[2] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur); // Élément en dessous
        elements[3] = new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1, couleur); // Élément en bas à droite
    }

    // Méthode permettant de faire tourner la pièce
    // Cependant, un OTetromino étant carré, il ne change pas en tournant
    @Override
    public void tourner(boolean sensHoraire) {
        // Pas de rotation nécessaire car un carré ne change pas de forme
    }

    // Retourne la couleur de la pièce
    @Override
    public Couleur getCouleur() {
        return getCouleur(); // ⚠️ Attention : appel récursif infini — probablement une erreur ici
    }
}

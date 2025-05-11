package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

// Classe représentant une pièce de type "I" (bâton) héritant de Tetromino
public class ITetromino extends Tetromino {

    // Indique si la pièce est actuellement verticale (true) ou horizontale (false)
    private boolean estVertical = true;

    // Constructeur : initialise la pièce avec une position et une couleur
    public ITetromino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur); // Appelle le constructeur de la classe mère
        setElements(coordonnees, couleur); // Définit les éléments de la pièce
    }

    // Initialise les éléments de la pièce en position verticale par défaut
    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        elements[0] = new Element(coordonnees, couleur); // Élément central
        elements[1] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1, couleur);
        elements[2] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur);
        elements[3] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 2, couleur);
    }

    // Méthode permettant de faire pivoter la pièce dans un sens donné
    @Override
    public void tourner(boolean sensHoraire) {
        Coordonnees centre = elements[0].getCoordonnees(); // Élément de référence
        int x = centre.getAbscisse();
        int y = centre.getOrdonnee();

        if (estVertical) {
            // Si actuellement vertical, la rotation la rend horizontale
            elements[1].setCoordonnees(x + 1, y);
            elements[2].setCoordonnees(x - 1, y);
            elements[3].setCoordonnees(x - 2, y);
        } else {
            // Si actuellement horizontal, la rotation la rend verticale
            elements[1].setCoordonnees(x, y + 1);
            elements[2].setCoordonnees(x, y - 1);
            elements[3].setCoordonnees(x, y - 2);
        }

        estVertical = !estVertical; // Inverse l'état pour la prochaine rotation
    }

    // Retourne la couleur de la pièce
    @Override
    public Couleur getCouleur() {
        return getCouleur(); // ⚠️ Attention : appel récursif infini — probablement une erreur ici
    }
}

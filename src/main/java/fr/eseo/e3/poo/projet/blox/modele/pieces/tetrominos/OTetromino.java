package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OTetromino extends Tetromino {

    public OTetromino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
        setElements(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        // Élément de référence
        elements[0] = new Element(coordonnees, couleur);
        // Bloc à droite
        elements[1] = new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee(), couleur);
        // Bloc en dessous
        elements[2] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1, couleur);
        // Bloc en diagonale (en bas à droite)
        elements[3] = new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() + 1, couleur);
    }

    @Override
    public Couleur getCouleur() {
        return this.couleur;
    }

    @Override
    public void tourner(boolean sensHoraire) {
        // Les OTetromino ne tournent pas
        // On ne fait rien ici
    }
}

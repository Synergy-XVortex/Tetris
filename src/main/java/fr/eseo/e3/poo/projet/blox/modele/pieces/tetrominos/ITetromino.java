package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

public class ITetromino extends Tetromino {

    public ITetromino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        elements[0] = new Element(coordonnees, couleur);  // Élément de référence
        elements[1] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1, couleur);
        elements[2] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur);
        elements[3] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 2, couleur);
    }
}

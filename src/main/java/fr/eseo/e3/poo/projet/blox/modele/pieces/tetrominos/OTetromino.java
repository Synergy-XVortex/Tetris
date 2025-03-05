package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

public class OTetromino extends Tetromino {

    public OTetromino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
        setElements(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        elements[0] = new Element(coordonnees, couleur);  // Élément de référence
        elements[1] = new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee(), couleur);
        elements[2] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur);
        elements[3] = new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1, couleur);
    }
}

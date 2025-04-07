package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class ITetromino extends Tetromino {

    private boolean estVertical = true; // état de rotation

    public ITetromino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
        setElements(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        // Position verticale par défaut
        elements[0] = new Element(coordonnees, couleur); // centre
        elements[1] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1, couleur);
        elements[2] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur);
        elements[3] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 2, couleur);
    }

    @Override
    public void tourner(boolean sensHoraire) {
        Coordonnees centre = elements[0].getCoordonnees();
        int x = centre.getAbscisse();
        int y = centre.getOrdonnee();

        if (estVertical) {
            // Tourne vers horizontal
            elements[1].setCoordonnees(x + 1, y);
            elements[2].setCoordonnees(x - 1, y);
            elements[3].setCoordonnees(x - 2, y);
        } else {
            // Tourne vers vertical
            elements[1].setCoordonnees(x, y + 1);
            elements[2].setCoordonnees(x, y - 1);
            elements[3].setCoordonnees(x, y - 2);
        }

        estVertical = !estVertical;
    }

    @Override
    public Couleur getCouleur() {
        return getCouleur();
    }
}

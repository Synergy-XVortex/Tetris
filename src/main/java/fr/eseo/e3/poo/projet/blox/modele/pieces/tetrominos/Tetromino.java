package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public abstract class Tetromino implements Piece {

    protected Element[] elements = new Element[4];

    public Tetromino(Coordonnees coordonnees, Couleur couleur) {
        setElements(coordonnees, couleur);
    }

    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    @Override
    public Element[] getElements() {
        return elements;
    }

    @Override
    public void setPosition(int abscisse, int ordonnee) {
        int dx = abscisse - elements[0].getCoordonnees().getAbscisse();
        int dy = ordonnee - elements[0].getCoordonnees().getOrdonnee();

        for (Element element : elements) {
            element.setCoordonnees(new Coordonnees(
                element.getCoordonnees().getAbscisse() + dx,
                element.getCoordonnees().getOrdonnee() + dy
            ));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + " :\n");
        for (Element element : elements) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}

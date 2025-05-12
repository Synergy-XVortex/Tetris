package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public interface Piece {

    Element[] getElements();

    void tourner(boolean sensHoraire);

    Couleur getCouleur();

    void setPosition(int abscisse, int ordonnee);

    void deplacerDe(int deltaX, int deltaY) throws IllegalArgumentException;

}

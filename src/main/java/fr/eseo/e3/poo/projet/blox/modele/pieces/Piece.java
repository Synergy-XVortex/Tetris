package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Element;

public interface Piece {
    
    Element[] getElements();
    
    void setPosition(int abscisse, int ordonnee);
}

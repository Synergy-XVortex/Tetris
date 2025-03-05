package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

// Classe OTetromino qui hérite de Tetromino
public class OTetromino extends Tetromino {
    public OTetromino(int x, int y) {
        super(new Element[]{
            new Element(x, y),
            new Element(x + 1, y),
            new Element(x, y + 1),
            new Element(x + 1, y + 1)
        });
    }
}


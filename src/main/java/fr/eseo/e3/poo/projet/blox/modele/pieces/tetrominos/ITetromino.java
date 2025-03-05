package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

// Classe ITetromino qui hérite de Tetromino
public class ITetromino extends Tetromino {
    public ITetromino(int x, int y) {
        super(new Element[]{
            new Element(x, y),
            new Element(x, y + 1),
            new Element(x, y + 2),
            new Element(x, y + 3)
        });
    }
}

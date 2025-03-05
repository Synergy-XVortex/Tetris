package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

// Classe mère Tetromino
public abstract class Tetromino {
    protected Element[] elements;

    public Tetromino(Element[] elements) {
        this.elements = elements;
    }

    public Element[] getElements() {
        return elements;
    }

    public void afficher() {
        System.out.println(this.getClass().getSimpleName() + " :");
        for (Element e : elements) {
            System.out.println("(" + e.getX() + ", " + e.getY() + ")");
        }
    }
}

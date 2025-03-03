public class OTetromino {
    private Element[] elements; // Tableau d'éléments composant la pièce O

    public OTetromino(int x, int y) {
        // Initialisation des éléments de la pièce O à partir d'une position de référence (x, y)
        elements = new Element[4];
        elements[0] = new Element(x, y);
        elements[1] = new Element(x + 1, y);
        elements[2] = new Element(x, y + 1);
        elements[3] = new Element(x + 1, y + 1);
    }

    public Element[] getElements() {
        return elements;
    }

    public void afficher() {
        System.out.println("OTetromino :");
        for (Element e : elements) {
            System.out.println("(" + e.getX() + ", " + e.getY() + ")");
        }
    }
}

class Element {
    private int x, y;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

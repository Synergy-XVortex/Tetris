package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tas {

    private final Puits puits;
    private final List<Element> elements;

    // Constructeur 1 : Tas vide
    public Tas(Puits puits) {
        this.puits = puits;
        this.elements = new ArrayList<>();
    }

    // Constructeur 2 : n éléments, lignes calculées
    public Tas(Puits puits, int nbElements) {
        this(puits, nbElements, nbElements / puits.getLargeur() + 1);
    }

    // Constructeur 3 : n éléments, m lignes
    public Tas(Puits puits, int nbElements, int nbLignes) {
        this(puits, nbElements, nbLignes, new Random());
    }

    // Constructeur 4 : version complète avec seed contrôlé
    public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {
        this.puits = puits;
        this.elements = new ArrayList<>();
        construireTas(nbElements, nbLignes, rand);
    }

    // Méthode pour créer les éléments dans le tas
    private void construireTas(int nbElements, int nbLignes, Random rand) {
        if (nbLignes > puits.getProfondeur())
            throw new IllegalArgumentException("Nombre de lignes > profondeur du puits");

        int maxElements = puits.getLargeur() * nbLignes;
        if (nbElements > maxElements)
            throw new IllegalArgumentException("Trop d’éléments pour ce nombre de lignes");

        int count = 0;
        while (count < nbElements) {
            int x = rand.nextInt(puits.getLargeur());
            int y = puits.getProfondeur() - rand.nextInt(nbLignes) - 1;

            if (!elementExists(x, y)) {
                elements.add(new Element(x, y, Couleur.values()[rand.nextInt(Couleur.values().length)]));
                count++;
            }
        }
    }

    // Vérifie s’il y a un élément à ces coordonnées
    public boolean elementExists(int abscisse, int ordonnee) {
        for (Element e : elements) {
            if (e.getCoordonnees().getAbscisse() == abscisse &&
                e.getCoordonnees().getOrdonnee() == ordonnee) {
                return true;
            }
        }
        return false;
    }

    // Getters
    public Puits getPuits() {
        return puits;
    }

    public List<Element> getElements() {
        return elements;
    }
}

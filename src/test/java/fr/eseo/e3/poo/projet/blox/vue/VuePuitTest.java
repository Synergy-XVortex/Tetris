package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;

import javax.swing.*;

public class VuePuitTest {

    public static void main(String[] args) {
        // Crée un puits
        Puits puits = new Puits();

        // Crée une fenêtre avec VuePuit
        VuePuit vuePuit = new VuePuit(puits, 30);
        JFrame fenetre = new JFrame("Test VuePuit");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setContentPane(vuePuit);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);

        // Ajoute des pièces successivement
        puits.setPieceSuivante(new OTetromino(new Coordonnees(4, 0), Couleur.ORANGE));
        puits.setPieceSuivante(new ITetromino(new Coordonnees(4, 0), Couleur.CYAN));
    }
}

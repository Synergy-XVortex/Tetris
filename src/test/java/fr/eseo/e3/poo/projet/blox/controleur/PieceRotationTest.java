package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;

public class PieceRotationTest {

    public static void main(String[] args) {
        // Crée le puits
        Puits puits = new Puits(10, 20);

        // Ajoute une pièce I pour bien voir la rotation
        puits.setPieceSuivante(new ITetromino(new Coordonnees(4, 5), Couleur.BLEU));
        puits.setPieceSuivante(new ITetromino(new Coordonnees(4, 5), Couleur.ROUGE));

        // Crée la vue
        VuePuits vuePuits = new VuePuits(puits);

        // Ajoute les contrôleurs
        PieceDeplacement deplacement = new PieceDeplacement(vuePuits);
        PieceRotation rotation = new PieceRotation(vuePuits);

        vuePuits.addMouseMotionListener(deplacement);
        vuePuits.addMouseListener(deplacement);       // pour mouseEntered
        vuePuits.addMouseWheelListener(deplacement);  // pour molette
        vuePuits.addMouseListener(rotation);          // pour clics

        // Crée la fenêtre Swing
        JFrame frame = new JFrame("Test Rotation de la souris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vuePuits);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Redessine pour afficher la pièce dès le départ
        vuePuits.repaint();
    }
}

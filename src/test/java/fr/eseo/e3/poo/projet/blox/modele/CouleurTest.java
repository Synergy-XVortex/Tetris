package fr.eseo.e3.poo.projet.blox.modele;

import javax.swing.*;
import java.awt.*;

public class CouleurTest {

    public static void main(String[] args) {
        // Création de la fenêtre pour afficher les couleurs
        JFrame frame = new JFrame("Test des Couleurs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 3));  // Pour afficher les couleurs dans une grille 2x3

        // Parcours de toutes les couleurs de l'énumération
        for (Couleur couleur : Couleur.values()) {
            JPanel panel = new JPanel();
            panel.setBackground(couleur.getCouleurPourAffichage());  // Définit la couleur de fond du panneau
            panel.setPreferredSize(new Dimension(100, 100));  // Taille des panneaux
            frame.add(panel);
        }

        // Paramétrage de la fenêtre
        frame.pack();
        frame.setLocationRelativeTo(null);  // Centrer la fenêtre
        frame.setVisible(true);
    }
}

package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;

public class VuePuitTest {

    /**
     * Méthode principale pour tester l'affichage de VuePuit.
     */
    public static void main(String[] args) {
        // Création d'un puits de largeur 10 et profondeur 20
        Puits puit = new Puits(10, 20);

        // Création de la vue associée
        VuePuit vuePuit = new VuePuit(puit);

        // Création de la fenêtre d'affichage
        JFrame fenetre = new JFrame("Test VuePuit");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(220, 420); // Ajusté en fonction de la taille des cases
        fenetre.setLocationRelativeTo(null);
        fenetre.setContentPane(vuePuit);
        fenetre.setVisible(true);
    }
}

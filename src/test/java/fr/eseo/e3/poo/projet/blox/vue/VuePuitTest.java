package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VuePuitsTest {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            testVuePuits();
        });
    }

    private static void testVuePuits() {
        // Création du modèle Puits
        Puits puits = new Puits();
        
        // Création de la vue VuePuits
        VuePuits vuePuits = new VuePuits(puits);
        
        // Création de la fenêtre JFrame
        JFrame frame = new JFrame("Test VuePuits");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(vuePuits);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

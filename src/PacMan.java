import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;

public class PacMan extends JPanel{

   private int nbLigne=21;
   private int nbColonne = 19;
   private int tailleTuile=32;
   private int largeurFenetre= nbColonne * tailleTuile;
   private int longueureFenetre = nbLigne * tailleTuile;


   PacMan() {
    setPreferredSize(new Dimension(largeurFenetre, longueureFenetre));
    setBackground(Color.BLACK);
   }

}

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;

public class PacMan extends JPanel{

class Block{

   int x;
   int y;
   int largeur;
   int longueur;
   Image image;

   int debutX;
   int debutY;

   Block(Image image, int x, int y, int largeur, int longueur){

      this.image=image;
      this.x=x;
      this.y=y;
      this.largeur=largeur;
      this.longueur=longueur;
      this.debutX=x;
      this.debutY=y;
   }
}


   private int nbLigne=21;
   private int nbColonne = 19;
   private int tailleTuile=32;
   private int largeurFenetre= nbColonne * tailleTuile;
   private int longueureFenetre = nbLigne * tailleTuile;


   //Image des charactere
   private Image imageMurs;
   private Image fantomeBleu;
   private Image fantomeOrange;
   private Image fantomeRouge;
   private Image fantomeRose;


   private Image pacmanHaut;
   private Image pacmanBas;
   private Image pacmanGauche;
   private Image pacmanDroite;



   //X = murs, O = skip, P = pac man, ' ' = nourriture
    //Fantomes: b = bleu, o = orange, s = rose, g = rouge
    private String[] carteTuile = {
      "XXXXXXXXXXXXXXXXXXX",
      "X        X        X",
      "X XX XXX X XXX XX X",
      "X                 X",
      "X XX X XXXXX X XX X",
      "X    X       X    X",
      "XXXX XXXX XXXX XXXX",
      "OOOX X       X XOOO",
      "XXXX X XXgXX X XXXX",
      "O       bso       O",
      "XXXX X XXXXX X XXXX",
      "OOOX X       X XOOO",
      "XXXX X XXXXX X XXXX",
      "X        X        X",
      "X XX XXX X XXX XX X",
      "X  X     P     X  X",
      "XX X X XXXXX X X XX",
      "X    X   X   X    X",
      "X XXXXXX X XXXXXX X",
      "X                 X",
      "XXXXXXXXXXXXXXXXXXX" 
  };





   HashSet<Block> murs;
   HashSet<Block> nourritures;
   HashSet<Block> fantomes;
   Block pacman;

   PacMan() {
      //Fenetre
    setPreferredSize(new Dimension(largeurFenetre, longueureFenetre));
    setBackground(Color.BLACK);

    //Image
    imageMurs= new ImageIcon(getClass().getResource("./wall.png")).getImage();

    fantomeBleu= new ImageIcon(getClass().getResource("./blueGhost.png")).getImage();
    fantomeOrange= new ImageIcon(getClass().getResource("./orangeGhost.png")).getImage();
    fantomeRouge= new ImageIcon(getClass().getResource("./redGhost.png")).getImage();
    fantomeRose= new ImageIcon(getClass().getResource("./pinkGhost.png")).getImage();

    pacmanHaut= new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
    pacmanBas= new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
    pacmanGauche= new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
    pacmanDroite= new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();

   chargeCarte();

   //test de la carte
   System.out.println(murs.size());
   System.out.println(nourritures.size());
   System.out.println(fantomes.size());
   }


   public void chargeCarte(){
      murs = new HashSet<Block>();
      nourritures = new HashSet<Block>();
      fantomes = new HashSet<Block>();

      //Boucle qui va traverser la carte (tableau 2D)
      //l=ligne
      //c=colonne
      for(int l= 0; l< nbLigne; l++){
         for (int c=0;c<nbColonne;c++){


            String ligne= carteTuile[l];
            char carteTuileChar = ligne.charAt(c);
            int x= c*tailleTuile;
            int y= l*tailleTuile;

            //Si la tuile est sur x, donc murs
            if(carteTuileChar == 'X'){
               Block mur = new Block(imageMurs,x,y,tailleTuile, tailleTuile);
               murs.add(mur);


            }

            else if(carteTuileChar == 'b'){
               Block fantome = new Block(fantomeBleu,x,y,tailleTuile, tailleTuile);
               fantomes.add(fantome);

            }

            else if(carteTuileChar == 's'){
               Block fantome = new Block(fantomeRose,x,y,tailleTuile, tailleTuile);
               fantomes.add(fantome);

            }

            else if(carteTuileChar == 'o'){
               Block fantome = new Block(fantomeOrange,x,y,tailleTuile, tailleTuile);
               fantomes.add(fantome);

            }

            else if(carteTuileChar == 'g'){
               Block fantome = new Block(fantomeRouge,x,y,tailleTuile, tailleTuile);
               fantomes.add(fantome);

            }

            else if(carteTuileChar == 'P'){
               pacman = new Block(pacmanDroite,x,y,tailleTuile,tailleTuile);
            }

            else if(carteTuileChar == ' '){
              Block nourriture = new Block(null,x + 14,y + 14,4,4);
              nourritures.add(nourriture);
            }

         }
      }
   }

}

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        //Puisque chaque carré est 32 pixel, faire 21*32 = longueur, et 19*32 = largeur
       int nbLigne=21;
       int nbColonne = 19;
       int tailleTuile=32;
       int largeurFenetre= nbColonne * tailleTuile;
       int longueureFenetre = nbLigne * tailleTuile;

       //Creation de la fenetre
       JFrame fenetre  = new JFrame("Pac Man");
       //rendre la fenetre visible
       fenetre.setVisible(true);
       //mettre la taille de la fenetre
       fenetre.setSize(largeurFenetre, longueureFenetre);
       //Ouvrir la fenetre dans un endroit visible et centré
       fenetre.setLocationRelativeTo(null);
       //ne pas laisser l'utilisateur reduire/agrandir la fenetre
       fenetre.setResizable(false);
       //Si l'utilisateur veut fermer la fenetre lorque il clique sur x
       fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
   
}

import java.util.*;
import javax.swing.*;
import java.awt.Font;
/**
 * TP4 : Programme de gestion de location de bateaux
 *
 * *@author Sébastien Vermandele
 * @date   2019-05-25
 */

public class TP4 {
    
  public static void main(String[] args) {
    // ... Instruction pour utiliser une police � largeur constante
    UIManager.put("OptionPane.messageFont", new Font("Consolas", Font.PLAIN,12));
    // ... Tableaux pour construire les bateaux
    String[] infosBateaux={"K101:Kayak:1","K102:Kayak:1","K103:Kayak:2",
              "C101:Chaloupe:8","C102:Chaloupe:6","C103:Canot:2","C104:Canot:4","C105:Canot:2",
              "P101:Pedalo:2","P102:Pedalo:4","P103:Pedalo:4"};
    
    int choixMenu = 0;
    
    Compagnie maCompagnie = new Compagnie("LocaBoat", infosBateaux);
    
    do {
    	choixMenu = lireChoixMenu();
    	
    	switch (choixMenu) {
		case 1:
			JOptionPane.showMessageDialog(null, maCompagnie.toString());
			break;
		case 2: // a verifier si besoin de gerer une liste vide ????
			JOptionPane.showMessageDialog(null, formaterListe("Bateau(x) disponible(s)", maCompagnie.chercherBateauxDispo()));
			break;
		case 3:
			JOptionPane.showMessageDialog(null, formaterListe("Location en cours", maCompagnie.chercherLocEnCours()));
			break;
		case 4:
			JOptionPane.showMessageDialog(null, formaterListe("Location terminees", maCompagnie.chercherLocTerminees()));
			break;
		case 5:
			option5(maCompagnie);
			break;
		case 6:
			option6(maCompagnie);
			break;
		case 7:
			option7(maCompagnie);
			break;
		case 8:
			option8(maCompagnie);
			break;
		case 9:
			JOptionPane.showMessageDialog(null, "Merci d'avoir utilise notre application.");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Merci de verifier votre saisi");
			break;
		}
    	
    } while (choixMenu != 9);
    
    
    
    	
    
    
  }
  
  public static int lireChoixMenu(){
    int  choix=0;
    String menu="";
    menu+="============================================================\n";
    menu+="1- Afficher les informations de la compagnie\n";
    menu+="2- Afficher les bateaux disponibles\n";
    menu+="3- Afficher les locations en cours\n";
    menu+="4- Afficher les locations terminees\n";
    menu+="5- Afficher un bateau pour un code\n";
    menu+="6- Afficher une location pour un numero\n";
    menu+="7- Terminer une location\n";
    menu+="8- Commencer une nouvelle location\n";
    menu+="9- Quitter\n";
    menu+="=============================================================\n";

    choix = Integer.parseInt(JOptionPane.showInputDialog(menu));
    
    return choix;  
  }

  // Fonction statique qui retourne une chaine de caracteres avec un titre, 
  // un separateur (ex: ====), et les items de la liste (un par ligne)
  public static String formaterListe(String titre,List liste){
    String message= titre + "\n";
    message += "=========================================================\n";
    for (Object unObjet: liste)
    	message+= unObjet.toString() + "\n";
    return message;
  }

  // Option 5- Afficher un bateau pour un code
  public static void option5(Compagnie cie){
	  String codeBateauCherche = JOptionPane.showInputDialog("Saisir le code du bateau recherché");
	  String message = "Bateau recherché\n";
	  message += "=========================================================\n";
	  message += (cie.chercherBateauParCode(codeBateauCherche) != null) ?
			  cie.chercherBateauParCode(codeBateauCherche).toString():String.format("aucune bateau trouvé sous le code \"%s\"\nVérifier votre saisi", codeBateauCherche);
	  JOptionPane.showMessageDialog(null, message);
  }
  
  // Option 6- Afficher une location pour un num�ro
  public static void option6(Compagnie cie){
	  int numLocationCherche = Integer.parseInt(JOptionPane.showInputDialog("Saisir le numéro de la location du recherchée"));
	  String message = "Location recherchée\n";
	  message += "=========================================================\n";
	  message += cie.chercherLocationParNum(numLocationCherche) != null ? 
			  cie.chercherLocationParNum(numLocationCherche).toString() : String.format("aucune location trouvée sous le numero \"%d\"\nVérifier votre saisi", numLocationCherche);
	  JOptionPane.showMessageDialog(null, message);
  }
  
  // Oprion 7- Terminer une location
  public static void option7(Compagnie cie){
	  int numLocationCherche = Integer.parseInt(JOptionPane.showInputDialog("Saisir le numéro de la location du recherchée"));
	  Location locATerminer = cie.chercherLocationParNum(numLocationCherche);
	  if (locATerminer == null)
		  JOptionPane.showMessageDialog(null,String.format("aucune location trouvée sous le numero \"%d\"\nVérifier votre saisi", numLocationCherche));
	  else if (locATerminer instanceof LocationHeure) {
		  String saisi = JOptionPane.showInputDialog("Saisir l'heure de fin  (hh:mm)");
		  String[] heureFinSaisi = saisi.split(":");
		  cie.terminerUneLocation(locATerminer.getNumLocation(), new Temps(Integer.parseInt(heureFinSaisi[0]), Integer.parseInt(heureFinSaisi[1])));
	  } else
		  cie.terminerUneLocation(locATerminer.getNumLocation());
  }

  // Oprion 8- Commencer une nouvelle location
  public static void option8(Compagnie cie){
	String nomClient = JOptionPane.showInputDialog("Saisir le nom du client");
	String codeBateau = JOptionPane.showInputDialog("Saisir le code du bateau loué");
    if (cie.chercherBateauParCode(codeBateau) == null) // cas où le bateau cherché n'est pas trouvé
    	JOptionPane.showMessageDialog(null,"Code bateau erroné\nOpèration annulee");
    else if (!cie.chercherBateauParCode(codeBateau).getEstDisponible()) // cas où le bateau cherché n'est pas disponible
    	JOptionPane.showMessageDialog(null,String.format("Le bateau \"%s\" n'est pas disponible\nOpèration annulee", codeBateau));
    else {
    	// si bateau trouvé et disponible, demande du code tarif
    	String codeTarif = JOptionPane.showInputDialog(" Saisir le code tarif\n\"j\" - tarif à la journée\n\"h\" - tarif à l'heure");
    	if (codeTarif.equals("h")) {
    		String saisi = JOptionPane.showInputDialog("Saisir l'heure de départ  (hh:mm)");
    		// bloc try catch pour verifier que la saisi de l'heure est correct
    		try { 
    			String[] heureDebutSaisi = saisi.split(":");
        		cie.demarrerUneLocation(nomClient, codeBateau, new Temps(Integer.parseInt(heureDebutSaisi[0]), Integer.parseInt(heureDebutSaisi[1])));
    		} catch (Exception e) {
    			JOptionPane.showMessageDialog(null,"Merci de respecter le format  hh:mm");
			}	
    	} else {
    		if (codeTarif.equals("j"))
    			cie.demarrerUneLocation(nomClient, codeBateau);
    		else
    			JOptionPane.showMessageDialog(null,"Code tarif erroné\nOpération annulee");
    	}
    }
  
  }
}

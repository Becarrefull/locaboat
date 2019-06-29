import java.util.*;
/**
 * TP4 : Classe representant une location
 * 
 *@author Sébastien Vermandele
 * @date   2019-05-25 
 */
public class Location{
	
	// ================ Constantes ===============
	final double TARIF_JOURNEE = 32;
	final double TARIF_PAR_PLACE = 4;

	// ================ Attribut static===============
	private static int prochainNumLocation = 1000;
	
	// ================ Attributs ===============
	protected int numLocation;
	protected String nomClient;
	protected Bateau bateauLoue;
	protected boolean locEnCours;
	
	// ================ Constructeur ===============
	/** Ce constructeur initialise ses 4 attributs avec les 2 param�tres.
	*/
	public Location (String nomClient, Bateau bateauLoue) {
		numLocation = prochainNumLocation;
		this.nomClient = nomClient;
		this.bateauLoue = bateauLoue;
		locEnCours = true;
		prochainNumLocation++;
		bateauLoue.setEstDisponible(false);
	}
	
	// ============= Accesseurs =================
	public int getNumLocation() {
		return numLocation;
	}
	
	public String getNomClient() {
		return nomClient;
	}
	
	public Bateau getBateauLoue() {
		return bateauLoue;
	}
	
	public boolean getLocEnCours() {
		return locEnCours;
	}
	
	// ============= Mutateurs =================
	
	public void setLocEnCours(boolean statut) {
		locEnCours = statut;
	}
	
	// ============= Méthodes =================
	public double calculerPrixLoc() {
		double tarif = TARIF_JOURNEE + (bateauLoue.getCapaciteMax()*TARIF_PAR_PLACE);
		return tarif;
	}
	
	// ============= Méthodes redéfinies =================
	@Override
	public String toString() {
		String message = "[#" + numLocation + "] " + getNomClient();
		if (getLocEnCours()) {
			message += " (Location standard en cours)\n";
			message += "   ====> " + bateauLoue.toString() + "\n";
			message += "   ====> prix à payer : " + calculerPrixLoc() + "$";
		} else {
			message += " (Location Standard terminée)\n";
			message += "=======> montant payé : " + calculerPrixLoc() + "$";
		}
		return message;
	}
	
}

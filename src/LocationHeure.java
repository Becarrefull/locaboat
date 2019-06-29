import java.util.*;
/**
 * TP4 : Classe representant une location à l'heure
 * 			classe heritant de la classe Location
 * 
 *@author Sébastien Vermandele
 * @date   2019-05-25 
 */
public class LocationHeure extends Location {
	
	// ================ Attributs ===============
	Temps heureDebut;
	Temps heureFin;
	
	// =============== Constructeur =============
	public LocationHeure(String nomClient, Bateau bateauLoue, Temps heureDebut) {
		super(nomClient, bateauLoue);
		this.heureDebut = heureDebut;
	}
	
	// ============= Accesseurs =================
	public Temps getHeureFin() {
		return heureFin;
	}
	
	public Temps getHeureDebut() {
		return heureDebut;
	}
	
	// ============= Mutateurs =================
	public void setHeureFin(Temps heureFin) {
		this.heureFin = heureFin;
	}

	// ============== Méthodes =================
	
	
	// ======== Méthodes redéfinies ============
	@Override
	public double calculerPrixLoc() {
		Temps dureeLoc = heureFin.soustraire(heureDebut); 
		double tarif = (TARIF_JOURNEE/4)*Math.round(dureeLoc.obtenirTempsEnHeuresDecimales());
		return tarif;
	}
	
	@Override
	public String toString() {
		String message = "[#" + numLocation + "] " + getNomClient();
		message += " (Location à l'heure, début: " + heureDebut.toString();
		
		if (getLocEnCours()) {
			message += ", fin: ----- )\n";
			message += "   ====> " + bateauLoue.toString() + "\n";
			message += "   ====> prix à payer : à calculer au retour";
		} else {
			message += ", fin: " + getHeureFin().toString() + ", durée: " + heureFin.soustraire(heureDebut) + " )\n";
			message += "=======> montant payé : " + calculerPrixLoc() + "$";
		}
		return message;
	}

}

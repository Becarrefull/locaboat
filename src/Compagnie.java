import java.util.*;
/**
 * TP4 : Classe representant la compagnie
 * 
 *@author Sébastien Vermandele
 * @date   2019-05-25 
 */
public class Compagnie {

	// ================ Attributs ===============
	private String nom;
	private double revenus;
	private List<Bateau> bateaux;
	private List<Location> locations;
	
	// ================ Constructeur ===============
	/** Ce constructeur initialise ses 4 attributs avec les 2 param�tres.
	*/
	public Compagnie(String nom, String[] tabBateaux) {
		this.nom = nom;
		revenus = 0.0;
		bateaux = initialiserListBateau(tabBateaux);
		locations = new ArrayList<>();
	}
	
	// ============= Accesseurs =================
	public double getRevenus() {
		return revenus;
	}
	
	// ============= Mutateurs =================
	
	// ============= Méthodes =================
	
	/** Recupere un tableau de String et recupere les informations afin de creer la List d'objet Bateau
	*/
	public List<Bateau> initialiserListBateau(String[] tabBateaux) {
		List<Bateau> listInitialise = new ArrayList<Bateau>();
		for (String bateau : tabBateaux) {
			String[] detailBateau = bateau.split(":");
			listInitialise.add(new Bateau(detailBateau[0], detailBateau[1], Integer.parseInt(detailBateau[2])));
		}
		return listInitialise;
	}
	
	/** Démarre une location à la journée
	 *  2 paramètres : String non du client, String code du bateau
	 * 	Insère l'objet "Location" créé dans la List "locations"
	*/
	public void demarrerUneLocation(String nomClient, String codeBateau) {
			locations.add(new Location(nomClient, chercherBateauParCode(codeBateau)));
	}
	
	/** Démarre une location à l'heure
	 *  3 paramètres : String non du client, String code du bateau, Objets temps correspondsnt à l'heure de début
	 * 	Insère l'objet "Location" créé dans la List "locations"
	*/
	public void demarrerUneLocation(String nomClient, String codeBateau, Temps heureDebut) {
			locations.add(new LocationHeure(nomClient, chercherBateauParCode(codeBateau), heureDebut));
	}
	
	/** Termine une location à la journée
	 *  modifie le statut de la location dont le num est donné en paramètre
	 *  1 paramètre : int le numero de la location
	 *  retablit le statut du bateau loué à disponible
	 *  comptabilise le total de la prestation de location
	*/
	public void terminerUneLocation(int numLocation) {
		Location uneLocation = chercherLocationParNum(numLocation);
		uneLocation.setLocEnCours(false);
		uneLocation.getBateauLoue().setEstDisponible(true);
		revenus += uneLocation.calculerPrixLoc();
	}
	
	/** Termine une location à l'heure
	 *  modifie le statut de la location dont le num est donné en paramètre
	 *  2 paramètres : int le numero de la location, un objet temps correspondant à l'heure de fin
	 *  retablit le statut du bateau loué à disponible
	 *  insere l'heure de retour passé en paramètre
	 *  comptabilise le total de la prestation de location
	*/
	public void terminerUneLocation(int numLocation, Temps heureFin) {
		LocationHeure uneLocation = (LocationHeure)chercherLocationParNum(numLocation);
		uneLocation.setLocEnCours(false);
		uneLocation.setHeureFin(heureFin);
		uneLocation.getBateauLoue().setEstDisponible(true);
		revenus += uneLocation.calculerPrixLoc();
	}
	
	/** Cherche les bateaux disponibles 
	*   Retourne une List d'objet Bateaux dont le statut est disponibles
	*/
	public List<Bateau> chercherBateauxDispo () {
		List<Bateau> bateauxDispo = new ArrayList<>();
		for (Bateau unBateau : bateaux)
			if (unBateau.getEstDisponible())
				bateauxDispo.add(unBateau);
		return bateauxDispo;
	}
	
	/** Cherche les locations en cours 
	*   Retourne une List d'objet Locations dont le statut est en cours
	*/
	public List<Location> chercherLocEnCours () {
		List<Location> locationsEnCours = new ArrayList<>();
		for (Location uneLocation : locations)
			if (uneLocation.getLocEnCours())
				locationsEnCours.add(uneLocation);
		return locationsEnCours;
	}
	
	/** Cherche les locations terminées 
	*   Retourne une List d'objet Locations dont le statut est terminées
	*/
	public List<Location> chercherLocTerminees () {
		List<Location> locationsTerminees = new ArrayList<>();
		for (Location uneLocation : locations)
			if (!uneLocation.getLocEnCours())
				locationsTerminees.add(uneLocation);
		return locationsTerminees;
	}
	
	/** Cherche un bateau dans la list par son code
	*   Retourne un objet Bateau
	*   Retourne NULL si aucun objet ne correspond
	*/
	public Bateau chercherBateauParCode (String codeBateau) {
		Bateau bateauCherche = null;
		for (Bateau unBateau : bateaux)
			if (unBateau.equals(new Bateau(codeBateau,"",0)))
				bateauCherche = unBateau;
		return bateauCherche;
	}
	
	/** Cherche une location dans la list par son numero
	*   Retourne un objet location (l'objet peut être de type Location ou LocationHeure
	*   Retourne NULL si aucun objet ne correspond
	*/
	public Location chercherLocationParNum (int numLocation) {
		Location locationCherche = null;
		for (Location uneLocation : locations)
			if (uneLocation.getNumLocation() == numLocation)
				locationCherche = uneLocation;
		return locationCherche;
	}
	
	@Override
	public String toString() {
		String message = "";
		message += String.format("Compagnie %s\n", this.nom);
		message += "================================\n";
		message += String.format("Bateaux  disponibles : %6d\n", chercherBateauxDispo().size());
		message += String.format("Locations  en  cours : %6d\n", chercherLocEnCours().size());
		message += String.format("Locations terminées  : %6d\n", chercherLocTerminees().size());
		message += String.format("Revenus              : %6.2f$", revenus);
		return message;
	}
	
	
}

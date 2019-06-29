
public class TestLocationHeure {

	public static void main (String[] args) {
		
		LocationHeure uneLocation1 = new LocationHeure("John Snow", new Bateau("K101","Kayak",2), new Temps(13, 00));
		
		LocationHeure uneLocation2 = new LocationHeure("Lucifer MorningStar", new Bateau("K102","Kayak",4), new Temps(16, 30));
		
		System.out.println(uneLocation1.toString());
		
		System.out.println(uneLocation2.toString());
		
		uneLocation1.setLocEnCours(false);
		uneLocation1.setHeureFin(new Temps(18, 30));
		
		System.out.println(uneLocation1.toString());
		
		System.out.println(uneLocation2.toString());
		
	}
	
}


public class TestLocation {
	
	public static void main (String[] args) {
	
		Location uneLocation1 = new Location("John Snow", new Bateau("K101","Kayak",2));
	
		Location uneLocation2 = new Location("Lucifer MorningStar", new Bateau("K102","Kayak",4));
		
		System.out.println(uneLocation1.toString());
	
		System.out.println(uneLocation2.toString());
		
		uneLocation1.setLocEnCours(false);
		
		uneLocation2.setLocEnCours(false);
		
		System.out.println(uneLocation1.toString());
		
		System.out.println(uneLocation2.toString());
	}

}

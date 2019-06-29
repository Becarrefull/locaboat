import java.util.*;
/**
 * Test pour la classe Bateau
 *
 * @author Pierre Coutu
 * @version 2019-05-04
 */
public class TestBateau {
  
  
  public static void main(String[] args) {

    System.out.println("================ Bateau ===================");
    System.out.println("... Constructeur et affichage ... ");
    Bateau unBateau=new Bateau("K101","Kayak",2);
    System.out.println("Bateau     : "+unBateau);
    System.out.println("... Accesseurs ... ");
    System.out.println("Code       : "+unBateau.getCode());
    System.out.println("Type       : "+unBateau.getType());
    System.out.println("Capacité   : "+unBateau.getCapaciteMax());
    System.out.println("Disponible : "+unBateau.getEstDisponible());
    System.out.println("... Mutateurs (non-disponible) ... ");
    unBateau.setEstDisponible(false); 
    System.out.println("Bateau     : "+unBateau);
    System.out.println("... Comparateurs ... ");
    System.out.println("Bateau K100 == Bateau K101 ? "+unBateau.equals(new Bateau("K100","",0)));
    System.out.println("Bateau K101 == Bateau K101 ? "+unBateau.equals(new Bateau("K101","",0)));
  }
  

  
}

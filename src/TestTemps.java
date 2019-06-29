import java.util.*;
/**
 * Test pour la classe gérant des temps (heures/minutes)
 */
public class TestTemps {
  
  
  public static void main(String[] args) {
    System.out.println("================ Test Temps ===================");
    System.out.println("----- Constructeur, affichage, accesseur");
    Temps unTemps=new Temps(8,2);
    System.out.println("Temps     : "+unTemps);
    System.out.println("Heures    : "+unTemps.getHeures()+"/"+unTemps.getMinutes());
    System.out.println("Minutes   : "+unTemps.getMinutes());
    System.out.println("Décimales : "+unTemps.obtenirTempsEnHeuresDecimales());
    
    System.out.println("-------------");
    System.out.println("\n----- Additions de temps");
    System.out.println("08h02m + 00h01 ="+unTemps.additionner(new Temps(0,1)));
    System.out.println("08h02m + 00h58 ="+unTemps.additionner(new Temps(0,58)));
    System.out.println("08h02m + 02h59 ="+unTemps.additionner(new Temps(1,59)));
    System.out.println("-------------");
    System.out.println("\n----- Soustraction de temps");
    System.out.println("08h02m - 00h01 ="+unTemps.soustraire(new Temps(0,1)));
    System.out.println("08h02m - 00h58 ="+unTemps.soustraire(new Temps(0,58)));
    System.out.println("08h02m - 02h59 ="+unTemps.soustraire(new Temps(1,59)));
    System.out.println("-------------");
    System.out.println("\n----- Triage de temps et compareTo");
    Temps[] lesTemps={new Temps(8,2), new Temps(7,2), new Temps(9,0), new Temps(8,0),
                      new Temps(7,0),new Temps(8,4), new Temps(7,59), new Temps(9,2), new Temps(9,50)};
    Arrays.sort(lesTemps);
    for (Temps temps : lesTemps) { 
      System.out.println(temps+" >= "+unTemps+ " ? "+temps.compareTo(unTemps));
    }
  } 
}

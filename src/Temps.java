/**
 * TP 4 : Classe repr�sentant le temps.
 *
 * @author Pierre Coutu
 * @date   2019-05-04
 */
public class Temps implements Comparable<Temps>{

  // ================ Attributs ===============
  private int heures=0;
  private int minutes=0;

  // =========== Constructeur ================
  /** Ce constructeur initialise ses 2 attributs avec les 2 param�tres.
   */
  public Temps(int lesHeures,int lesMinutes) throws RuntimeException {
    if (lesHeures<0 || lesHeures>23) {
      throw new RuntimeException("Les heures doivent �tre entre 0 et 23 inclusivement.");
    }
    if (lesMinutes<0 || lesMinutes>59) {
      throw new RuntimeException("Les minutes doivent �tre entre 0 et 59 inclusivement.");
    }
    heures=lesHeures;
    minutes=lesMinutes;
  }
  // ============= Accesseurs =================
  // retourne une copies des attributs
  public int getHeures() {
    return heures;
  }
  public int getMinutes() {
    return minutes;
  }

  
  // ============= Autres M�thodes =================
  /** Calcule le temps en heures d�cimales 
    * Ex: 02h00m -> 2.0, 02h15m -> 2.25, ... */
  public double obtenirTempsEnHeuresDecimales() {
    return heures+minutes/60.0;
  }
  /** Permet d'additionner le temps courant avec le temps re�u en param�tre
    * Le r�sultat retourn� est un nouvel objet de type Temps
    * Cette m�thode peut lancer une erreur de type RuntimeException via
    * le constructeur ... */
  public Temps additionner(Temps autre) throws RuntimeException {
    int lesHeures=this.heures+autre.heures;
    int lesMinutes=this.minutes+autre.minutes;
    while (lesMinutes>=60) {
      lesMinutes-=60;
      lesHeures++;
    }
    return new Temps(lesHeures,lesMinutes); // peut lancer une exception via le constrcteur
  }
 
  /** Permet de soustraire du temps courant,  le temps re�u en param�tre
    * Le r�sultat retourn� est un nouvel objet de type Temps
    * Cette m�thode peut lancer une erreur de type RuntimeException via
    * le constructeur ... */
  public Temps soustraire(Temps autre) {
    int lesHeures=this.heures-autre.heures;
    int lesMinutes=this.minutes-autre.minutes;
    while (lesMinutes<0) {
      lesMinutes+=60;
      lesHeures--;
    }
    return new Temps(lesHeures,lesMinutes); // peut lancer une exception via le constrcteur
  }

  // ========== M�thodes red�finies ===========
  /* Formate la repr�sentation en chaine de caract�res
   *  HEUREhMINUTEm (ex:  02h25m, 14h04m, ...) 
   */
  public String toString(){
    String heureString="",minuteString="";
    heureString=String.format("%2d",heures).replace(" ","0");
    minuteString=String.format("%2d",minutes).replace(" ","0");
    return heureString+"h"+minuteString+"m";
  }
  /* Comparaison sur les heures, et en cas d'�galit�, sur les minutes
   */
  public int compareTo(Temps autreTemps){
    int test=0;
    if (this.heures==autreTemps.heures) {
      test=this.minutes-autreTemps.minutes;
    } else {
      test=this.heures-autreTemps.heures;
    }
    return test;
  }

}

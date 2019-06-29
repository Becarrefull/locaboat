import java.util.*;
/*
 * TP4 : Classe repr�sentant un bateau � louer.
 *
 * @author Pierre Coutu
 * @date   2019-05-04
 */
public class Bateau  {

  // ================ Attributs ===============
  private String      code="";
  private String      type="";  // kayak, p�dalo, chaloupe, canoe, ...
  private int         capaciteMax=0;
  private boolean     estDisponible=true;

  // =========== Constructeur ================
  /** Ce constructeur initialise ses 3 attributs avec les 3 param�tres.
   */
  public Bateau(String unCode, String unType, int uneCapacite) throws RuntimeException {
    if (uneCapacite < 0) {
      throw new RuntimeException("La capacit� doit �tre positive");
    }
    code=unCode;
    type=unType;
    capaciteMax=uneCapacite;
  }
  // ============= Accesseurs =================
  // retourne une copies des attributs
  public String getCode() {
    return code;
  }
  public String getType() {
    return type;
  }
  public int getCapaciteMax() {
    return capaciteMax;
  }
  public boolean getEstDisponible() {
    return estDisponible;
  }
  // ============= Mutateurs =================
  // modifie les valeurs des attributs (aucun)
  public void setEstDisponible(boolean nouvelleValeur) {
    estDisponible=nouvelleValeur;
  }

  // ========== Autres methodes ===============
  
// ========== Methodes redefinies ===========
  /* Formate la repr�sentation en chaine de caract�res
   * selon que le travail est compl�t� ou pas :
   *   {CODE} TYPE � CAPACITE_MAX place(s) : DISPONIBILITE 
   */
  public String toString(){
    String message="";
    String disponibilite="non-disponible";
    if (estDisponible) {
      disponibilite="disponible";
    }
    message=String.format("%-6s : %s (%s)","{"+code+"}",type+" � "+capaciteMax+" place(s)",disponibilite);
    return message;
  }
  
  /** Comparaison sur le code */
  public boolean equals(Object autre) {
    Bateau autreBateau;
    if (autre instanceof Bateau) {
      autreBateau=(Bateau) autre;
      return this.code.equals(autreBateau.code);
    } else {
      return false;
    }
  }

}

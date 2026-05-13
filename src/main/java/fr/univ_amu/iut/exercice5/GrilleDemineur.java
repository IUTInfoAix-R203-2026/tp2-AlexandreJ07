package fr.univ_amu.iut.exercice5;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercice 5 - Grille du démineur.
 *
 * <p>Prend en entrée une grille de caractères {@code ' '} et {@code '*'} (où {@code '*'} représente
 * une mine) et produit la même grille annotée : chaque case vide reçoit le nombre de mines dans ses
 * 8 cases voisines (ou reste un espace si aucune mine n'est adjacente).
 *
 * <p>Exemple :
 *
 * <pre>
 *     +-----+     +-----+
 *     | * * |     |1*3*1|
 *     |  *  |  →  |13*31|
 *     |  *  |     | 2*2 |
 *     |     |     | 111 |
 *     +-----+     +-----+
 * </pre>
 *
 * <p>Cet exercice mêle :
 *
 * <ul>
 *   <li>tableaux 2D irréguliers (chaque ligne est une {@link String})
 *   <li>gestion des bornes (cases au bord de la grille)
 *   <li>validation d'entrée (null, symboles, lignes de longueurs différentes)
 *   <li>{@code ApprovalTests} pour une grille de grande taille (voir les tests)
 * </ul>
 */
public class GrilleDemineur {

  private final List<String> grille;

  /**
   * Construit une grille à partir de sa représentation textuelle.
   *
   * @param grilleInitiale lignes de la grille
   * @throws IllegalArgumentException si la grille est {@code null}, contient un caractère autre que
   *     {@code ' '} ou {@code '*'}, ou si les lignes ont des longueurs différentes
   */
  public GrilleDemineur(List<String> grilleInitiale) {
    // TODO exercice 5 : valider l'entrée puis stocker la grille.
    if (grilleInitiale == null) {
      throw new IllegalArgumentException("La grille ne peut pas être null");
    }
    int largeur = -1;
    for (String ligne : grilleInitiale) {
      if (largeur == -1) {
        largeur = ligne.length();
      } else if (ligne.length() != largeur) {
        throw new IllegalArgumentException("Les lignes ont des longueurs différentes");
      }
      for (char c : ligne.toCharArray()) {
        if (c != ' ' && c != '*') {
          throw new IllegalArgumentException("Symbole invalide : " + c);
        }
      }
    }
    this.grille = List.copyOf(grilleInitiale);
  }

  /**
   * Retourne la grille annotée : chaque case vide est remplacée par le nombre de mines adjacentes
   * (ou un espace si aucune), chaque mine reste un {@code '*'}.
   */
  public List<String> getRepresentationAnnotee() {
    List<String> resultat = new ArrayList<>(grille.size());
    // TODO exercice 5 : remplir resultat avec une ligne annotée par ligne d'entrée.
    //
    // Pour chaque case (ligne, col) :
    // - si c'est une mine ('*'), laisser '*'
    // - sinon compter les mines dans les 8 cases voisines (en gérant les bords)
    // - si le compte est > 0, écrire ce chiffre
    // - si le compte est 0, écrire un espace
    //
    // Astuce : une méthode privée compterMinesAdjacentes(int, int) facilite
    // la gestion des bords et rend le code testable.
    for (int ligne = 0; ligne < grille.size(); ligne++) {
      StringBuilder sb = new StringBuilder();
      for (int col = 0; col < grille.get(ligne).length(); col++) {
        if (grille.get(ligne).charAt(col) == '*') {
          sb.append('*');
        } else {
          int count = compterMinesAdjacentes(ligne, col);
          sb.append(count > 0 ? (char) ('0' + count) : ' ');
        }
      }
      resultat.add(sb.toString());
    }
    return resultat;
  }

  private int compterMinesAdjacentes(int ligne, int col) {
    int count = 0;
    for (int dl = -1; dl <= 1; dl++) {
      for (int dc = -1; dc <= 1; dc++) {
        if (dl == 0 && dc == 0) continue;
        int nl = ligne + dl;
        int nc = col + dc;
        if (nl >= 0 && nl < grille.size() && nc >= 0 && nc < grille.get(nl).length()) {
          if (grille.get(nl).charAt(nc) == '*') {
            count++;
          }
        }
      }
    }
    return count;
  }
}

package fr.univ_amu.iut.bonus6;

/**
 * Bonus - StringCalculator (kata Roy Osherove).
 *
 * <p>Kata classique qui pousse le TDD en baby steps dans ses retranchements : chaque nouveau test
 * ajoute une règle incrémentale au parser.
 *
 * <p>Règles :
 *
 * <ol>
 *   <li>Chaîne vide → {@code 0}
 *   <li>{@code "1"} → {@code 1}
 *   <li>{@code "1,2"} → {@code 3}
 *   <li>Un nombre inconnu de valeurs séparées par {@code ','} est autorisé
 *   <li>Le caractère {@code '\n'} est aussi un séparateur : {@code "1\n2,3"} → {@code 6}
 *   <li>Préfixe {@code "//X\n"} définit un délimiteur personnalisé : {@code "//;\n1;2"} → {@code 3}
 *   <li>Un nombre négatif lève une exception listant tous les négatifs : {@code "-1,2,-3"} → {@code
 *       IllegalArgumentException("négatifs interdits : -1, -3")}
 * </ol>
 */
public class StringCalculator {

  /** Retourne la somme des nombres présents dans la chaîne. */
  public int add(String nombres) {
    int somme = 0;
    // TODO bonus : parser la chaîne et sommer les nombres.
    // Activez les tests un par un et n'implémentez que le strict minimum
    // à chaque étape. Le test "chaîne vide" passe directement avec le
    // return 0 par défaut, c'est votre fake it initial.
    return somme;
  }
}

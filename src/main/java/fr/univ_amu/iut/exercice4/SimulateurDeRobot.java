package fr.univ_amu.iut.exercice4;

/**
 * Simulateur qui exécute une séquence de commandes sur un {@link Robot}.
 *
 * <p>Commandes :
 *
 * <ul>
 *   <li>{@code 'R'} - tourner à droite
 *   <li>{@code 'L'} - tourner à gauche
 *   <li>{@code 'A'} - avancer d'une case
 * </ul>
 *
 * <p>Exemple : {@code "RAALAL"} exécuté depuis {@code (7, 3)} en {@link Orientation#NORD} termine
 * en {@code (9, 4)} en {@link Orientation#OUEST}.
 */
public class SimulateurDeRobot {

  private final Robot robot;

  public SimulateurDeRobot(Robot robot) {
    this.robot = robot;
  }

  /**
   * Exécute la séquence de commandes dans l'ordre.
   *
   * @param commandes chaîne composée uniquement des caractères {@code R}, {@code L} et {@code A}
   * @throws IllegalArgumentException si un caractère inconnu est rencontré
   */
  public void executer(String commandes) {
    // TODO exercice 4 : appliquer chaque commande au robot l'une après l'autre.
    // Bonus : levez IllegalArgumentException pour tout caractère autre que R, L, A.

    for (int i = 0; i < commandes.length(); i++) {

      char commande = commandes.charAt(i);

      switch (commande) {
        case 'R' -> robot.tournerADroite();

        case 'L' -> robot.tournerAGauche();

        case 'A' -> robot.avancer();

        default -> throw new IllegalArgumentException("Commande inconnue : '" + commande + "'");
      }
    }
  }

  public Robot getRobot() {
    return robot;
  }
}

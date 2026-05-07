package fr.univ_amu.iut;

import fr.univ_amu.iut.bonus6.StringCalculator;
import fr.univ_amu.iut.exercice1.HelloWorld;
import fr.univ_amu.iut.exercice2.FizzBuzzer;
import fr.univ_amu.iut.exercice3.ConvertisseurDeNombreRomain;
import fr.univ_amu.iut.exercice4.Orientation;
import fr.univ_amu.iut.exercice4.Position;
import fr.univ_amu.iut.exercice4.Robot;
import fr.univ_amu.iut.exercice4.SimulateurDeRobot;
import fr.univ_amu.iut.exercice5.GrilleDemineur;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Lanceur console du TP2 - TDD.
 *
 * <p>Affiche la liste des exercices disponibles et permet d'en lancer un en lisant un numéro sur
 * l'entrée standard.
 */
public class App {

  public static void main(String[] args) {
    Map<String, Runnable> exercices = construireMenu();
    afficherMenu(exercices);

    if (exercices.isEmpty()) {
      return;
    }

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Votre choix : ");
      if (!scanner.hasNextInt()) {
        System.out.println("Entrée invalide.");
        return;
      }
      lancerExercice(exercices, scanner.nextInt());
    }
  }

  static Map<String, Runnable> construireMenu() {
    Map<String, Runnable> exercices = new LinkedHashMap<>();
    exercices.put("Exercice 1 - HelloWorld", App::demoHelloWorld);
    exercices.put("Exercice 2 - FizzBuzz", App::demoFizzBuzz);
    exercices.put("Exercice 3 - Convertisseur romain", App::demoConvertisseurRomain);
    exercices.put("Exercice 4 - Robot et simulateur", App::demoRobot);
    exercices.put("Exercice 5 - Grille du démineur", App::demoGrilleDemineur);
    exercices.put("Bonus - StringCalculator", App::demoStringCalculator);
    return exercices;
  }

  static void afficherMenu(Map<String, Runnable> exercices) {
    System.out.println("=== TP2 - TDD - IUT Aix-Marseille ===");
    System.out.println();
    if (exercices.isEmpty()) {
      System.out.println("Aucun exercice disponible.");
      System.out.println("Ajoutez des exercices dans App.construireMenu() et relancez.");
      return;
    }
    int i = 1;
    for (String titre : exercices.keySet()) {
      System.out.printf("  %d. %s%n", i++, titre);
    }
  }

  static void lancerExercice(Map<String, Runnable> exercices, int choix) {
    if (choix < 1 || choix > exercices.size()) {
      System.out.println("Choix hors des bornes.");
      return;
    }
    String titre = exercices.keySet().toArray(new String[0])[choix - 1];
    System.out.println();
    System.out.println("--- Lancement : " + titre + " ---");
    exercices.get(titre).run();
  }

  // =========================== Démos ===========================

  private static void demoHelloWorld() {
    System.out.println(HelloWorld.saluer(null));
    System.out.println(HelloWorld.saluer("Alice"));
    System.out.println(HelloWorld.saluer("Bob"));
  }

  private static void demoFizzBuzz() {
    FizzBuzzer fb = new FizzBuzzer();
    for (String mot : fb.fizzBuzzJusquA(15)) {
      System.out.println(mot);
    }
  }

  private static void demoConvertisseurRomain() {
    ConvertisseurDeNombreRomain c = new ConvertisseurDeNombreRomain();
    for (String romain : new String[] {"I", "IV", "XLIX", "MCMLXXXIV", "MMMMDCCCLXXXVIII"}) {
      System.out.printf("%-20s -> %d%n", romain, c.enNombreArabe(romain));
    }
  }

  private static void demoRobot() {
    Robot robot = new Robot(new Position(7, 3), Orientation.NORD);
    SimulateurDeRobot simulateur = new SimulateurDeRobot(robot);
    System.out.println(
        "Départ       : " + robot.getPosition() + " orienté " + robot.getOrientation());
    simulateur.executer("RAALAL");
    System.out.println(
        "Après RAALAL : " + robot.getPosition() + " orienté " + robot.getOrientation());
  }

  private static void demoGrilleDemineur() {
    GrilleDemineur g =
        new GrilleDemineur(List.of(" *  * ", "  *   ", "    * ", "   * *", " *  * ", "      "));
    for (String ligne : g.getRepresentationAnnotee()) {
      System.out.println("| " + ligne + " |");
    }
  }

  private static void demoStringCalculator() {
    StringCalculator calc = new StringCalculator();
    for (String entree : new String[] {"", "42", "1,2,3,4,5", "1\n2,3", "//;\n1;2;3"}) {
      System.out.printf(
          "add(%-20s) = %d%n", "\"" + entree.replace("\n", "\\n") + "\"", calc.add(entree));
    }
  }
}

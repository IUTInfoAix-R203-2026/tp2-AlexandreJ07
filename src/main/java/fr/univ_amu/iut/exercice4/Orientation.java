package fr.univ_amu.iut.exercice4;

/**
 * Orientation cardinale du robot.
 *
 * <p>Les valeurs sont ordonnées dans le sens horaire ({@link #NORD} → {@link #EST} → {@link #SUD} →
 * {@link #OUEST}), ce qui simplifie l'implémentation de {@code tournerADroite()} (avance de 1 dans
 * l'ordre) et {@code tournerAGauche()} (recule de 1).
 */
public enum Orientation {
  NORD,
  EST,
  SUD,
  OUEST
}

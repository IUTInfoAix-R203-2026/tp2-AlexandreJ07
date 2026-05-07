package fr.univ_amu.iut.exercice4;

/**
 * Position (x, y) sur la grille infinie.
 *
 * <p>Utiliser un {@code record} garantit automatiquement {@code equals}, {@code hashCode} et {@code
 * toString} basés sur les champs - exactement ce qu'on attend d'une valeur.
 */
public record Position(int x, int y) {}

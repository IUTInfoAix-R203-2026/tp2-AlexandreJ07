package fr.univ_amu.iut.exercice5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

/**
 * Tests de l'exercice 5 : GrilleDemineur.
 *
 * <p>Progression TDD recommandée :
 *
 * <ol>
 *   <li>Cas dégénérés : grille vide, grille sans mine, grille pleine de mines
 *   <li>Cas canoniques : mine unique au centre, diagonales, croix
 *   <li>Validation d'entrée : null, symboles invalides, lignes de largeurs différentes
 *   <li>Une grande grille testée via {@link Approvals#verifyAll} pour introduire
 *       <b>ApprovalTests</b> : plutôt que d'écrire manuellement la matrice attendue dans le test
 *       (source d'erreurs), on sauvegarde la sortie dans un fichier {@code .approved.txt} que l'on
 *       lit visuellement la première fois puis qu'on valide.
 * </ol>
 */
class GrilleDemineurTest {

  // ========= Cas dégénérés =========

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_vide_est_correctement_annotee() {
    assertThat(new GrilleDemineur(Collections.emptyList()).getRepresentationAnnotee())
        .isEqualTo(Collections.emptyList());
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_1_x_1_sans_mine_est_correctement_annotee() {
    List<String> entree = Collections.singletonList(" ");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(entree);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_1_x_1_avec_mine_est_correctement_annotee() {
    List<String> entree = Collections.singletonList("*");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(entree);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_1_x_2_avec_mine_et_case_vide_est_correctement_annotee() {
    List<String> entree = Collections.singletonList(" *");
    List<String> attendue = Collections.singletonList("1*");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(attendue);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_sans_mine_est_correctement_annotee() {
    List<String> entree = Arrays.asList("   ", "   ", "   ");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(entree);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_pleine_de_mines_est_correctement_annotee() {
    List<String> entree = Arrays.asList("***", "***", "***");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(entree);
  }

  // ========= Mine dans un coin (test des bornes) =========

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_avec_une_mine_dans_le_coin_haut_gauche_est_correctement_annotee() {
    List<String> entree = Arrays.asList("*  ", "   ", "   ");
    List<String> attendue = Arrays.asList("*1 ", "11 ", "   ");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(attendue);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_avec_une_mine_dans_le_coin_bas_droit_est_correctement_annotee() {
    List<String> entree = Arrays.asList("   ", "   ", "  *");
    List<String> attendue = Arrays.asList("   ", " 11", " 1*");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(attendue);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_avec_une_mine_unique_au_centre_est_correctement_annotee() {
    List<String> entree = Arrays.asList("   ", " * ", "   ");
    List<String> attendue = Arrays.asList("111", "1*1", "111");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(attendue);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_avec_mines_sur_le_pourtour_est_correctement_annotee() {
    List<String> entree = Arrays.asList("***", "* *", "***");
    List<String> attendue = Arrays.asList("***", "*8*", "***");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(attendue);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_d_une_seule_ligne_avec_deux_mines_est_correctement_annotee() {
    List<String> entree = Collections.singletonList(" * * ");
    List<String> attendue = Collections.singletonList("1*2*1");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(attendue);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_d_une_seule_colonne_avec_deux_mines_est_correctement_annotee() {
    List<String> entree = Arrays.asList(" ", "*", " ", "*", " ");
    List<String> attendue = Arrays.asList("1", "*", "2", "*", "1");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(attendue);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_avec_mines_en_croix_est_correctement_annotee() {
    List<String> entree = Arrays.asList("  *  ", "  *  ", "*****", "  *  ", "  *  ");
    List<String> attendue = Arrays.asList(" 2*2 ", "25*52", "*****", "25*52", " 2*2 ");
    assertThat(new GrilleDemineur(entree).getRepresentationAnnotee()).isEqualTo(attendue);
  }

  // ========= Validation d'entrée =========

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_null_leve_exception() {
    assertThatThrownBy(() -> new GrilleDemineur(null)).isInstanceOf(IllegalArgumentException.class);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_avec_symbole_inconnu_leve_exception() {
    assertThatThrownBy(() -> new GrilleDemineur(Collections.singletonList(" * & ")))
        .isInstanceOf(IllegalArgumentException.class);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grille_avec_lignes_de_tailles_differentes_leve_exception() {
    assertThatThrownBy(() -> new GrilleDemineur(Arrays.asList("*", "**", "* *", "*  *", "*   *")))
        .isInstanceOf(IllegalArgumentException.class);
  }

  // ========= Approval Testing =========

  /**
   * Pour une grande grille, écrire la sortie attendue à la main dans le test est pénible et source
   * d'erreurs. ApprovalTests compare la sortie au contenu d'un fichier {@code
   * GrilleDemineurTest.grandeGrilleAnnotee.approved.txt} situé dans le même dossier que cette
   * classe de test. La première fois, on exécute, on vérifie visuellement le fichier {@code
   * .received.txt} produit, et on le renomme en {@code .approved.txt} pour figer le comportement.
   */
  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_grande_grille_est_correctement_annotee() {
    List<String> entree = Arrays.asList(" *  * ", "  *   ", "    * ", "   * *", " *  * ", "      ");
    List<String> sortie = new GrilleDemineur(entree).getRepresentationAnnotee();
    Approvals.verifyAll("", sortie);
  }
}

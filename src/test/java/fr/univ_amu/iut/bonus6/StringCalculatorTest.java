package fr.univ_amu.iut.bonus6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Tests du kata StringCalculator (Roy Osherove).
 *
 * <p>Progression TDD stricte : on active <b>un seul test à la fois</b>, on implémente le minimum,
 * on refactore, puis on passe au suivant. Chaque test impose une règle supplémentaire.
 */
class StringCalculatorTest {

  private StringCalculator calculette;

  @BeforeEach
  void setUp() {
    calculette = new StringCalculator();
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_calculatrice_avec_une_chaine_vide_retourne_zero() {
    assertThat(calculette.add("")).isZero();
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_calculatrice_avec_un_seul_nombre_retourne_ce_nombre() {
    assertThat(calculette.add("42")).isEqualTo(42);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_calculatrice_additionne_deux_nombres_separes_par_virgule() {
    assertThat(calculette.add("1,2")).isEqualTo(3);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_calculatrice_additionne_un_nombre_arbitraire_de_valeurs() {
    assertThat(calculette.add("1,2,3,4,5")).isEqualTo(15);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_calculatrice_traite_le_saut_de_ligne_comme_separateur() {
    assertThat(calculette.add("1\n2,3")).isEqualTo(6);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_calculatrice_supporte_un_delimiteur_personnalise_via_prefixe() {
    assertThat(calculette.add("//;\n1;2;3")).isEqualTo(6);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_calculatrice_avec_un_nombre_negatif_leve_exception() {
    assertThatThrownBy(() -> calculette.add("-1,2"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("-1");
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void la_calculatrice_avec_plusieurs_negatifs_les_liste_tous_dans_l_exception() {
    assertThatThrownBy(() -> calculette.add("2,-1,3,-4"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("-1")
        .hasMessageContaining("-4");
  }
}

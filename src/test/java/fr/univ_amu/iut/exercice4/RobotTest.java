package fr.univ_amu.iut.exercice4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

/**
 * Tests de l'exercice 4 : Robot + SimulateurDeRobot.
 *
 * <p>Progression TDD :
 *
 * <ol>
 *   <li>Création du robot avec sa position et son orientation initiales
 *   <li>Rotations : chaque cycle de 4 rotations ramène à l'orientation de départ
 *   <li>Avancée : chaque orientation impacte un axe différent
 *   <li>Simulation d'une séquence complète avec {@link SimulateurDeRobot}
 *   <li>Robustesse : commande inconnue → exception
 * </ol>
 */
class RobotTest {

  // ========= Création =========

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_memorise_position() {
    Robot robot = new Robot(new Position(0, 0), Orientation.NORD);
    assertThat(robot.getPosition()).isEqualTo(new Position(0, 0));
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_memorise_orientation() {
    Robot robot = new Robot(new Position(0, 0), Orientation.EST);
    assertThat(robot.getOrientation()).isEqualTo(Orientation.EST);
  }

  // ========= tournerADroite =========

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_tourne_a_droite_depuis_nord_donne_est() {
    Robot robot = new Robot(new Position(0, 0), Orientation.NORD);
    robot.tournerADroite();
    assertThat(robot.getOrientation()).isEqualTo(Orientation.EST);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_tourne_a_droite_depuis_est_donne_sud() {
    Robot robot = new Robot(new Position(0, 0), Orientation.EST);
    robot.tournerADroite();
    assertThat(robot.getOrientation()).isEqualTo(Orientation.SUD);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_tourne_a_droite_depuis_sud_donne_ouest() {
    Robot robot = new Robot(new Position(0, 0), Orientation.SUD);
    robot.tournerADroite();
    assertThat(robot.getOrientation()).isEqualTo(Orientation.OUEST);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_tourne_a_droite_depuis_ouest_donne_nord() {
    Robot robot = new Robot(new Position(0, 0), Orientation.OUEST);
    robot.tournerADroite();
    assertThat(robot.getOrientation()).isEqualTo(Orientation.NORD);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_tourne_a_droite_sans_changer_la_position() {
    Robot robot = new Robot(new Position(3, 7), Orientation.NORD);
    robot.tournerADroite();
    assertThat(robot.getPosition()).isEqualTo(new Position(3, 7));
  }

  // ========= tournerAGauche =========

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_tourne_a_gauche_depuis_nord_donne_ouest() {
    Robot robot = new Robot(new Position(0, 0), Orientation.NORD);
    robot.tournerAGauche();
    assertThat(robot.getOrientation()).isEqualTo(Orientation.OUEST);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_tourne_a_gauche_depuis_ouest_donne_sud() {
    Robot robot = new Robot(new Position(0, 0), Orientation.OUEST);
    robot.tournerAGauche();
    assertThat(robot.getOrientation()).isEqualTo(Orientation.SUD);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_tourne_a_gauche_depuis_sud_donne_est() {
    Robot robot = new Robot(new Position(0, 0), Orientation.SUD);
    robot.tournerAGauche();
    assertThat(robot.getOrientation()).isEqualTo(Orientation.EST);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_tourne_a_gauche_depuis_est_donne_nord() {
    Robot robot = new Robot(new Position(0, 0), Orientation.EST);
    robot.tournerAGauche();
    assertThat(robot.getOrientation()).isEqualTo(Orientation.NORD);
  }

  // ========= avancer =========

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_avance_vers_le_nord_augmente_y() {
    Robot robot = new Robot(new Position(5, 5), Orientation.NORD);
    robot.avancer();
    assertThat(robot.getPosition()).isEqualTo(new Position(5, 6));
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_avance_vers_l_est_augmente_x() {
    Robot robot = new Robot(new Position(5, 5), Orientation.EST);
    robot.avancer();
    assertThat(robot.getPosition()).isEqualTo(new Position(6, 5));
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_avance_vers_le_sud_diminue_y() {
    Robot robot = new Robot(new Position(5, 5), Orientation.SUD);
    robot.avancer();
    assertThat(robot.getPosition()).isEqualTo(new Position(5, 4));
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_avance_vers_l_ouest_diminue_x() {
    Robot robot = new Robot(new Position(5, 5), Orientation.OUEST);
    robot.avancer();
    assertThat(robot.getPosition()).isEqualTo(new Position(4, 5));
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_robot_avance_sans_changer_l_orientation() {
    Robot robot = new Robot(new Position(0, 0), Orientation.NORD);
    robot.avancer();
    assertThat(robot.getOrientation()).isEqualTo(Orientation.NORD);
  }

  // ========= SimulateurDeRobot =========

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_simulateur_execute_raalal_depuis_7_3_nord_donne_position_9_4_ouest() {
    Robot robot = new Robot(new Position(7, 3), Orientation.NORD);
    SimulateurDeRobot simulateur = new SimulateurDeRobot(robot);

    simulateur.executer("RAALAL");

    assertThat(robot.getPosition()).isEqualTo(new Position(9, 4));
    assertThat(robot.getOrientation()).isEqualTo(Orientation.OUEST);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_simulateur_execute_sequence_vide_sans_rien_modifier() {
    Robot robot = new Robot(new Position(5, 5), Orientation.SUD);
    SimulateurDeRobot simulateur = new SimulateurDeRobot(robot);

    simulateur.executer("");

    assertThat(robot.getPosition()).isEqualTo(new Position(5, 5));
    assertThat(robot.getOrientation()).isEqualTo(Orientation.SUD);
  }

  // @Disabled("Retire cette annotation pour activer le test")
  @Test
  void le_simulateur_avec_commande_inconnue_leve_exception() {
    Robot robot = new Robot(new Position(0, 0), Orientation.NORD);
    SimulateurDeRobot simulateur = new SimulateurDeRobot(robot);

    assertThatThrownBy(() -> simulateur.executer("AZ"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}

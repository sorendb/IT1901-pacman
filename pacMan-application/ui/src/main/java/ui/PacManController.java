package ui;

import core.Blinky;
import core.Clyde;
import core.Ghost;
import core.Inky;
import core.PacMan;
import core.PacManUser;
import core.Pinky;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import persistence.PacManPersistence;

// Commented out because of incompatability with Eclipse Che. Works locally.
// import javafx.scene.media.Media;
// import javafx.scene.media.MediaPlayer;

/**
 * Contains the main game loop, and methods controlling the graphical elements
 * in the game.
 */
public class PacManController {

  // Data-oriented and gameloop attributes
  private Inky inky;
  private Pinky pinky;
  private Blinky blinky;
  private Clyde clyde;
  private List<Rectangle> walls;
  private List<Rectangle> testCollisionRectangles;
  private List<Rectangle> inkyCollisionRectangles;
  private List<Rectangle> blinkyCollisionRectangles;
  private List<Rectangle> pinkyCollisionRectangles;
  private List<Rectangle> clydeCollisionRectangles;
  private List<ImageView> pellets;
  private List<Ghost> ghosts;
  private List<ImageView> ghostsPng;
  private Timeline timeline;
  // private MediaPlayer mediaPlayer;
  private PacManUser pacManUser;
  private boolean isTest = false;

  // Fxml-attributes
  @FXML
  private AnchorPane mainBackground;

  @FXML
  private ImageView mapGrid;

  @FXML
  private Button startButton;

  @FXML
  private Rectangle startScreen;

  @FXML
  private Rectangle collisionRect1;
  @FXML
  private Rectangle collisionRect2;
  @FXML
  private Rectangle collisionRect3;
  @FXML
  private Rectangle collisionRect4;
  @FXML
  private Rectangle collisionRect5;
  @FXML
  private Rectangle collisionRect6;
  @FXML
  private Rectangle collisionRect7;
  @FXML
  private Rectangle collisionRect8;
  @FXML
  private Rectangle collisionRect9;
  @FXML
  private Rectangle collisionRect10;
  @FXML
  private Rectangle collisionRect11;
  @FXML
  private Rectangle collisionRect12;
  @FXML
  private Rectangle collisionRect13;
  @FXML
  private Rectangle collisionRect14;
  @FXML
  private Rectangle collisionRect15;
  @FXML
  private Rectangle collisionRect16;
  @FXML
  private Rectangle collisionRect17;
  @FXML
  private Rectangle collisionRect18;
  @FXML
  private Rectangle collisionRect19;
  @FXML
  private Rectangle collisionRect20;
  @FXML
  private Rectangle collisionRect21;
  @FXML
  private Rectangle collisionRect22;
  @FXML
  private Rectangle collisionRect23;
  @FXML
  private Rectangle collisionRect24;

  @FXML
  private Rectangle rect1;
  @FXML
  private Rectangle rect2;
  @FXML
  private Rectangle rect3;
  @FXML
  private Rectangle rect4;
  @FXML
  private Rectangle rect5;
  @FXML
  private Rectangle rect6;
  @FXML
  private Rectangle rect7;
  @FXML
  private Rectangle rect8;
  @FXML
  private Rectangle rect9;
  @FXML
  private Rectangle rect10;
  @FXML
  private Rectangle rect11;
  @FXML
  private Rectangle rect12;
  @FXML
  private Rectangle rect13;
  @FXML
  private Rectangle rect14;
  @FXML
  private Rectangle rect15;
  @FXML
  private Rectangle rect16;
  @FXML
  private Rectangle rect17;
  @FXML
  private Rectangle rect18;
  @FXML
  private Rectangle rect19;
  @FXML
  private Rectangle rect20;
  @FXML
  private Rectangle rect21;
  @FXML
  private Rectangle rect22;
  @FXML
  private Rectangle rect23;
  @FXML
  private Rectangle rect24;
  @FXML
  private Rectangle rect25;
  @FXML
  private Rectangle rect26;
  @FXML
  private Rectangle rect27;

  @FXML
  private ImageView pellet1;
  @FXML
  private ImageView pellet2;
  @FXML
  private ImageView pellet3;
  @FXML
  private ImageView pellet4;
  @FXML
  private ImageView pellet5;
  @FXML
  private ImageView pellet6;
  @FXML
  private ImageView pellet7;
  @FXML
  private ImageView pellet8;
  @FXML
  private ImageView pellet9;
  @FXML
  private ImageView pellet10;
  @FXML
  private ImageView pellet11;
  @FXML
  private ImageView pellet12;
  @FXML
  private ImageView pellet13;
  @FXML
  private ImageView pellet14;
  @FXML
  private ImageView pellet15;
  @FXML
  private ImageView pellet16;
  @FXML
  private ImageView pellet17;
  @FXML
  private ImageView pellet18;
  @FXML
  private ImageView pellet19;
  @FXML
  private ImageView pellet20;
  @FXML
  private ImageView pellet21;
  @FXML
  private ImageView pellet22;
  @FXML
  private ImageView pellet23;
  @FXML
  private ImageView pellet24;
  @FXML
  private ImageView pellet25;
  @FXML
  private ImageView pellet26;
  @FXML
  private ImageView pellet27;
  @FXML
  private ImageView pellet28;
  @FXML
  private ImageView pellet29;
  @FXML
  private ImageView pellet30;
  @FXML
  private ImageView pellet31;
  @FXML
  private ImageView pellet32;
  @FXML
  private ImageView pellet33;
  @FXML
  private ImageView pellet34;
  @FXML
  private ImageView pellet35;
  @FXML
  private ImageView pellet36;
  @FXML
  private ImageView pellet37;
  @FXML
  private ImageView pellet38;
  @FXML
  private ImageView pellet39;
  @FXML
  private ImageView pellet40;
  @FXML
  private ImageView pellet41;
  @FXML
  private ImageView pellet42;
  @FXML
  private ImageView pellet43;
  @FXML
  private ImageView pellet44;
  @FXML
  private ImageView pellet45;
  @FXML
  private ImageView pellet46;
  @FXML
  private ImageView pellet47;
  @FXML
  private ImageView pellet48;
  @FXML
  private ImageView pellet49;
  @FXML
  private ImageView pellet50;
  @FXML
  private ImageView pellet51;
  @FXML
  private ImageView pellet52;
  @FXML
  private ImageView pellet53;
  @FXML
  private ImageView pellet54;
  @FXML
  private ImageView pellet55;
  @FXML
  private ImageView pellet56;

  @FXML
  private TextField usernameInput;

  @FXML
  private Label pacManText;

  @FXML
  private Label username;

  @FXML
  private ImageView pacManGif;
  @FXML
  private ImageView blinkyPng;
  @FXML
  private ImageView pinkyPng;
  @FXML
  private ImageView clydePng;
  @FXML
  private ImageView inkyPng;

  @FXML
  private ImageView yellowPacManPhoto;

  @FXML
  private ImageView greenPacManPhoto;

  @FXML
  private ImageView pinkPacManPhoto;

  @FXML
  private ImageView orangePacManPhoto;

  @FXML
  private ImageView checkMark;

  @FXML
  private Label choosePacManText;

  @FXML
  private Label score;

  @FXML
  private Text scoreText;

  @FXML
  private Label gameOverText;

  @FXML
  private Rectangle gameOverScreen;

  @FXML
  private Button restartGame;

  @FXML
  private TextArea highscores;

  @FXML
  private Button backButton;

  @FXML
  private CheckBox toggleLightmode;

  @FXML
  private ImageView cherry;

  /**
   * Creates the main game-loop for the application.
   * Updates pacmans position and rotation, checks for collisions, updates score,
   * triggers gameover.
   */
  public void createAndConfigureTimeline() {
    this.timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {

        // Updates PacMans position variables
        PacMan.setXposition(PacMan.getXposition() + PacMan.getDx());
        PacMan.setYposition(PacMan.getYposition() + PacMan.getDy());

        // Graphically updates PacMans position
        pacManGif.setLayoutX(PacMan.getXposition());
        pacManGif.setLayoutY(PacMan.getYposition());

        for (int i = 0; i < 4; i++) {
          ghosts.get(i).setXposition(ghosts.get(i).getXposition() + ghosts.get(i).getDx());
          ghosts.get(i).setYposition(ghosts.get(i).getYposition() + ghosts.get(i).getDy());
          ghostsPng.get(i).setLayoutX(ghosts.get(i).getXposition());
          ghostsPng.get(i).setLayoutY(ghosts.get(i).getYposition());
        }

        // Collision check
        if (Collisions.pacManWallCollision(pacManGif, walls)) {
          PacMan.setDx(0);
          PacMan.setDy(0);
        }

        if (Collisions.pacManPelletCollision(pacManGif, pellets)) {
          pacManUser.setScore(pacManUser.getScore() + 10);
        }

        if (pacManUser.getScore() == 40) {
          cherry.setVisible(true);
        }

        if (Collisions.pacManCherryCollision(pacManGif, cherry)) {
          cherry.setVisible(false);
          pacManUser.setScore(pacManUser.getScore() + 100);
        }

        if (Collisions.pacManGhostCollision(pacManGif, ghostsPng)) {
          gameOver();
        }

        inky.pathing(inkyPng, inkyCollisionRectangles);
        blinky.pathing(blinkyPng, blinkyCollisionRectangles);
        pinky.pathing(pinkyPng, pinkyCollisionRectangles);
        clyde.pathing(clydePng, clydeCollisionRectangles);

        // Updates score
        score.setText(Double.toString(pacManUser.getScore()));

        // Rotates PacMan
        pacManGif.setRotate(PacMan.rotationAngle());

        if (pacManUser.getScore() >= 660) {
          gameOver();
        }

      }
    }));
    timeline.setCycleCount(Timeline.INDEFINITE);
  }

  /*
   * Starts main game-loop
   */
  public void startTimeline() {
    timeline.play();
  }

  public void stopTimeline() {
    timeline.stop();
  }

  /**
   * Is executed as game initializes.
   * Initializes music-player, organises FXML-elements into lists, generates
   * PacMan object,
   * hides various FXML-elements from the screen, configures timeline
   */
  public void initialize() {
    // Music-player
    // mediaPlayer = new MediaPlayer(new Media(getClass()
    // .getResource("/ui/PacManAudio.mp3").toString()));
    // //If music ends, restart
    // mediaPlayer.setOnEndOfMedia(new Runnable() {
    // @Override
    // public void run() {
    // mediaPlayer.seek(Duration.ZERO);
    // mediaPlayer.play();
    // }
    // });

    chooseYellowPacMan();

    pacManUser = new PacManUser();
    inky = new Inky();
    pinky = new Pinky();
    blinky = new Blinky();
    clyde = new Clyde();

    inky.reset();
    blinky.reset();
    pinky.reset();
    clyde.reset();

    walls = Arrays.asList(rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10,
        rect11, rect12, rect13, rect14, rect15, rect16, rect17, rect18, rect19,
        rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27);

    pellets = Arrays.asList(pellet1, pellet2, pellet3, pellet4, pellet5, pellet6, pellet7, pellet8,
        pellet9, pellet10, pellet11, pellet12, pellet13, pellet14, pellet15,
        pellet16, pellet17, pellet18, pellet19, pellet20, pellet21, pellet22,
        pellet23, pellet24, pellet25, pellet26, pellet27, pellet28, pellet29,
        pellet30, pellet31, pellet32, pellet33, pellet34, pellet35, pellet36,
        pellet37, pellet38, pellet39, pellet40, pellet41, pellet42, pellet43,
        pellet44, pellet45, pellet46, pellet47, pellet48, pellet49, pellet50,
        pellet51, pellet52, pellet53, pellet54, pellet55, pellet56);

    testCollisionRectangles = Arrays.asList(collisionRect1, collisionRect2,
        collisionRect3, collisionRect4);
    inkyCollisionRectangles = Arrays.asList(collisionRect23, collisionRect12, collisionRect9,
        collisionRect10, collisionRect22, collisionRect21,
        collisionRect15, collisionRect24, collisionRect20,
        collisionRect19, collisionRect14, collisionRect16,
        collisionRect18, collisionRect17, collisionRect5,
        collisionRect6, collisionRect13, collisionRect11,
        collisionRect7, collisionRect8);
    blinkyCollisionRectangles = Arrays.asList(collisionRect6, collisionRect13, collisionRect11,
        collisionRect7, collisionRect8, collisionRect20,
        collisionRect19, collisionRect14, collisionRect16,
        collisionRect18, collisionRect17, collisionRect5);
    pinkyCollisionRectangles = Arrays.asList(collisionRect3, collisionRect4,
        collisionRect1, collisionRect2);
    clydeCollisionRectangles = Arrays.asList(collisionRect21, collisionRect15, collisionRect3,
        collisionRect4, collisionRect12, collisionRect9,
        collisionRect10, collisionRect22);

    ghostsPng = Arrays.asList(inkyPng, pinkyPng, blinkyPng, clydePng);
    ghosts = Arrays.asList(inky, pinky, blinky, clyde);

    setComponentsVisible(false, gameOverScreen, gameOverText, restartGame, highscores, cherry);
    startButton.setDisable(true);

    createAndConfigureTimeline();

    PacMan.setXposition(330);
    PacMan.setYposition(115);
    PacMan.setRotate("RIGHT");

    updateGui();
  }

  protected ImageView getPacManGif() {
    return pacManGif;
  }

  public PacManUser getPacManUser() {
    return new PacManUser(pacManUser);
  }

  public List<ImageView> getGhosts() {
    return Collections.unmodifiableList(ghostsPng);
  }

  public List<Rectangle> getTestCollisionRectangles() {
    return Collections.unmodifiableList(testCollisionRectangles);
  }

  public boolean getIsTest() {
    return isTest;
  }

  public void setIsTest(boolean isTest) {
    this.isTest = isTest;
  }

  /**
   * Disables the startbutton if the username is invalid.
   */
  @FXML
  public void updateGui() {
    startButton.setDisable(true);
    String name = usernameInput.getText();
    if (!PacManUser.validateUsername(name)) {
      startButton.setDisable(true);
    } else {
      startButton.setDisable(false);
    }
  }

  /**
   * Hides the startscreen and starts the game and music when startbutton is
   * pressed.
   * Updates map to light- or darkmode depending on users choice in startscreen
   */
  @FXML
  private void handleStartButton() {
    // mediaPlayer.play();
    try {

      setComponentsVisible(false, startButton, startScreen, username,
          usernameInput, pacManText, toggleLightmode, checkMark, choosePacManText,
          yellowPacManPhoto, greenPacManPhoto, pinkPacManPhoto, orangePacManPhoto);

      if (toggleLightmode.isSelected()) {
        mapGrid.setImage(new Image(getClass()
            .getResource("/ui/applicationImages/gameElementImages/mapgridLight.png")
            .toExternalForm()));

        for (ImageView pellet : pellets) {
          pellet.setImage(new Image(getClass()
              .getResource("/ui/applicationImages/gameElementImages/smalldotLight.png")
              .toExternalForm()));
        }
        scoreText.setFill(Color.BLACK);
        score.setTextFill(Color.BLACK);
      } else {
        mapGrid.setImage(new Image(getClass()
            .getResource("/ui/applicationImages/gameElementImages/mapgrid.png")
            .toExternalForm()));

        for (ImageView pellet : pellets) {
          pellet.setImage(new Image(getClass()
              .getResource("/ui/applicationImages/gameElementImages/smalldot.png")
              .toExternalForm()));
        }
        scoreText.setFill(Color.WHITE);
        score.setTextFill(Color.WHITE);
      }

      startTimeline();

      score.setText("0");

      setComponentsVisible(true, scoreText, score);

      pacManUser.setUsername(usernameInput.getText());
      pacManUser.setScore(0);

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Could not start game");
    }
  }

  /**
   * Stops game and music when all pellets are collected.
   * Displays gameover-screen with highscores.
   * Saves userdata to file.
   */
  public void gameOver() {
    timeline.stop();

    // Save score to username in file
    Platform.runLater(() -> {
      String path = "";
      if (isTest) {
        path = "src/main/resources/ui/JSON/apptestScores.json";

      } else {
        path = "src/main/resources/ui/JSON/scores.json";

      }

      PacManPersistence.saveHighscore(pacManUser.getUsername(), pacManUser.getScore(),
          path);

      // Displays score in scoreboard
      String usersString = "";
      List<PacManUser> userArray = PacManPersistence
          .fetchHighscore(path);
      StringBuffer buf = new StringBuffer();
      for (PacManUser user : userArray) {
        buf.append(user.toString());
      }
      usersString = buf.toString();

      highscores.setText(usersString);

      // Deletes content of apptestScores.json file
      if (isTest) {
        try {
          new FileWriter("src/main/resources/ui/JSON/apptestScores.json",
              StandardCharsets.UTF_8, false).close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

    // Set GameOver screen visible
    setComponentsVisible(true, gameOverScreen, gameOverText, restartGame,
        highscores, toggleLightmode);
  }

  /**
   * Restarts game when restart button is pressed.
   * Resets Pacman's position, speed, direction and score.
   * Displays the startscreen.
   */
  @FXML
  private void handleRestartGameButton() {
    setComponentsVisible(false, gameOverScreen, gameOverText, restartGame, highscores, cherry);

    usernameInput.clear();

    setComponentsVisible(true, startButton, startScreen, username,
        choosePacManText, yellowPacManPhoto, greenPacManPhoto,
        pinkPacManPhoto, orangePacManPhoto, usernameInput, pacManText);

    for (ImageView pellet : pellets) {
      pellet.setVisible(true);
    }
    pacManGif.setLayoutX(330);
    pacManGif.setLayoutY(115);

    chooseYellowPacMan();
    pacManUser.reset();
    PacMan.reset();
    inky.reset();
    blinky.reset();
    pinky.reset();
    clyde.reset();

    updateGui();

  }

  @FXML
  private void chooseYellowPacMan() {
    checkMark.setLayoutX(427);
    checkMark.setLayoutY(242);
    checkMark.setVisible(true);
    pacManGif.setImage(new Image(getClass()
        .getResource("/ui/applicationImages/pacManImages/PacManModelYellow.gif")
        .toExternalForm()));
  }

  @FXML
  private void chooseGreenPacMan() {
    checkMark.setLayoutX(497);
    checkMark.setLayoutY(242);
    checkMark.setVisible(true);
    pacManGif.setImage(new Image(getClass()
        .getResource("/ui/applicationImages/pacManImages/PacManModelGreen.gif")
        .toExternalForm()));
  }

  @FXML
  private void choosePinkPacMan() {
    checkMark.setLayoutX(565);
    checkMark.setLayoutY(242);
    checkMark.setVisible(true);
    pacManGif.setImage(new Image(getClass()
        .getResource("/ui/applicationImages/pacManImages/PacManModelPink.gif")
        .toExternalForm()));
  }

  @FXML
  private void chooseOrangePacMan() {
    checkMark.setLayoutX(625);
    checkMark.setLayoutY(242);
    checkMark.setVisible(true);
    pacManGif.setImage(new Image(getClass()
        .getResource("/ui/applicationImages/pacManImages/PacManModelOrange.gif")
        .toExternalForm()));
  }

  private void setComponentsVisible(boolean isVisible, Node... components) {
    for (Node component : components) {
      component.setVisible(isVisible);
    }
  }
}

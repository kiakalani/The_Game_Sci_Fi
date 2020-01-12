import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;

/**
 * @author Kia
 * @version 1.00
 * <code>GamePage</code> includes all of the necessary contents inside the game itself.
 */
public class GamePage extends DefaultScreen {
    /**
     * A linkedlist that contains all of the zombies inside itself.
     */
    private final LinkedList<Zombie> zombies = new LinkedList<>();
    /**
     * The <code>Player</code> of the game.
     */
    private final Player player=new Player(getChildren(), zombies);

    /**
     * The constructor
     */
    public GamePage() {
        MainMenu.audio = new Audio("Audio/SG111.wav");
        MainMenu.audio.playNormal();
        setBackground();
        this.getChildren().add(player);
        this.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                player.setOnPressed(event);
                if (event.getCode()== KeyCode.ESCAPE) {
                    player.stopUpdating();
                    Run.changeScene(new MainMenu().getScene());
                }
            }
        });
        this.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                player.setOnReleased(event);
            }
        });
        this.getScene().setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                player.setOnMoved(event);
            }
        });
        this.getScene().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                player.shoot(event,getChildren());
            }
        });
        zombies.add(new Zombie(getChildren()));

    }

    /**
     * This method would set the background behind the players and the zombies.
     */
    private void setBackground() {
        ImageView background = new ImageView(new Image("img/background.png"));
        background.setFitWidth(relativeX(100));
        background.setFitHeight(relativeY(100));
        getChildren().add(background);
        //
    }
}

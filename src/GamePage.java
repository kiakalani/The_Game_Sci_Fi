import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;

public class GamePage extends DefaultScreen {
    private final LinkedList<Zombie> vanyas = new LinkedList<>();
    private final Player player=new Player(getChildren(),vanyas);

    public GamePage() {
        setBackground();
        this.getChildren().add(player);
        this.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                player.setOnPressed(event);
                if (event.getCode()== KeyCode.ESCAPE) {
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
        vanyas.add(new Zombie(getChildren()));

    }
    private void setBackground() {
        ImageView background = new ImageView(new Image("img/background.png"));
        background.setFitWidth(relativeX(100));
        background.setFitHeight(relativeY(100));
        getChildren().add(background);
    }
}

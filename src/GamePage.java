import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GamePage extends DefaultScreen {
    private final Player player=new Player();
    public GamePage() {
        this.getChildren().add(player);
        this.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                player.setOnPressed(event);
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
    }
}
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainMenu extends Group {
    private final Scene scene= new Scene(this);
    public MainMenu() {
        getChildren().add(new Rectangle(Run.relativeX(90),Run.relativeY(90), Color.RED));
    }
}

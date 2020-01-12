import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class DefaultScreen extends Group {
    private final Scene scene = new Scene(this,Run.relativeX(100),Run.relativeY(100));

    public double relativeX(double x) {
        return Run.relativeX(x);
    }
    public double relativeY(double y) {
        return Run.relativeY(y);
    }
    public DefaultScreen() {
        getScene().setCursor(Cursor.CROSSHAIR);
    }
}

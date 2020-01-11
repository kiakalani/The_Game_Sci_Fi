import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;

public abstract class DefaultScreen extends Group {
    private final Scene scene = new Scene(this,Run.relativeX(100),Run.relativeY(100));
    private double relativeX(double x) {
        return Run.relativeX(x);
    }
    private double relativeY(double y) {
        return Run.relativeY(y);
    }
    public DefaultScreen() {
        getScene().setCursor(Cursor.NONE);
    }
}

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Kia
 * @version 1.00
 * <code>DefaultScreen</code> refers to the template of the display including the shape
 * of the cursor as well as considering the maximum size of the screen as the template size
 * of its screen.
 */
public abstract class DefaultScreen extends Group {
    /**
     * Creating the scene of the display
     */
    private final Scene scene = new Scene(this,Run.relativeX(100),Run.relativeY(100));

    /**
     * This method would return the position according to the percentage provided
     * for the x axis
     * @param x refers to the percentage of the x axis
     * @return the actual position by considering the percentage provided
     */
    public double relativeX(double x) {
        return Run.relativeX(x);
    }
    /**
     * This method would return the position according to the percentage provided
     * for the y axis
     * @param y refers to the percentage of the y axis
     * @return the actual position by considering the percentage provided
     */
    public double relativeY(double y) {
        return Run.relativeY(y);
    }

    /**
     * The constructor
     */
    public DefaultScreen() {
        getScene().setCursor(Cursor.CROSSHAIR);
    }
}

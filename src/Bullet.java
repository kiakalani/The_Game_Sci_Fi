import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @version 1.00
 * <code>Bullet</code> class is responsible for creating the bullets being
 * shot by the player
 * <b>Note:</b>
 * For further information about the usage of this class see
 * {@link Player}
 */
public class Bullet extends ImageView {
    /**
     * The pointing position of the bullet.
     */
    private double angle;

    /**
     * The constructor
     * @param angle is the angle of the bullet
     */
    public Bullet(double angle) {
        this.setImage(new Image("img/Bullet.png"));
        this.setFitWidth(Run.relativeX(2));
        this.setFitHeight(Run.relativeY(2));
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }
}

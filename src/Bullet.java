import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet extends ImageView {
    private double angle;
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
